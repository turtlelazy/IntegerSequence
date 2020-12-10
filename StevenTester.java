import java.util.*;
import java.io.*;

public class StevenTester {
    public static void main(String args[]){
        /*
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
        */
        System.out.println("----array input based tests----");
        int[]nums = {1,3,5,0,-1,3,9};
        int[]nums2 = {93, 94, 0, 21, -3};
        IntegerSequence a1 = new ArraySequence(nums);
        IntegerSequence a2 = new ArraySequence(nums2);
        System.out.println("constructor test: good");

        if(a1.length()!=7) throw new Error("a1.length() does not match with length 7.");
        if(a2.length()!=5) throw new Error("a2.length() does not match with length 5.");
        System.out.println("length() test: good.");
        if(!("[" + sequenceToString(a1) + "]").equals(Arrays.toString(nums))) throw new Error ("failure calling hasNext() and/or next() on ArraySequence a1");
        if(!("[" + sequenceToString(a2) + "]").equals(Arrays.toString(nums2))) throw new Error ("failure calling hasNext() and/or next() on ArraySequence a2");
        System.out.println("hasNext() and next() test: good.");

        String result = "reset(): good";
        try{
            a1.reset();
            a1.next();
        } catch (NoSuchElementException e){
            result = ("reset failed on ArraySequence roo");
            e.printStackTrace();
        }

        System.out.println(result);


        System.out.println("----Range  input based tests----");
        IntegerSequence r = new Range(-20,50);
        IntegerSequence t = new Range(-9,2);
        t.next();
        r.next();
        IntegerSequence roo = new ArraySequence(r);
        IntegerSequence too = new ArraySequence(t);
        System.out.println("constructor test: good");

        if(roo.length()!=71) throw new Error("roo.length() does not match with length 71.");
        if(too.length()!=12) throw new Error("too.length() does not match with length 12.");
        System.out.println("length() test: good.");

        String rooString = "-20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50";
        String tooString = "-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2";

        if(!sequenceToString(roo).equals(rooString)) throw new Error ("failure calling hasnext() and/or next() on ArraySequence roo.");
        if(!sequenceToString(too).equals(tooString)) throw new Error ("failure calling hasnext() and/or next() on ArraySequence roo.");
        System.out.println("has next() and next() test: good");

        String result1 = "reset(): good";
        try{
            roo.reset();
            roo.next();
        } catch (NoSuchElementException e){
            result1 = ("reset failed on ArraySequence roo");
            e.printStackTrace();
        }
        System.out.println(result1);
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
