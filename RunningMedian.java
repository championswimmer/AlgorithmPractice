import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> right = new PriorityQueue<>(n/2 + 1);
        PriorityQueue<Integer> left = new PriorityQueue<>(n/2 + 1, Collections.reverseOrder());
        
        float median = 0;
        
        for (int i = 0; i < n; i++) {
            int e = in.nextInt();
            
            int comp = left.size() - right.size();
            
            if (comp < 0) {
                //put in left
                
                if (e < right.peek()) {
                    left.add(e);
                } else {
                    left.add(right.poll());
                    right.add(e);
                }
                median  = ((float)left.peek() + (float)right.peek()) / 2;
            }
            
            if (comp > 0) {
                //put in right
                
                if (e > left.peek()) {
                    right.add(e);
                } else {
                    right.add(left.poll());
                    left.add(e);
                }
                median  = ((float)left.peek() + (float)right.peek()) / 2;
            }
            
            if (comp==0) {
                if (e > median) {
                    right.add(e);
                    median = right.peek();
                } else {
                    left.add(e);
                    median = left.peek();
                }
               
            }
            
            System.out.println(median);
        }

       
        
        
    }
}
