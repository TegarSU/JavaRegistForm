
/**
 * Write a description of interface Subject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Subject
{
    public void attach(ObserverEmail observer);
    public void detach(ObserverEmail observer);
    public void Update();
}
