/*
 ID: htluand1
 TASK: milk2
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
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class milk2 {
	
	static class Doan {
		int start;
		int end;
		
		Doan(int start, int end) {
			this.start=start;
			this.end=end;
		}
	}
	
	static class DoanComparator implements Comparator<Doan> {

		@Override
		public int compare(Doan t1, Doan t2) {
			// TODO Auto-generated method stub
			if(t1.start>t2.start)
				return 1;
			else if(t1.start==t2.start)
				return 0;
			else
				return -1;
		}
		
	}


	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		int max_continue=0;
		int max_no_milk=0;

		int N=Integer.parseInt(f.readLine());
		Doan doan[]=new Doan[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(f.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			doan[i]=new Doan(start, end);
			if(end-start>max_continue)
				max_continue=end-start;
			// System.out.print(max_continue+" "+ start+" "+ end);
		}
		Arrays.sort(doan, new DoanComparator());
		
		int currentStart= doan[0].start;
		int currentEnd= doan[0].end;
		for(int i=1;i<N;i++) {
			if(doan[i].start<=currentEnd) {
				if(doan[i].end>currentEnd)
					currentEnd=doan[i].end;
				int doanLienTuc= currentEnd- currentStart;
				if(doanLienTuc>max_continue)
					max_continue=doanLienTuc;
			}
			else {
				int doanRoiRac=doan[i].start-currentEnd;
				currentStart=doan[i].start;
				currentEnd=doan[i].end;
				if(doanRoiRac>max_no_milk)
					max_no_milk=doanRoiRac;
			}
		}
		
		
		out.println(max_continue+" "+max_no_milk);
		out.close();
		
		System.exit(0);
	}
}

/*
static class ND {
		int S;
		int F;
		
		public ND(int s,int f){
			S=s;F=f;
		}
	}
	
	static class NDcomparator implements Comparator<ND> {

		@Override
		public int compare(ND nd1, ND nd2) {
			// TODO Auto-generated method stub
			return nd1.S-nd2.S;
		}

		
	}
	
	public static int max(int a,int b){
		if(a>b)	return a;
		return b;
	}

int size=in.nextInt();
ND[] nd=new ND[size];

for(int i=0;i<size;i++)
	nd[i]=new ND(in.nextInt(),in.nextInt());

Arrays.sort(nd,new NDcomparator());

int max_continue=0,max_no_milk=0,current_start,current_finish;

current_start=nd[0].S;
current_finish=nd[0].F;
max_continue=current_finish-current_start;
for(int i=1;i<size;i++){
	while(i<size && nd[i].S<=current_finish){
		int conti=nd[i].F-current_start;
		max_continue=max(conti,max_continue);
		if(nd[i].F>current_finish)
			current_finish=nd[i].F;
		i++;
	}
	if(i<size){
		max_continue=max(max_continue, nd[i].S-nd[i].F);
		max_no_milk=max(max_no_milk,nd[i].S-current_finish);
		current_start=nd[i].S;
		current_finish=nd[i].F;
	}
}
*/
