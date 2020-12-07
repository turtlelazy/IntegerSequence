import java.util.NoSuchElementException;

public class StevenTester {
    public static void main(String args[]){
        IntegerSequence a = new Range(10,15);
        IntegerSequence b = new Range(1,15);
        IntegerSequence c = new Range(-30,15);
        String aAsString = "10, 11, 12, 13, 14, 15";
        String bAsString = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15";
        String cAsString = "";
        for(int i = -30; i < 16; i++){
            if (i!=15) cAsString += i + ", ";
            else cAsString+=i;
        }

        String testOut = "good";
        if (a.length() != 6) throw new Error("a.length() does not match with length 6.");
        if (b.length() != 15) throw new Error("b.length() does not match with length 15.");
        if (c.length() != 46) throw new Error("c.length() does not match with length 46.");
        System.out.println("Length test: " + testOut);
        if (!sequenceToString(a).equals(aAsString)) throw new Error("failure calling hasNext() and/or next() on IntegerSequence a");
        if (!sequenceToString(b).equals(bAsString)) throw new Error("failure calling hasNext() and/or next() on IntegerSequence b");
        if (!sequenceToString(c).equals(cAsString)) throw new Error("failure calling hasNext() and/or next() on IntegerSequence c");
        System.out.println("hasNext() and next() test: " + testOut);

        testOut = "reset() test: good";
        try{
            b.reset();
            b.next();
        }
        catch (NoSuchElementException e){
            testOut = "reset() failed on IntegerSequence b";
        }
        System.out.println(testOut);
    }
    public static String sequenceToString(IntegerSequence r){
        String str = "";
        while(r.hasNext()){
            str+=r.next();
            if(r.hasNext())str+=", ";
        }
        return str;
    }
}
