/*
 ID: htluand1
 TASK: cowtour
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class cowtour {
	
	static int n;
	static int dx[];
	static int dy[];
	static double voCuc=1000000;
	
	static double distance(int d1,int d2){
		return Math.sqrt( (dx[d1]-dx[d2])*(dx[d1]-dx[d2])
				+(dy[d1]-dy[d2])*(dy[d1]-dy[d2]) );
	}

	static void duongDi(double graph[][]){
		// System.out.println(d1+" "+d2);
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(k!=i && i!=j && j!=k)
						if(graph[i][j]>graph[i][k]+graph[k][j])
							graph[i][j]=graph[i][k]+graph[k][j];
	}
	
	static double longset(int k,double graph[][]){
		double max=0;
		for(int i=0;i<n;i++)
			if(graph[k][i]!=voCuc && graph[k][i]>max)
				max=graph[k][i];
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long start=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("cowtour.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		n=Integer.parseInt(st.nextToken());
		dx=new int[n];
		dy=new int[n];
		for(int i=0;i<n;i++){
			st=new StringTokenizer(f.readLine());
			dx[i]=Integer.parseInt(st.nextToken());
			dy[i]=Integer.parseInt(st.nextToken());
		}
		
		double graph[][]=new double[n][n];
		for(int i=0;i<n;i++){
			String str=f.readLine();
			for(int j=0;j<n;j++){
				char gtri=str.charAt(j);
				if(gtri=='0'){
					graph[i][j]=voCuc;
				}
				else
					graph[i][j]=distance(i,j);
			}
		}
		
		duongDi(graph);
		
		double smallest=voCuc;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(graph[i][j]==voCuc && i!=j)
					smallest=Math.min(smallest, longset(i, graph)+
							distance(i, j)+longset(j, graph));

		for(int i=0;i<n;i++)
			smallest=Math.max(smallest, longset(i, graph));
		
		
		out.printf("%.6f\n",smallest);
		out.close();
		
		// long finish=System.currentTimeMillis();
		// System.out.println(finish-start);
		
		System.exit(0);
		
	}

}
