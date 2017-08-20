/*
 ID: htluand1
 TASK: skidesign
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Tham khao:http://usaco.org/current/data/sol_skidesign.html

public class skidesign {
	
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("skidesign.in"));
		PrintWriter out=new PrintWriter(new File("skidesign.out"));
		
		int N = in.nextInt();
		int h[] = new int[N];
		int minHeight = Integer.MAX_VALUE, maxHeight = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			h[i] = in.nextInt();
			if(h[i] < minHeight)
				minHeight = h[i];
			if(h[i] > maxHeight)
				maxHeight = h[i];
		}
		
		/*
		 * we will choice the min value to the cost is min.
		 */
		int minCost = Integer.MAX_VALUE;
		for(int i = minHeight; i <= maxHeight; i++) {
			int currentCost = 0, x = 0; 
			for(int j = 0; j < N; j++) {
				if(h[j] < i)
					x += (i - h[j]) * (i - h[j]);
				else if(h[j] - i > 17)
					x += (h[j] - 17 - i) * (h[j] - 17 - i);
				else
					x += 0;
			}
			currentCost = x;
			if(currentCost < minCost)
				minCost = currentCost;
		}
		// System.out.println(minCost);
		out.println(minCost);
		out.close();
		
		System.exit(0);
	}
}


/*
Scanner in=new Scanner(new File("skidesign.in"));
PrintWriter out=new PrintWriter(new File("skidesign.out"));

int[] height=new int[in.nextInt()];
for(int i=0;i<height.length;i++)
	height[i]=in.nextInt();

int mincost=1000000000;
for(int i=0;i<=83;i++){
	int cost=0,x;
	for(int j=0;j<height.length;j++){
		if(height[j]<i)
			x=i-height[j];
		else if(height[j]>i+17)
			x=height[j]-(i+17);
		else
			x=0;
		cost+=x*x;
	}
	if(mincost>cost)
		mincost=cost;
}

out.println(mincost);
out.close();in.close();
System.exit(0);
*/