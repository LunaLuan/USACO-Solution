/*
 ID: htluand1
 TASK: butter
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;


public class butter {
	
	static class Node {
		int canh;int dinh;
		
		Node(int c,int d){
			canh=c;dinh=d;
		}
	}
	
	static class XepTangDan implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			// TODO Auto-generated method stub
			if(n1.canh>n2.canh)
				return 1;
			else if(n1.canh<n2.canh)
				return -1;
			return 0;
		}	
	}
	
	
	static ArrayList<Node> map[];
	static int P;
	static int ls[];
	
	static int min=10000000;
	
	static void D(int s){
		
		PriorityQueue<Node> pq=new PriorityQueue<Node>(P,new XepTangDan());
		
		int[] duong=new int[P+1];
		Arrays.fill(duong, 1000000);
		duong[s]=0;
		
		int sum=0;
		pq.add(new Node(0,s));
		while(!pq.isEmpty()){
			Node e=pq.remove();
			if(e.canh>duong[e.dinh])
				continue;
			for(int i=0;i<map[e.dinh].size();i++){
				int to=map[e.dinh].get(i).dinh;
				int len=map[e.dinh].get(i).canh;
				if(duong[to]>duong[e.dinh]+len){
					duong[to]=duong[e.dinh]+len;
					pq.add(new Node(duong[to],to));
				}
			}
			
		}
		
		/*
		for(int i=0;i<ls.size();i++)
			sum+=duong[ls.get(i)];
		*/
		for(int i=1;i<=P;i++)
			sum+=duong[i]*ls[i];
		
		if(sum<min)
			min=sum;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("butter.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
		
		int N,C;
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		ls=new int[P+1];
		map=new ArrayList[P+1];
		for(int i=0;i<=P;i++)
			map[i]=new ArrayList<Node>();
		
		
		for(int i=0;i<N;i++){
			st=new StringTokenizer(f.readLine());
			ls[Integer.parseInt(st.nextToken())]++;
		}
		
		for(int c=0;c<C;c++){
			st=new StringTokenizer(f.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			map[x].add(new Node(d,y));
			map[y].add(new Node(d,x));
		}
		/*
		for(int k=1;k<=P;k++)
			for(int i=1;i<=P;i++)
				for(int j=1;j<=P;j++)
					if(map[i][j]>(map[i][k]+map[k][j])){
						map[i][j]=map[i][k]+map[k][j];
						// map[j][i]=map[i][j];
					}
		*/
		for(int k=1;k<=P;k++)
			D(k);
		/*
		for(int i=0;i<=P;i++)
			map[i][i]=0;
		
		for(int i=1;i<=P;i++){
			
			int sum=0;
			for(int j=1;j<=P;j++)
				sum+=map[j][i]*ls[j];
			if(sum<min)
				min=sum;
		}
		*/
		
		out.println(min);
		out.close();
		
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
		
		
		
		
	}

}
