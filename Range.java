import java.util.NoSuchElementException;
public class Range implements IntegerSequence{
  private int start,end,current;
  public Range(int start,  int end){  }
  public void reset(){  }
  public int length(){return 0;}
  public boolean hasNext(){return false;}

  //@throws NoSuchElementException
  public int next(){return 0;}
  
}