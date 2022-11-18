package in.sp_java_practice;

import java.util.*;
import java.lang.*;

public class Fundamental {
    public static void totalCredits() throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        String [] caseDetails = new String[totalCases+1];
        for (int i = 0; i <= totalCases; i++) {
            caseDetails[i] = scanner.nextLine();
        }
        for (int i = 1; i < caseDetails.length; i++) {
            String[] values = caseDetails[i].split(" ");
            credits(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        }
    }

    public static void credits(int rtp, int audit){
        System.out.println(4*rtp + 2*audit);
    }
}
