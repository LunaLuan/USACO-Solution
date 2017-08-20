/*
 ID: htluand1
 LANG: JAVA
 TASK: ride
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ride {
	
	static int getHashKey(char a[]) {
		int h=1;
		for(int i=0;i<a.length;i++) {
			h*=a[i]-'A'+1;
		}
		return h% 47;
		
	}
 	
	public static void main(String[]args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("ride.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		
		char s1[]=f.readLine().toCharArray();
		char s2[]=f.readLine().toCharArray();
		
		if(getHashKey(s1)==getHashKey(s2))
			out.println("GO");
		else
			out.println("STAY");
		
		out.close();
		System.exit(0);
		
	}

}
