/*
 ID: htluand1
 TASK: milk
 LANG: JAVA
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class milk {
	
	static class Farmer {
		int p;
		int a;
	}
	
	static class FarmerComparator implements Comparator<Farmer> {
		@Override
		public int compare(Farmer arg0, Farmer arg1) {
			if(arg0.p > arg1.p) 
				return 1;
			else if(arg0.p == arg1.p)
				return 0;
			else
				return -1;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("milk.in"));
		PrintWriter out=new PrintWriter(new File("milk.out"));
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		Farmer farmers[] = new Farmer[M];
		for(int i = 0; i < M; i++) {
			farmers[i] = new Farmer();
			farmers[i].p = in.nextInt();
			farmers[i].a = in.nextInt();
		}
		Arrays.sort(farmers, new FarmerComparator());
		
		int money = 0;
		int i = 0;
		while(N > 0 && i < M) {
			// System.out.println(money);
			if(farmers[i].a < N) {
				N -= farmers[i].a;
				money += farmers[i].p * farmers[i].a;
			}
			else {
				money += farmers[i].p * N;
				N = 0;
			}
			i++;
		}
		
		out.println(money);
		
		out.close();
		System.exit(0);
	}
	
}

/*
static class ND {
	int so_luong;
	int gia;
	
	public ND(int g,int sl){
		so_luong=sl;
		gia=g;
	}
}

static class NDcomparator implements Comparator<ND> {

	@Override
	public int compare(ND nd1, ND nd2) {
		// TODO Auto-generated method stub
		return nd1.gia-nd2.gia;
	}
	
}

public static void main(String[] args) throws IOException{
	Scanner in=new Scanner(new File("milk.in"));
	PrintWriter out=new PrintWriter(new File("milk.out"));
	
	int can_mua=in.nextInt();
	ND[] nd=new ND[in.nextInt()];
	
	for(int i=0;i<nd.length;i++)
		nd[i]=new ND(in.nextInt(),in.nextInt());
	
	Arrays.sort(nd,new NDcomparator());
	
	int i=0,gia=0;
	while(can_mua>0){
		if(can_mua>=nd[i].so_luong){
			gia+=nd[i].so_luong*nd[i].gia;
			can_mua-=nd[i].so_luong;
		}
		else{
			gia+=nd[i].gia*can_mua;
			can_mua=0;
		}
		i++;
	}
	
	out.println(gia);
	
	out.close();
	System.exit(0);
}
*/
