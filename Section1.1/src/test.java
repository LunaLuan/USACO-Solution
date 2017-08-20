/*
 ID: htluand1
 LANG: JAVA
 TASK: test
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
import java.util.StringTokenizer;
public class test {

	public static void main(String[]args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("test.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		out.println(a+b);
		out.close();
		
		System.exit(0);
	}
}
