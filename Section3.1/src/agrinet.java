/*
 ID: htluand1
 TASK: agrinet
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
import java.util.List;
import java.util.StringTokenizer;


public class agrinet {
	
	static int NNodes;
	static int graph[][];
	
	static int v=1000000;

	static int[] Prim(){
		int D[]=new int[NNodes];
		boolean Reached[]=new boolean[NNodes];
		
		Reached[0]=true;
		D[0]=0;
		
		for(int i=1;i<NNodes;i++)
			D[i]=graph[0][i];
		
		for(int i=1;i<NNodes;i++){
			int min=v,m=0;
			
			for(int k=1;k<NNodes;k++){
				if(!Reached[k] && D[k]<min){
					min=D[k];m=k;
				}
			}
			
			Reached[m]=true;
			
			for(int k=1;k<NNodes;k++){
				if(!Reached[k] && D[k]>graph[m][k])
					D[k]=graph[m][k];
			}
		}
		
		return D;
		
	}
	
	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("agrinet.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		NNodes=Integer.parseInt(st.nextToken());
		graph=new int[NNodes][NNodes];
		for(int i=0;i<NNodes;i++)
			Arrays.fill(graph[i], v);
		
		for(int i=0;i<NNodes;i++){
			st=new StringTokenizer(f.readLine());
			for(int k=0;k<NNodes;k++){
				if(st.countTokens()==0)
					st=new StringTokenizer(f.readLine());
				int gtri=Integer.parseInt(st.nextToken());
				if(gtri<graph[i][k] && i!=k){
					graph[i][k]=graph[k][i]=gtri;
				}
			}
		}
		
		
		int D[]=Prim();
		int min=0;
		for(int i=0;i<NNodes;i++)
			min+=D[i];
		
		out.println(min);
		out.close();
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
		
		System.exit(0);
		
	}
}

/*
boolean coDongTrc=false;
StringTokenizer temp=null;
StringBuilder sb=new StringBuilder();
String str=null;
for(int i=0;i<NNodes;i++){
	if(coDongTrc)
		sb.append(str);
	else
		sb.append(f.readLine());
	
	st=new StringTokenizer(sb.toString());
	while(st.countTokens()<NNodes){
		temp=new StringTokenizer(f.readLine());
		sb.append(temp);
		st=new StringTokenizer(sb.toString());
	}
	str=f.readLine();
	if(str!=null){
		temp=new StringTokenizer(str);
		if(temp.countTokens()==1)
			sb.append(temp.toString());
	}
	st=new StringTokenizer(sb.toString());
	coDongTrc=true;
	
	for(int k=0;k<NNodes;k++){
		int gtri=Integer.parseInt(st.nextToken());
		if(gtri<graph[i][k] && i!=k){
			graph[i][k]=graph[k][i]=gtri;
		}
	}
	
	sb=new StringBuilder();
}
*/