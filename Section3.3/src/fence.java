/*
 ID: htluand1
 TASK: fence
 LANG :JAVA
 */
import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class fence {
	
	static ArrayList<Integer> graph[]=new ArrayList[502];
	// static boolean daXet[][]=new boolean[502][502];
	// static int soNode=0;
	
	static ArrayList<Integer> findCircuit(int start){
		Stack<Integer> s=new Stack<Integer>();
		ArrayList<Integer> circuit=new ArrayList<Integer>();
		
		s.push(start);
		while(!s.isEmpty()){
			int location=s.peek();
			if(graph[location].isEmpty())
				circuit.add(s.pop());
			else{
				int get=graph[location].get(0);
				graph[location].remove(0);
				for(int i=0;i<graph[get].size();i++){
					if(graph[get].get(i)==location){
						graph[get].remove(i);
						break;
					}
				}
				s.push(get);
			}
		}
		return circuit;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		BufferedReader f=new BufferedReader(new FileReader("fence.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		
		int cap[]=new int[502];
		int soCanh=Integer.parseInt(f.readLine());
		for(int i=0;i<soCanh;i++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			if(graph[x]==null)
				graph[x]=new ArrayList<Integer>();
			if(graph[y]==null)
				graph[y]=new ArrayList<Integer>();
			graph[x].add(y);
			graph[y].add(x);
			cap[x]++;cap[y]++;
		}
		
		
		for(int i=0;i<graph.length;i++)
			if(graph[i]!=null)
				Collections.sort(graph[i]);
		
		int i;
		boolean coCapLe=false;
		for(i=1;i<=500;i++){
			if(cap[i]%2==1){
				coCapLe=true;
				break;
			}
		}
		if(!coCapLe)
			i=1;
		
		ArrayList<Integer> dapAn=findCircuit(i);
		
		for(int j=dapAn.size()-1;j>=0;j--)
			out.println(dapAn.get(j));
		
		
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
		
	}

}
