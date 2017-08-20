/*
 ID: htluand1
 TASK: subset
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class subset {
	
	static int dem(int tong,int i){
		int dem[][]=new int[tong+1][i+1];
		
		for(int j=1;j<=i;j++)
			dem[0][j]=1;
		
		for(int tongN=1;tongN<=tong;tongN++)
			for(int iN=1;iN<=i;iN++){
				dem[tongN][iN]=0;
				int t=tongN-iN;
				if(t==0)
					dem[tongN][iN]=1;
				else if(t<0)
					dem[tongN][iN]=0;
				else{
					for(int j=1;j<iN;j++)
						dem[tongN][iN]+=dem[t][j];
				}
			}
		
		/*
		for(int u=1;u<=tong;u++){
			for(int v=1;v<=i;v++)
				System.out.print(dem[u][v]+" ");
			System.out.println();
		}
		*/
		return dem[tong][i];
	}
	
	public static void main(String[] args) throws IOException{
		long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("subset.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		
		int tong=n*(n+1)/2;
		
		// System.out.println(60-15);
		
		if(tong%2==1){
			out.println("0");
		}
		else {
			out.println(dem(tong/2,n));
		}
		
		out.close();
		
		long fi=System.currentTimeMillis();
		System.out.println(fi-s);
		
		System.exit(0);
	}
}

/*
static void dem(int tong,int i){
	tong-=i;
	if(tong==0){
		solg++;
		return;
	}
	if(tong<0)
		return;
	
	for(int j=i-1;j>0;j--)
		dem(tong,j);
}
*/

/*
static class Node {
	int tong;
	int i;
	
	public Node(int to,int i1){
		tong=to;i=i1;
	}
}

static int solg=0;

static void dem(int tong,int i){
	Deque<Node> queue=new LinkedList<Node>();
	queue.add(new Node(tong,i));
	
	while(!queue.isEmpty()){
		Node dau=queue.pollFirst();
		int can=dau.i;
		int to=dau.tong-can;
		// System.out.println(to+"\t"+can);
		if(to==0)
			solg++;
		else if(to<0){
			
		}
		else{
			for(int j=can-1;j>0;j--)
				queue.addLast(new Node(to,j));
		}
		
	}
	
}
*/
