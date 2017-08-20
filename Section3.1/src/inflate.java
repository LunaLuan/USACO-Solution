/*
 ID: htluand1
 TASK: inflate
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
import java.util.Comparator;
import java.util.StringTokenizer;

public class inflate {
	
	static class Category {
		int points;
		int time;
		// float diemtb;
		
		public Category(int po,int ti){
			points=po;
			time=ti;
			// diemtb=(float) po/ti;
		}
		
	}
	/*
	static class XepGiamDan implements Comparator<Category> {

		@Override
		public int compare(Category arg0, Category arg1) {
			// TODO Auto-generated method stub
			if(arg0.diemtb<arg1.diemtb)
				return 1;
			else if(arg0.diemtb==arg1.diemtb)
				return 0;
			else
				return -1;
		}
		
	}
	
	
	static int DeQuy(Category[] data,int t,int i){
		if(i<0)
			return 0;
		if(t<data[i].time)
			return DeQuy(data,t,i-1);
		
		return Math.max(data[i].points+DeQuy(data,t-data[i].time,i), DeQuy(data,t,i-1));
		
	}
	*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("inflate.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
	
		StringTokenizer st=new StringTokenizer(f.readLine());
		int length=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		Category data[]=new Category[N];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(f.readLine());
			data[i]=new Category(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
		}
		
		int a[]=new int[length+1];
		for(int i=0;i<N;i++){
			for(int t=0;t<=length;t++){
				if(t>=data[i].time)
					a[t]=Math.max(a[t], data[i].points+a[t-data[i].time]);
			}
		}
		
		// System.out.println(a[40][0]);
		out.println(a[length]);
		// System.out.println(DeQuy(data,length,N-1));
		out.close();
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
		
		System.exit(0);
		
	}

}

/*
if(length>=data[i].time){
	int soBai=length/data[i].time;
	length%=data[i].time;
	maxPoint+=soBai*data[i].points;
}
*/

/*
int a[]=new int[length+1];
for(int i=0;i<N;i++){
	for(int t=0;t<=length;t++){
		if(i==0 && t>=data[i].time)
			a[t]=Math.max(data[i].points+a[t-data[i].time],a[t]);
		else if(t>=data[i].time)
			a[t]=Math.max(data[i].points+a[t-data[i].time][i], a[t]);
		else if(i!=0 && t<data[i].time)
			a[t][i]=a[t][i-1];
	}
}
*/	
