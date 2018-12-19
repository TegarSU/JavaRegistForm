
/**
 * Write a description of class LabelCheck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class LabelCheck extends JLabel implements ObserverEmail
{
    public LabelCheck(String label)
    {
        this.setText(label);
    
    }
    
    @Override
    public void Notify()
    {
        this.setForeground(Color.red);
        
    }
    
}
