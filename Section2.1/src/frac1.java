/*
 ID: htluand1
 TASK: frac1
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class frac1 {
	
	
	static class PhanSo {
		int tu;
		int mau;
		float kq;
		
		public PhanSo(int t,int m){
			tu=t;mau=m;kq=(float) (1.0*tu/mau);
		}
	}
	
	static class PhanSoComparator implements Comparator<PhanSo> {

		@Override
		public int compare(PhanSo o1, PhanSo o2) {
			// TODO Auto-generated method stub
			if(o1.kq==o2.kq){
				if(o1.tu>o2.tu)
					return 1;
			}
			
			if(o1.kq>o2.kq)
				return 1;
			
			return -1;
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		
		List<PhanSo> l =new ArrayList<PhanSo>();
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		int N=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<N;i++){
			for(int j=N;j>i;j--){
				l.add(new PhanSo(i, j));
			}
		}
		
		Collections.sort(l,new PhanSoComparator());
		
		out.println("0/1");
		PhanSo point=new PhanSo(0,1);
		for(int i=0;i<l.size();i++){
			if(l.get(i).kq != point.kq){
				out.println(l.get(i).tu+"/"+l.get(i).mau);
				point=l.get(i);
			}
		}
		out.println("1/1");
		
		out.close();
		System.exit(0);
	}
}
