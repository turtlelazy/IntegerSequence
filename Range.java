import java.util.NoSuchElementException;
public class Range implements IntegerSequence{
  private int start,end,current;
  public Range(int start,  int end){  
      this.start = start;
      this.end = end;
      current = start;
  }

  public void reset(){  
      current = start;
  }

  public int length(){
      return end - start;
    }

  public boolean hasNext(){
      return length() > end-current;
}

  //@throws NoSuchElementException
  public int next(){
      if (!hasNext()){
          throw new NoSuchElementException();
      }
      else{
          return current+1;
      }
  }
  
}