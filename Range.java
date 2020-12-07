import java.util.NoSuchElementException;
public class Range implements IntegerSequence{
  private int start,end,current;
  public Range(int start,  int end){  
      this.start = start;
      this.end = end;
      current = this.start;
  }

  public void reset(){  
      current = start;
  }

  public int length(){
      return end + 1 - start;
    }

  public boolean hasNext(){
      return 0 < end + 1-current;
}

  //@throws NoSuchElementException
  public int next(){
      if (!hasNext()){
          throw new NoSuchElementException();
      }
      else{
          current ++;
          return current-1;
      }
  }
  
}