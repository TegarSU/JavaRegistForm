import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
 
//import javax.swing.JFormattedTextField.AbstractFormatter;
 
public class RegistrationForm implements ActionListener {
    //Creating object of JFrame class
    JFrame frame;
    
    LabelCheck emailLabel=new LabelCheck("EMAIL");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel nameLabel=new JLabel("NAMA");
    JLabel addressLabel=new JLabel("ALAMAT");
    JLabel ktpLabel=new JLabel("NO KTP");
    JLabel scLabel=new JLabel("SCAN KTP");
    JLabel dateLabel=new JLabel("TANGGAL LAHIR");
    JLabel tlpLabel=new JLabel("NOMOR TELEPON");
    JLabel anggotaLabel=new JLabel("JENIS ANGGOTA");
    
    String[] gender={"GOLD","PLATINUM","DIAMOND"};
    //String day_arr[]=new String[31];
    //String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" };
    //String year_arr[]=new String[70];
    
    
    EmailCheck emailTextField=new EmailCheck();
    JPasswordField passwordField=new JPasswordField();
    JTextField nameTextField=new JTextField();
    JTextField addressTextField=new JTextField();
    JTextField ktpTextField=new JTextField();
    JButton scButton=new JButton("PILIH FILE");
    JTextField dateTextField=new JTextField();
    JTextField tlpTextField=new JTextField();
    JComboBox anggotaComboBox=new JComboBox(gender);
    //JPasswordField confirmPasswordField=new JPasswordField();
    //JTextField cityTextField=new JTextField();
    
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    
    RegistrationForm()
    {
        
        createWindow();//calling method from constructor
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow()
    {
       //Setting properties of JFrame
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.pink);
        
        //frame.add(datePicker);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
    }
    
    public void setLocationAndSize()
    {
        //Setting Location and Size of Each Component
        emailLabel.setBounds(20,20,40,70);
        passwordLabel.setBounds(20,70,80,70);
        nameLabel.setBounds(20,120,100,70);
        addressLabel.setBounds(20,170,100,70);
        ktpLabel.setBounds(20,220,140,70);
        scLabel.setBounds(20,270,100,70);
        dateLabel.setBounds(20,320,100,70);
        tlpLabel.setBounds(20,370,100,70);
        anggotaLabel.setBounds(20,420,100,70);
        
        emailTextField.setBounds(180,40,165,23);
        passwordField.setBounds(180,90,165,23);
        nameTextField.setBounds(180,140,165,23);
        addressTextField.setBounds(180,190,165,23);
        ktpTextField.setBounds(180,240,165,23);
        scButton.setBounds(180,290,165,23);
        //ktpTextField.setBounds(180,320,165,23);
        dateTextField.setBounds(180,340,165,23);
        //anggotaComboBox.setBounds(180,390,165,23); 
        tlpTextField.setBounds(180,390,165,23);
        anggotaComboBox.setBounds(180,440,165,23);
        registerButton.setBounds(100,480,100,35);
        resetButton.setBounds(200,480,100,35);
    }
    
    public void addComponentsToFrame()
    {
        //Adding components to Frame
        frame.add(emailLabel);
        frame.add(passwordLabel);
        frame.add(nameLabel);
        frame.add(addressLabel);
        frame.add(ktpLabel);
        frame.add(scLabel);
        frame.add(dateLabel);
        frame.add(tlpLabel);
        frame.add(anggotaLabel);
        
        frame.add(emailTextField);
        frame.add(passwordField);
        frame.add(nameTextField);
        frame.add(addressTextField);
        frame.add(ktpTextField);
        frame.add(scButton);
        frame.add(dateTextField);
        frame.add(anggotaComboBox);
        frame.add(tlpTextField);
        frame.add(registerButton);
        frame.add(resetButton);
        
        emailTextField.attach(emailLabel);
    }
    
    public void actionEvent()
    {
       //Adding Action Listener to buttons
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fp_ppl","root","");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into registermodel (email,password,nama,alamat,no_ktp,tgl_lahir,no_telp,jenis_anggota) values(?,?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,emailTextField.getText());
                Pstatement.setString(2,passwordField.getText());
                Pstatement.setString(3,nameTextField.getText());
                Pstatement.setString(4,addressTextField.getText());
                Pstatement.setString(5,ktpTextField.getText());
                Pstatement.setString(6,dateTextField.getText());
                Pstatement.setString(7,tlpTextField.getText());
                Pstatement.setString(8,anggotaComboBox.getSelectedItem().toString());
                
                if(emailTextField.getText()!="tegar@gmail.com")
                {
                    emailLabel.Notify();
                }
                
               
                
                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Registered Successfully");
         
                //Checking for the Password match
                /*if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }*/
 
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            
            emailTextField.setText("");
            passwordField.setText("");
            nameTextField.setText("");
            addressTextField.setText("");
            ktpTextField.setText("");
            dateTextField.setText("");
            tlpTextField.setText("");
            anggotaComboBox.setSelectedItem("Male");
        }
 
    }
}