/*
ID: htluand1
TASK: maze1
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
import java.util.StringTokenizer;


public class maze1 {

	static char map[][];
	static int W;
	static int H;
	
	static void nhapDuLieu(BufferedReader f) throws IOException{
		map=new char[2*H+1][2*W+1];
		for(int i=0;i<2*H+1;i++)
			map[i]=f.readLine().toCharArray();
	}
	
	static void floodFill(int i,int j,int mau,int[][] graph){
		if(i>=1 && i<2*H+1 && j>=1 && j<2*W+1){
			if(graph[i][j]==0 || graph[i][j]>mau){
				graph[i][j]=mau;
				if(map[i-1][j]==' ')
					floodFill(i-2, j, mau+1, graph);
				if(map[i+1][j]==' ')
					floodFill(i+2, j, mau+1, graph);
				if(map[i][j-1]==' ')
					floodFill(i , j-2 , mau+1, graph);
				if(map[i][j+1]==' ')
					floodFill(i , j+2 , mau+1, graph);
			}
		}
	}
		
	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		int[][] graph1=new int[2*H+1][2*W+1];
		int[][] graph2=new int[2*H+1][2*W+1];
		
		int start1_i=0,start1_j=0,start2_i=0,start2_j=0;
		
		nhapDuLieu(f);
		boolean co1Start=false;
		
		for(int i=1;i<2*H+1;i+=2){
			// System.out.println(map[1][0]);
			if(map[i][0]==' '){
				if(co1Start){
					start2_i=i;start2_j=1;
				}
				else{
					start1_i=i;start1_j=1;co1Start=true;
				}
			}
		}
			
		
		for(int i=1;i<2*H+1;i+=2){
			if(map[i][2*W]==' '){
				if(co1Start){
					start2_i=i;start2_j=2*W-1;
				}
				else{
					start1_i=i;start1_j=2*W-1;co1Start=true;
				}
			}
		}
		
		for(int j=1;j<2*W+1;j+=2){
			if(map[0][j]==' '){
				if(co1Start){
					start2_i=1;start2_j=j;
				}
				else{
					start1_i=1;start1_j=j;co1Start=true;
				}
			}
		}
		
		for(int j=1;j<2*W+1;j+=2){
			if(map[2*H][j]==' '){
				if(co1Start){
					start2_i=2*H-1;start2_j=j;
				}
				else{
					start1_i=2*H-1;start1_j=j;co1Start=true;
				}
			}
		}
		
		floodFill(start1_i, start1_j, 1, graph1);
		floodFill(start2_i, start2_j, 1, graph2);
		
		int max=0;
		for(int i=1;i<2*H+1;i+=2){
			for(int j=1;j<2*W+1;j+=2){
				int opt=Math.min(graph1[i][j], graph2[i][j]);
				if(opt>max)
					max=opt;
			}
		}
		
		
		
		out.println(max);
		out.close();
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
		
		System.exit(0);
		
	}
	
}
/*
static int[] Dijsktra(int s){
	boolean Reached[]=new boolean[NNodes];
	Arrays.fill(Reached, false);
	Reached[s]=true;
	int D1[]=new int[NNodes];
	for(int n=0;n<NNodes;n++){
		D1[n]=graph[s][n];
	}
	
	for(int k=0;k<NNodes-1;k++){
		int m;
		for(m=0;m<NNodes;m++)
			if(!Reached[m])
				break;
		
		for(int n=0;n<NNodes;n++)
			if(D1[n]<D1[m] && !Reached[n])
				m=n;
		
		Reached[m]=true;
		
		for(int n=0;n<NNodes;n++)
			if(D1[n]>D1[m]+graph[m][n] && !Reached[n])
				D1[n]=D1[m]+graph[m][n];
		
	}
	D1[s]=0;
	return D1;
}
*/

/*
map[0]=f.readLine().toCharArray();

boolean co1DuongRa=false;

for(int i=1;i<2*H+1;i+=2){
	map[1]=f.readLine().toCharArray();
	map[2]=f.readLine().toCharArray();
	for(int j=1;j<2*W+1;j+=2){
		int current_node=(i-1)*W/2+(j-1)/2;
		if(map[1][j-1]==' '){
			if((j-1)>0)
				graph[current_node][current_node-1]=1;
			else{
				if(co1DuongRa)
					start2=current_node;
				else{
					start1=current_node;
					co1DuongRa=true;
				}
			}
		}
		if(map[0][j]==' '){
			if((i-1)>0)
				graph[current_node][current_node-W]=1;
			else{
				if(co1DuongRa)
					start2=current_node;
				else{
					start1=current_node;
					co1DuongRa=true;
				}
			}
		}
		if(map[1][j+1]==' '){
			if((j+1)<(2*W))
				graph[current_node][current_node+1]=1;
			else{
				if(co1DuongRa)
					start2=current_node;
				else{
					start1=current_node;
					co1DuongRa=true;
				}
			}
		}
		if(map[2][j]==' '){
			if((i+1)<(2*H))
				graph[current_node][current_node+W]=1;
			else{
				if(co1DuongRa)
					start2=current_node;
				else{
					start1=current_node;
					co1DuongRa=true;
				}
			}
		}
		
	}
	map[0]=map[2];
}
*/