/*
 ID: htluand1
 TASK: comehome
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class comehome {
	
	static int graph[][];
	static int D[];
	
	static class Node {
		int finish;
		int distance;
		
		public Node(int fi,int di){
			finish=fi;distance=di;
		}
	}
	
	
	static class XepTangDan implements Comparator<Node> {

		@Override
		public int compare(Node arg0, Node arg1) {
			if(arg0.finish>arg1.finish)
				return 1;
			else if(arg0.finish<arg1.finish)
				return -1;
			else
				return 0;
		}
		
	}
	
	static void Dijsktra_OnLog(int start){
		for(int n=0;n<52;n++)
			D[n]=graph[start][n];
		
		boolean daXet[]=new boolean[52];
		Arrays.fill(daXet, false);
		daXet[start]=true;
		
		PriorityQueue<Node> pq=new PriorityQueue(new XepTangDan());
		for(int n=0;n<52;n++)
			pq.add(new Node(n,D[n]));
		
		while(!pq.isEmpty()){
			Node v=pq.remove();
			if(!daXet[v.finish]){
				daXet[v.finish]=true;
				// D[v.finish]=v.distance;
				for(int n=0;n<52;n++){
					if(!daXet[n] && D[n]>D[v.finish]+graph[v.finish][n]){
						D[n]=D[v.finish]+graph[v.finish][n];
						pq.add(new Node(n,D[n]));
					}
				}
			}
			boolean daXetHet=true;
			for(int n=0;n<52;n++)
				if(!daXet[n]){
					daXetHet=false;
					break;
				}
			
			if(daXetHet)
				break;
		}
		
		
	}

	static void Dijsktra(int start){
		for(int n=0;n<52;n++)
			D[n]=graph[start][n];
		
		boolean daXet[]=new boolean[52];
		Arrays.fill(daXet, false);
		daXet[start]=true;
		
		for(int k=0;k<51;k++){
			int m;
			
			for(m=0;m<52;m++)
				if(!daXet[m])
					break;
			
			for(int n=0;n<52;n++)
				if(!daXet[n] && D[n]<D[m])
					m=n;
			
			
			daXet[m]=true;
			
			for(int n=0;n<52;n++)
				if(!daXet[n] &&  D[n]>D[m]+graph[m][n])
					D[n]=D[m]+graph[m][n];
				/*
				else if(/*!daXet[n] && D[m]>D[n]+graph[m][n])
					D[m]=D[n]+graph[n][m];
				*/
		}
		
		D[start]=0;
	}
	
	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("comehome.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
		
		int n=Integer.parseInt(f.readLine());
		
		graph=new int[52][52];
		D=new int[52];
		for(int i=0;i<52;i++)
			for(int j=0;j<52;j++)
				graph[i][j]=100000;
		
		for(int l=0;l<n;l++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			int i=st.nextToken().charAt(0);
			int j=st.nextToken().charAt(0);
			int gtri=Integer.parseInt(st.nextToken());
			
			if(i>='a' && i<='z')
				i=i-65-6;
			else if(i>='A' && i<='Z')
				i=i-65;
			
			if(j>='a' && j<='z')
				j=j-65-6;
			else if(j>='A' && j<='Z')
				j=j-65;
			
			/* Day la 1 chi tiet cuc ky nguy hiem,
			 * khi khong luong truoc duoc bo du lieu cua bai.Can rat tranh cho sau nay.
			 * Trong bai cho phep co nhieu duuong di qua 2 diem,khi do ta can lay duong ngan hon.*/
			if(gtri<graph[i][j] && gtri<graph[j][i]){
				graph[i][j]=gtri;
				graph[j][i]=gtri;
			}
		}
		
		
		int min=100000,minI=-1;
		Dijsktra_OnLog(25);
		for(int i=0;i<25;i++){
			// System.out.println(((char) (i+65))+" "+D[i]);
			if(D[i]<min){
				min=D[i];minI=i;
			}
		}
		
		out.println(((char) (minI+65)) +" "+min);
		out.close();
		
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
		
		System.exit(0);
	}
}

/*
for(int k=0;k<52;k++)
	for(int i=0;i<52;i++)
		for(int j=0;j<52;j++)
			// if(i!=j && j!=k && k!=i)
				if(graph[i][j]>graph[i][k]+graph[k][j])
					graph[i][j]=graph[i][k]+graph[k][j];
*/
