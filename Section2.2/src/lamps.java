/*
ID: htluand1
TASK: lamps
LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class lamps {

	static int N;
	static int C;
	
	static int mau[];
	
	static int truongHop[][]={
		{0},
		{1,1,1,1},
		{1,0,1,0},
		{0,0,1,1},
		{0,1,1,0},
		{1,1,0,0},
		{1,0,0,1},
		{0,0,0,0},
		{0,1,0,1}
	};
	
	static ArrayList<String> dcChon=new ArrayList<String>();
	
	static void thu(int i){
		int test[]=new int[N+1];
		Arrays.fill(test, 0);
		
		if(truongHop[i][0]==1)
			for(int j=2;j<=N;j+=2){
				if((j-1) % 3 !=0)
					test[j]=1;
			}
		if(truongHop[i][1]==1)
			for(int j=2;j<=N;j+=2){
				if((j-1) % 3 ==0)
					test[j]=1;
			}
		if(truongHop[i][2]==1)
			for(int j=1;j<=N;j+=2){
				if((j-1) % 3 !=0)
					test[j]=1;
			}
		if(truongHop[i][3]==1)
			for(int j=1;j<=N;j+=2){
				if((j-1) % 3 ==0)
					test[j]=1;
			}
		
		
		boolean chapNhan=true;;
		for(int j=1;j<=N;j++){
			if((mau[j]!=-1) && (mau[j]!=test[j]) ){
				chapNhan=false;break;
			}
		}
		
		if(chapNhan){
			StringBuilder sb=new StringBuilder();
			for(int j=1;j<=N;j++)
				sb.append(test[j]);
			dcChon.add(sb.toString());
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		
		StringTokenizer st;
		
		st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(f.readLine());
		C=Integer.parseInt(st.nextToken());
		
		mau=new int[N+1];
		Arrays.fill(mau, -1);
		
		st=new StringTokenizer(f.readLine());
		int s=Integer.parseInt(st.nextToken());
		while(s!=-1){
			mau[s]=1;
			s=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(f.readLine());
		s=Integer.parseInt(st.nextToken());
		while(s!=-1){
			mau[s]=0;
			s=Integer.parseInt(st.nextToken());
		}
		
		if(C==0)
			thu(1);
		else if(C==1){
			thu(7);thu(3);thu(2);thu(5);
		}
		else if(C==2){
			thu(7);thu(3);thu(8);thu(4);thu(6);thu(5);thu(1);
		}
		else if(C>=3){
			thu(7);thu(3);thu(8);thu(4);thu(6);thu(2);thu(5);thu(1);
		}
		
		Collections.sort(dcChon);
		
		if(dcChon.isEmpty())
			out.println("IMPOSSIBLE");
		else{
			for(int i=0;i<dcChon.size();i++)
				out.println(dcChon.get(i));
		}
		
		out.close();
		System.exit(0);
		
		
	}
}
