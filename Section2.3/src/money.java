/*
 ID: htluand1
 TASK: money
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class money {
	
	static int tien[]; 

	static long ketQua(int tong){
		long s[][]=new long[tong+1][tien.length];
		
		for(int i=1;i<=tong;i++)
			s[i][0]=0;
		
		for(int j=1;j<tien.length;j++)
			s[0][j]=1;
		
		for(int i=1;i<=tong;i++)
			for(int j=1;j<tien.length;j++)
				if((i-tien[j])<0)
					s[i][j]=s[i][j-1];
				else
					s[i][j]=s[i-tien[j]][j]+s[i][j-1];
		
		return s[tong][tien.length-1];
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new FileReader("money.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
		
		tien=new int[in.nextInt()+1];
		int tong=in.nextInt();
		
		for(int i=1;i<tien.length;i++){
			tien[i]=in.nextInt();
		}
		
		
		out.println(ketQua(tong));
		out.close();
		
		System.exit(0);
		
	}
}
