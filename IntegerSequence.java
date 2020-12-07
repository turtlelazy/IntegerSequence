import java.util.NoSuchElementException;
public interface IntegerSequence{
    boolean hasNext();

    int next(); 

    int length(); 

    void reset(); 


}