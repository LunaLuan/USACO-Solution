/*
 ID: htluand1
 TASK: numtri
 LANG: JAVA
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


public class numtri {
	
	// int[][] a;
	static int n;
	
	public static int max(int a,int b){
		if(a>b)
			return a;
		return b;
	}
	
	public static int search_max(int[][] a,int row,int col){
		if(row==n-1)
			return a[row][col];
		else
			return a[row][col]+max(search_max(a,row+1, col),search_max(a,row+1, col+1));
	}
	
	public static int search_max_dynamic(int[][] a){
		for(int i=n-2;i>=0;i--){
			for(int j=0;j<=i;j++){
				a[i][j]+=max(a[i+1][j],a[i+1][j+1]);
			}
		}
		return a[0][0];
	}

	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		//Scanner in=new Scanner(new File("numtri.in"));
		BufferedReader f=new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		n=Integer.parseInt(st.nextToken());
		
		int[][] a=new int[n][];
		
		
		for(int i=0;i<n;i++){
			a[i]=new int[i+1];
			st=new StringTokenizer(f.readLine());
			for(int j=0;j<i+1;j++){
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		
		out.println(search_max_dynamic(a));
		out.close();
		
		// long finish=System.currentTimeMillis();
		
		// System.out.println(finish-s);
		
		System.exit(0);
	}
}
