/*
ID: htluand1
TASK: contact
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class contact {
	
	static class Node {
		String str;
		int soLan;
		
		Node(String s,int so){
			str=s;soLan=so;
		}
	}
	
	static class XepGiamDan implements Comparator<Node> {
		@Override
		public int compare(Node arg0, Node arg1) {
			if(arg0.soLan<arg1.soLan)
				return 1;
			else if(arg0.soLan==arg1.soLan){
				// return 0;
				if(arg0.str.length()>arg1.str.length())
					return 1;
				else if(arg0.str.length()==arg1.str.length() && arg0.str.compareTo(arg1.str)>0)
					return 1;
				else if(arg0.str.length()==arg1.str.length() && arg0.str.compareTo(arg1.str)<0)
					return -1;
				else 
					return -1;
			}
			else
				return -1;
		}
		
	}

	public static void main(String[] args) throws IOException{
		long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("contact.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
		
		int A,B,N;
		StringTokenizer st=new StringTokenizer(f.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		StringBuilder sb=new StringBuilder();
		String temp=f.readLine();
		while(temp!=null){
			sb.append(temp);
			temp=f.readLine();
		}
		
		TreeMap<String, Integer> tree=new TreeMap<String,Integer>();
		String text=sb.toString();
		for(int i=0;i<text.length();i++){
			for(int j=A;j<=B;j++){
				if((i+j-1)<text.length()){
					if(tree.containsKey(text.substring(i, i+j)))
						tree.put(text.substring(i, i+j), tree.get(text.substring(i, i+j))+1);
					else
						tree.put(text.substring(i, i+j), 1);
				}
			}
		}
		
		List<Node> ls=new ArrayList<Node>();
		while(!tree.isEmpty()){
			Map.Entry<String, Integer> e=tree.pollFirstEntry();
			ls.add(new Node(e.getKey(),e.getValue()));
		}
		
		Collections.sort(ls,new XepGiamDan());
		
		int p=0;
		while(N>0){
			if(p<ls.size()){
				Node t=ls.get(p);
				int dem=1;
				out.println(t.soLan);
				out.print(t.str);
				p++;
				for(;p<ls.size() && ls.get(p).soLan==t.soLan;p++){
					dem++;
					if((dem-1)%6==0)
						out.print("\n"+ls.get(p).str);
					else
						out.print(" "+ls.get(p).str);
				}
				out.println();
				N--;
			}
			else
				break;
		}
		
		out.close();
		
		System.out.println(System.currentTimeMillis()-s);
		System.exit(0);
		
	
	}
}

/*

public class contact {
	
	static class Node {
		String str;
		int soLan;
		
		Node(String s,int so){
			str=s;soLan=so;
		}
	}
	
	static class XepGiamDan implements Comparator<Node> {
		@Override
		public int compare(Node arg0, Node arg1) {
			if(arg0.soLan<arg1.soLan)
				return 1;
			else if(arg0.soLan==arg1.soLan){
				// return 0;
				if(arg0.str.length()>arg1.str.length())
					return 1;
				else if(arg0.str.length()==arg1.str.length() && arg0.str.compareTo(arg1.str)>0)
					return 1;
				else if(arg0.str.length()==arg1.str.length() && arg0.str.compareTo(arg1.str)<0)
					return -1;
				else 
					return 0;
			}
			else
				return -1;
		}
		
	}
	
	static StringBuilder goc=new StringBuilder();
	static char thongDiep[];
	static List<String> ls=new ArrayList<String>();
	static int A,B,N;
	static PriorityQueue<Node> pq; 
	
	static void tao(String s){
		if(s.length()>=A && s.length()<=B)
			soSanh(s);
		if(s.length()==B)
			return;
		
		tao(s+"1");
		tao(s+"0");
	}
	
	
	static int[] KMPfailure(char P[]){
		int f[]=new int[P.length];
		// int m=P.length;
		int j=1,k=0;
		f[0]=0;
		while(j<P.length){
			if(P[j]==P[k]){
				f[j]=k+1;
				j++;k++;
			}
			else  if(k>0)
				k=f[k-1];
			else 
				j++;
		}
		return f;
	}
	
	static void soSanh(String t){
		int dem=0;
		// int n=thongDiep.length,m=t.length();
		char P[]=t.toCharArray();
		int f[]=KMPfailure(P);
		int i=0,j=0;
		while(i<thongDiep.length){
			if(thongDiep[i]==P[j]){
				j++;
				if(j==P.length){
					dem++;
					j=f[j-1];
				}
				i++;
			}
			else if(j>0)
				j=f[j-1];
			else
				i++;
		}
		pq.add(new Node(t,dem));
	}
	
	/*
	static void soSanh(String t){
		int dem=0;
		
		Map<Character,Integer> lastOcc=new HashMap<>();
		
		for(int i=0;i<thongDiep.length;i++)
			lastOcc.put(thongDiep[i], -1);
		for(int i=0;i<t.length();i++)
			lastOcc.put(t.charAt(i), i);
		
		int i0=0;
		while(i0<(thongDiep.length-t.length())){
			int j=t.length()-1;
			boolean daThay=false;
			while(t.charAt(j) == thongDiep[i0+j]){
				j--;
				if(j<0){
					dem++;
					i0++;
					daThay=true;
					break;
				}
			}
			if(!daThay){
				if(j<lastOcc.get(thongDiep[i0+j]))
					i0++;
				else
					i0=i0+j-lastOcc.get(thongDiep[i0+j]);
			}
			
		}
		
		pq.add(new Node(t,dem));
		
		
	}
	
	public static void main(String[] args) throws IOException{
		long s=System.currentTimeMillis();
		
		Scanner in=new Scanner(new File("contact.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
		
		A=in.nextInt();B=in.nextInt();N=in.nextInt();
		
		pq=new PriorityQueue<Node>(10,new XepGiamDan());
		// thongDiep="";
		while(in.hasNext()){
			// thongDiep+=in.nextLine();
			goc.append(in.nextLine());
		}
		thongDiep=goc.toString().toCharArray();
		
		
		
		tao("");
		
		while(N>0){
			N--;
			Node t=pq.remove();
			int temp=t.soLan;
			if(temp!=0){
				out.println(temp);
				out.print(t.str);
				int dem=1;
				while(pq.peek().soLan==temp){
					if(dem%6==0)
						out.print("\n"+pq.remove().str);
					else
						out.print(" "+pq.remove().str);
					dem++;
				}
				out.println();
			}
			else
				break;
			
		}
		out.close();
		
		long fi=System.currentTimeMillis();
		System.out.println(fi-s);
		
		System.exit(0);
	}
}


/*
static void tao(){
	Deque<String> queue=new ArrayDeque<String>();
	queue.add("0");
	queue.add("1");
	
	while(!queue.isEmpty()){
		String temp=queue.removeFirst();
		if(temp.length()>=A && temp.length()<=B){
			soSanh(temp);
		}
		if(temp.length()<B){
			queue.addLast(temp+"0");
			queue.addLast(temp+"1");
		}
	}
	
}
*/
/*
static void soSanh(String t){
	int dem=0;
	long so=Long.parseLong(t);
	for(int i=0;i<thongDiep.length();i++){
		if(i+t.length()<=thongDiep.length())
			if(so==Long.parseLong(thongDiep.substring(i, i+t.length())))
				dem++;
	}
	ls.add(new Node(t,dem));
}
*/

/*
static void tao(String t,int length){
	if(length==0)
		soSanh(t);
	else{
		String t1=t+"0";
		String t2=t+"1";
		tao(t1,length-1);
		tao(t2,length-1);
	}
}


for(j=i+1;j<pq.size() && ls.get(j).soLan==temp;j++){
					dem++;
					out.print(" "+ls.get(j).str);
					if(dem%5==0){
						j++;
						out.print("\n"+ls.get(j).str);
					}
				}
				i=j;
*/