
/**
 * Write a description of class EmailCheck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.util.*;

public class EmailCheck extends JTextField implements Subject
{
    List<ObserverEmail> list_observer = new ArrayList<>();
    @Override
    public void attach(ObserverEmail observer)
    {
        list_observer.add(observer);
        
    }
    @Override
    public void detach(ObserverEmail observer)
    {
        list_observer.remove(observer);
        
    }
    @Override
    public void Update()
    {
        for(ObserverEmail observer:list_observer)
        {
            observer.Notify();
        }
        
    }
}
