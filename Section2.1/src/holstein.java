/*
 ID: htluand1
 TASK: holstein
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
// import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
// import java.util.Stack;

import javax.swing.plaf.SliderUI;


public class holstein {
	
	static int N;
	static int v[]=new int[25];
	static int G;
	static int fv[][]=new int[15][25];
	static int s[]=new int[15];
	static int p[]=new int[25];
	static int hash[]=new int[15];
	static int minans=100000;
	
	public static void DFS(int n){
		int ok=1;
		for(int i=0;i<N;i++){
			if(p[i]<v[i]){
				ok=0;break;
			}
		}
		if(ok==1){
			int ans=0;
			for(int i=0;i<n;i++)
				ans+=s[i];
			if(ans<minans){
				minans=ans;
				Arrays.fill(hash, 0);
				for(int i=0;i<G;i++){
					if(s[i]==1)
						hash[i]=1;
				}
			}
			return;
		}
		
		if(n==G)	return;
		
		for(s[n]=0;s[n]<=1;s[n]++){
			for(int i=0;i<N;i++)
				p[i]+=fv[n][i]*s[n];
			DFS(n+1);
			for(int i=0;i<N;i++)
				p[i]-=fv[n][i]*s[n];
		}
	}
	
	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		// ViTaMinToiThieu=new int[SoViTaMin];
		st=new StringTokenizer(f.readLine());
		for(int i=0;i<N;i++)
			v[i]=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(f.readLine());
		G=Integer.parseInt(st.nextToken());
		// ViTaMin=new int[SoLoaiThucAn][SoViTaMin];
		for(int i=0;i<G;i++){
			st=new StringTokenizer(f.readLine());
			for(int j=0;j<N;j++){
				fv[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		DFS(0);
		
		out.print(minans);
		
		for(int i=0;i<hash.length;i++){
			if(hash[i]!=0)
				out.print(" "+(i+1));
		}
		
		out.println();
		
		out.close();
		
		// long fi=System.currentTimeMillis();
		
		// System.out.println(fi-s);
		
		
		System.exit(0);
	}
}


/*
static int min=100000;
static Deque<Integer> currentTour=new LinkedList<Integer>();
static Integer minTour[];



public static void Test(){
	for(int i=0;i<SoLoaiThucAn;i++){
		int[] temp=new int[SoViTaMin];
		Arrays.fill(temp, 0);
		timMin(i,temp);
	}
}

public static void timMin(int loai,int lgViTaMin[]){
	if(duChat(lgViTaMin)){
		/*
		System.out.println(currentTour.size());
		for(int i=0;i<lgViTaMin.length;i++){
			System.out.print(lgViTaMin[i]+" ");
		}
		for(int i=0;i<currentTour.size();i++){
			System.out.print(currentTour.pollFirst()+"+");
		}
		
		System.out.println();
		
		if(currentTour.size()<min){
			minTour=(Integer[]) currentTour.toArray();
			
		}
		currentTour.removeLast();
		return;
	}
	else{
		currentTour.addLast(loai);
		for(int i=0;i<SoViTaMin;i++)
			lgViTaMin[i]+=ViTaMin[loai][i];
		int temp[][]=new int[SoLoaiThucAn][];
		for(int i=0;i<SoLoaiThucAn;i++)
			temp[i]=lgViTaMin.clone();
		for(int i=0;i<SoLoaiThucAn;i++){
			timMin(i,lgViTaMin);
		}
	}
}

public static boolean duChat(int lgViTaMin[]){
	for(int i=0;i<SoViTaMin;i++)
		if(lgViTaMin[i]<ViTaMinToiThieu[i])
			return false;
	return true;
}
*/


/*	
static int min=200;
static int minTour[]=new int[min];
static int max=200;

static class Node {
	int viTaMin[];
	int tour[];
	int tourLength=0;
	
	public Node(int loai){
		viTaMin=ViTaMin[loai].clone();
		tour=new int[1000];
		tour[tourLength]=loai;
		tourLength=1;
	}
	
	public Node(Node currentNode){
		viTaMin=currentNode.viTaMin.clone();
		tour=currentNode.tour.clone();
		tourLength=currentNode.tourLength;
	}
	
	public boolean duChat(){
		for(int i=0;i<SoViTaMin;i++)
			if(viTaMin[i]<ViTaMinToiThieu[i])
				return false;
		return true;
	}
	
	public void them(int loai){
		for(int i=0;i<viTaMin.length;i++)
			viTaMin[i]+=ViTaMin[loai][i];
		tour[tourLength]=loai;
		tourLength++;
	}
}

public static void update(int loai){
	Deque<Node> tree=new LinkedList<Node>() ;
	tree.addLast(new Node(loai));
	while(!tree.isEmpty()){
		Node currentNode=tree.pollFirst();
		int currentLoai=currentNode.tour[currentNode.tourLength-1];
		// System.out.println(currentNode.tourLength);
		if(!currentNode.duChat()){
			for(int i=0;i<SoLoaiThucAn;i++){
				Node newNode=new Node(currentNode);
				newNode.them(i);
				tree.addLast(newNode);
			}
		}
		else if(tree.size()>=max){
			for(int i=0;i<SoLoaiThucAn;i++){
				if(i!=currentLoai){
					Node newNode=new Node(currentNode);
					newNode.them(i);
					tree.addLast(newNode);
				}
			}
		}
		else{
			if(currentNode.tourLength<min){
				min=currentNode.tourLength;
				// minTour=currentNode.tour.clone();
				break;
			}
		}
	}
}
*/	

/*
out.print(" "+(minTour[0]+1));
for(int i=1;i<min;i++){
	out.print(" "+(minTour[i]+1));
}

out.println();
*/
/*
static int SoViTaMin;
static int ViTaMinToiThieu[];

static int SoLoaiThucAn;
static int ViTaMin[][];

static int dangXet[];
static int min=10;
static int max=10;
static int[] hanhTrinhHienTai=new int[min];
static int hanhTrinhMin[]=new int[min];

public static boolean duChat(){
	for(int i=0;i<SoViTaMin;i++)
		if(dangXet[i]<ViTaMinToiThieu[i])
			return false;
	return true;
}

public static void Search(int loai,int depth){
	if(depth>=max){
		return;
	}
	if(duChat()){
		if(depth<min){
			min=depth;
			return;
		}
	}
	else{
		hanhTrinhHienTai[depth]=loai;
		
		for(int i=0;i<depth;i++)
			System.out.print(hanhTrinhHienTai[i]);
		System.out.println();
		
		for(int i=0;i<SoViTaMin;i++)
			dangXet[i]+=ViTaMin[loai][i];
		depth++;
		for(int i=0;i<SoLoaiThucAn;i++){
			Search(i , depth);
			for(int j=0;j<SoViTaMin;j++)
				dangXet[i]-=ViTaMin[i][j];
		}
	}
}
*/