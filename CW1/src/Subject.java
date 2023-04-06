import java.util.ArrayList;
import java.util.List;
//Interface declaration for Subject (Observer Pattern)
public interface Subject {
    List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
