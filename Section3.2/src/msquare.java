/*
ID: htluand1
TASK: msquare
LANG: JAVA
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class msquare {
	
	static int A(int s){
		int temp=0;
		for(int i=7;i>=0;i--){
			int t=s%10;
			s/=10;
			temp+=t*Math.pow(10, i);
		}
		return temp;
	}
	
	static int B(int s){
		int c=s%1000;
		s=s/1000;
		int d=s%10;
		s=s/10;
		int a=s%10;
		s=s/10;
		int b=s;
		return a*10000000+b*10000+c*10+d;
	}
	
	static int  C(int s){
		int g=s%10;
		s=s/10;
		int f=s%10;
		s=s/10;
		int e=s%10;
		s=s/10;
		int d=s%100;
		s=s/100;
		int c=s%10;
		s=s/10;
		int b=s%10;
		s=s/10;
		int a=s;
		return a*10000000+f*1000000+b*100000+d*1000+c*100+e*10+g;
	}

	static int goal=0;
	static String dapAn="";
	
	static class Node {
		int chuoi;
		String kq; 
		
		Node(int c,String k){
			chuoi=c;kq=k;
		}
	}
	
	
	static void tim(int rubik){
		TreeSet<Integer> set=new TreeSet<Integer>();
		
		Queue<Node> q=new LinkedList<Node>();
		
		if(rubik==goal)
			return;
		
		
		q.add(new Node(rubik,""));
		set.add(rubik);
		while(!q.isEmpty()){
			Node e=q.poll();
			
			// set.add(Integer.parseInt(e.chuoi));
			int temp;
			temp=A(e.chuoi);
			if(temp==goal){
				dapAn=e.kq+"A";
				return;
			}
			else if(set.contains(temp)){
			
			}
			else{
				q.add(new Node(temp,e.kq+"A"));
				set.add(e.chuoi);
			}
			
			temp=B(e.chuoi);
			if(temp==goal){
				dapAn=e.kq+"B";
				return;
			}
			else if(set.contains(temp)){
				
			}
			else{
				q.add(new Node(temp,e.kq+"B"));
				set.add(e.chuoi);
			}
			
			temp=C(e.chuoi);
			if(temp==goal){
				dapAn=e.kq+"C";
				return;
			}
			else if(set.contains(temp)){
				
			}
			else{
				q.add(new Node(temp,e.kq+"C"));
				set.add(temp);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("msquare.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
		
		int init=12345678;
		StringTokenizer st=new StringTokenizer(f.readLine());
		while(st.countTokens()>0)
			goal=goal*10+Integer.parseInt(st.nextToken());
		
		// out.println(dapAn);
		tim(init);
		out.println(dapAn.length());
		if(dapAn.length()==0)
			out.println(dapAn);
		else{
			for(int i=0;i<dapAn.length();i+=60){
				if(i+60<=dapAn.length())
					out.println(dapAn.substring(i, i+60));
				else
					out.println(dapAn.substring(i, dapAn.length()));
			}
		}
		
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
		
	}

}
