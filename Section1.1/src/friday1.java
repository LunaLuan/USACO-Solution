/*
ID: stphung1
LANG: JAVA
TASK: friday
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 
class friday1 {
    public static void main(String[] args) throws IOException {
    	/*
        Scanner sc = new Scanner(new File("friday.in"));
        PrintWriter pw = new PrintWriter(new File("friday.out"));
        */
        int years = 2;
 
        int freq[] = new int[7];
        Arrays.fill(freq, 0);
 
        int calendarDay = 0;
        int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] leapDays = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 
        int end = 1900 + years;
        for (int year = 1900; year < end; year++) {
            for (int month = 0; month < 12; month++) {
                int day = (calendarDay + 12) % 7;
                freq[day]++;
                calendarDay += isLeap(year) ? leapDays[month] : days[month];
            }
        }
 
        System.out.print(freq[5]);
        System.out.print(' ');
        System.out.print(freq[6]);
        System.out.print(' ');
        System.out.print(freq[0]);
        System.out.print(' ');
        System.out.print(freq[1]);
        System.out.print(' ');
        System.out.print(freq[2]);
        System.out.print(' ');
        System.out.print(freq[3]);
        System.out.print(' ');
        System.out.println(freq[4]);
 
       // pw.close();
    }
 
    public static boolean isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}