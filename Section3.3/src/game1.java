/*
ID: htluand1
TASK: game1
LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class game1 {
	
	static int a[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		System.setIn(new FileInputStream("game1.in"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
		
		int N = sc.nextInt();
		a = new int[N];
		for(int i = 0; i < N; i++) 
			a[i] = sc.nextInt();
		
		
		
		out.close();
		System.exit(0);
	}

}

