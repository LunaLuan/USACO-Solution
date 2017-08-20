/*
 ID: htluand1
 TASK: nocows
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class nocows {

// https://belbesy.wordpress.com/2012/08/08/usaco-2-3-2-cow-pedigrees/
// http://zeffsalgo.blogspot.com/2013/12/usaco-training-problem-cow-pedigrees.html

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int dp[][]=new int[101][202];
		int N,K;
		
		BufferedReader f=new BufferedReader(new FileReader("nocows.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		
		for(int i=1;i<=K;i++)
			dp[i][0]=dp[i][1]=1;
		
		for(int h=1;h<=K;h++)
			for(int n=1;n<=N;n+=2)
				for(int c=1;c<n;c+=2)
					dp[h][n]=(dp[h][n]+dp[h-1][c]*dp[h-1][n-c-1])%9901;
		
		out.println((dp[K][N]-dp[K-1][N]+9901)%9901);
		out.close();
		
		System.exit(0);
		
		
	}

}
