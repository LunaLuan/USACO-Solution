/*
ID: htluand1
TASK: range
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
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class range {

	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("range.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		int map[][]=new int[N][N];
		char temp[]=new char[N];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(f.readLine());
			temp=st.nextToken().toCharArray();
			for(int j=0;j<N;j++)
				map[i][j]=temp[j]-'0';
		}
		int kq[]=new int[N+1];
		
		for(int i=N-2;i>=0;i--){
			for(int j=N-2;j>=0;j--){
				if(map[i][j]==1){
					if(map[i+1][j]>=1 && map[i][j+1]>=1 && map[i+1][j+1]>=1)
						map[i][j]=1+Math.min(map[i][j+1], Math.min(map[i+1][j], map[i+1][j+1]));
					for(int pos=2;pos<=map[i][j];pos++)
						kq[pos]++;
				}
			}
		}
		
		for(int pos=2;pos<=N;pos++){
			if(kq[pos]>0)
				out.println(pos+" "+kq[pos]);
			else
				break;
		}
		
		
		// System.out.println(System.currentTimeMillis()-s);
		
		
		out.close();
		System.exit(0);
		
		
	}
}

/*
int kq[]=new int[N+1];

Deque<Integer> qX=new LinkedList<Integer>();
Deque<Integer> qY=new LinkedList<Integer>();

for(int i=0;i<N-1;i++){
	for(int j=0;j<N-1;j++){
		if(map[i][j]=='1'){
			int temp=map[i][j]+map[i+1][j]+map[i][j+1]+map[i+1][j+1];
			if(temp=='1'*4){
				qX.addLast(i);qY.addLast(j);
			}
			else
				map[i][j]='0';
		}
	}
}
kq[2]=qX.size();
for(int i=0;i<N;i++){
	map[N-1][i]='0';
	map[i][N-1]='0';
}

for(int pos=3;pos<=N;pos++){
	int size=kq[pos-1];
	for(int k=0;k<size;k++){
		int i=qX.removeFirst();
		int j=qY.removeFirst();
		if(map[i][j]=='1'){
			int temp=map[i][j]+map[i+1][j]+map[i][j+1]+map[i+1][j+1];
			if(temp=='1'*4){
				qX.addLast(i);qY.addLast(j);
			}
			else
				map[i][j]='0';
		}
	}
	kq[pos]=qX.size();
	if(kq[pos]==0)
		break;
}
*/
