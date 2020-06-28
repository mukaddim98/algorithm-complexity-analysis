import java.util.Scanner;
import java.util.ArrayList;

public class Collatz {
    public static void main(String [] args){
        Scanner kb = new Scanner(System.in);
        long num = kb.nextLong();

        // execution time calculation variables
        long startTime, endTime, executionTime;
        while(num != 0){
            startTime = System.currentTimeMillis(); // start timer
            System.out.print(num+" "+longestSeq(num)[0]+" "+longestSeq(num)[1]);
            endTime = System.currentTimeMillis(); // end timer
            executionTime = endTime - startTime;
            System.out.println(" "+executionTime);
            num = kb.nextLong();
        }
    }

    public static long[] longestSeq(long n){
        long largestNum = -1; // number for the largest sequence
        int largestLength = 1; // length of the largest sequence
        int currLength; // current length for a current sequence

        // ArrayList used to store the lengths of the sequences; helps in optimization
        ArrayList<Integer> checkList = new ArrayList<Integer>();

        long node = -1; // node is the individual links in a collatz sequence
        for(long currNum = 1; currNum <= n; currNum++){
            node = currNum;
            currLength = 1;
            while(node != 1){ // if node is not 1
                if(node > checkList.size()){ // if node previously not calculated
                    if (node % 2 == 1) { // if node is odd
                        node = (node * 3) + 1;
                    }
                    else { // if node is even
                        node = node / 2;
                    }
                    currLength++; // increase length by 1
                }
                else{ // if node previously calculated
                    currLength+=checkList.get((int)node-1)-1; // increment current length by the previous calculation
                    node = 1;
                }
            }
            checkList.add(currLength);
            if(currLength > largestLength){ // if the current length is the largest
                largestNum = currNum;
                largestLength = currLength;
            }
        }
        long result[] = {largestNum, largestLength};
        return result;
    }
}

