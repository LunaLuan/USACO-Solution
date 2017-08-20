/*
ID: htluand1
TASK: humble
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class humble {
	
	static class Node {
		long gtri;
		int vtri;
		
		Node(long gt,int vt){
			gtri=gt;vtri=vt;
		}
	}
	
	static class XepTangDan implements Comparator<Node> {

		@Override
		public int compare(Node arg0, Node arg1) {
			// TODO Auto-generated method stub
			if(arg0.gtri>arg1.gtri)
				return 1;
			if(arg0.gtri==arg1.gtri)
				return 0;
			else
				return -1;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long sta=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("humble.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		int set[]=new int[Integer.parseInt(st.nextToken())];
		int K=Integer.parseInt(st.nextToken());
		
		// Arrays.sort(set);
		PriorityQueue<Node> ls=new PriorityQueue<Node>(set.length,new XepTangDan());
		// List<Integer> lsTemp=new ArrayList<Integer>();
		
		st=new StringTokenizer(f.readLine());
		long max=0;
		for(int i=0;i<set.length;i++){
			set[i]=Integer.parseInt(st.nextToken());
			ls.add(new Node(set[i],i));
			if(set[i]>max)
				max=set[i];
		}
		
		for(int dem=0;dem<K-1;dem++){
			Node temp=ls.remove();
			for(int j=temp.vtri;j<set.length;j++){
				long tg=(long) temp.gtri*set[j];
				ls.add(new Node(tg,j));
				if(ls.size()>K && tg>max)
					break;
				max=Math.max(max, tg);
			}
		}
		
		// Collections.sort(ls,new XepTangDan());
		/*
		for(Node x:ls)
			System.out.println(x.gtri+" ");
		// System.out.println(ls.size());
		*/
		out.println(ls.remove().gtri);
		out.close();
		
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-sta);
		
		System.exit(0);
		
	}

}

/*
List<Node> ls=new ArrayList<Node>();

st=new StringTokenizer(f.readLine());
for(int i=0;i<set.length;i++){
	if(st.countTokens()==0)
		st=new StringTokenizer(f.readLine());
	set[i]=Integer.parseInt(st.nextToken());
	ls.add(new Node(set[i],i));
}

for(int dem=0;dem<5*K;dem++){
	Node temp=ls.get(dem);
	for(int j=temp.vtri;j<set.length;j++)
		ls.add(new Node((long) temp.gtri*set[j],j));
}

Collections.sort(ls,new XepTangDan());
/*
for(Node x:ls)
	System.out.println(x.gtri+" ");
// System.out.println(ls.size());
*/