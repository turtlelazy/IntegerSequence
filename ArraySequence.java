import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{
  private int currentIndex;
  private int[] data;

  /*Construct the sequence by copying values from the other array into the data array*/
  public ArraySequence(int [] other){  
    data = other;
    currentIndex = 0;
  }

  public boolean hasNext() {
      return currentIndex < data.length;
  }

  public void reset(){
      currentIndex = 0;
  }

  public int length(){
      return data.length;
  }

  public int next(){
      if (!hasNext()) {
          throw new NoSuchElementException();
      } else {
          currentIndex++;
          return data[currentIndex - 1];
      }
  }

  public ArraySequence(IntegerSequence otherseq){
      otherseq.reset();
      data = new int[otherseq.length()];
      for(int i = 0;i<otherseq.length();i++){
        data[i] = otherseq.next();
      }
      otherseq.reset();
  }
}