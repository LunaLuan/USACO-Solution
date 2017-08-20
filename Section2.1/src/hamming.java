/*
 ID: htluand1
 TASK: hamming
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

public class hamming {
	
	static int N;
	static int B;
	static int D;
	static int solg=1;
	static int xh[][];
	
	public static int[] doiRaMang(int i){
		int a[]=new int[B];
		int bi=B-1;
		while(bi>=0){
			a[bi]=i & 1;
			i=i>>1;
			bi--;
		}
		return a;
	}
	
	public static boolean dat(int i){
		int a[]=doiRaMang(i);
		
		for(int j=0;j<solg;j++){
			int distance=0;
			for(int k=0;k<B;k++){
				if(a[k]!=xh[j][k]){
					distance++;
				}
			}
			if(distance<D)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		xh=new int[64][B];Arrays.fill(xh[0], 0);
		
		out.print("0 ");
		xh[0]=doiRaMang(0);
		
		solg=1;int i=1;
		while(solg<N){
			if(dat(i)){
				xh[solg]=doiRaMang(i);
				solg++;
				if(solg %10 ==0){
					out.print(i+"\n");
				}
				else{
					if(solg != N){
						out.print(i+" ");
					}
					else{
						out.print(i);
						out.println();
					}
				}
			}
			i++;
		}
		
		
		out.close();
		System.exit(0);
	}
}

/*
int a[]=doiRaMang(3);
for(int x:a){
	System.out.print(x);
}
*/

/*
public static boolean dat(int i){
	int a[]=doiRaMang(i);
	int distance=0;
	for(int j=0;j<B;j++){
		if(xh[j]==1){
			if(a[j]!=1)
				distance++;
		}
		else if(xh[j]==0){
			if(a[j]!=0){
				distance++;//xh[j]=1;
			}
		}
	}
	
	if(i==25){
		for(int x:xh)
			System.out.print(x);
		System.out.println();
	}

	System.out.println(i+" "+distance);
	if(distance>=D){
		for(int j=0;j<B;j++){
			if(a[j]==1){
				xh[j]=1;
			}
		}
		for(int x:xh)
			System.out.print(x);
		System.out.println();
		return true;
		
	}
	else
		return false;
}
*/

/*
int solg=1,i=1;
while(solg<N){
	if(dat(i)){
		solg++;
		out.print(i+" ");
	}
	i++;
}
*/
/*
for(int i=0;i<30;i++)
	dat(i);
*/