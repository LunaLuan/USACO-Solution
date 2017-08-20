/*
ID: htluand1
TASK: ratios
LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ratios {

	static class CauHinh {
		int x,y,z;
		
		CauHinh(int a,int b,int c){
			x=a;y=b;z=c;
		}
		
	}
	
	static int min=1000000;
	static int kq1=0,kq2=0,kq3=0,kq=0;
	
	static CauHinh goc,m1,m2,m3;
	/*
	static void tim(int s1,int s2,int s3,int ht1,int ht2,int ht3){
		// System.out.println(kq1+" "+kq2+" "+kq3+" "+min);
		// System.out.println("  "+s1+" "+s2+" "+s3);
		
		if(s1==8 || s2==10 || s3==10)
			return;
		else {
			boolean ok=kiemTra(ht1,ht2,ht3);
			
			if(ok){
				if(min>(s1+s2+s3)){
					min=s1+s2+s3;
					kq1=s1;kq2=s2;kq3=s3;
				}
				return;
			}
			else{
				tim(s1+1,s2,s3,ht1+m1.x,ht2+m1.y,ht3+m1.z);
				tim(s1,s2+1,s3,ht1+m2.x,ht2+m2.y,ht3+m2.z);
				tim(s1,s2,s3+1,ht1+m3.x,ht2+m3.y,ht3+m3.z);
			}
		}
	}
	
	*/
	
	
	static boolean kiemTra(int ht1, int ht2, int ht3) {
		// TODO Auto-generated method stub
		int d1,c1,d2,c2,d3,c3;
		
		if(goc.x==0 && goc.y==0 && goc.z!=0){
			if(ht1!=0 && ht2!=0)
				return false;
			d3=ht3%goc.z;
			if(d3==0)
				return true;
		}
		if(goc.x==0 && goc.y!=0 && goc.z==0){
			if(ht1!=0 && ht3!=0)
				return false;
			d3=ht2%goc.y;
			if(d3==0)
				return true;
		}
		if(goc.x!=0 && goc.y==0 && goc.z==0){
			if(ht2!=0 && ht3!=0)
				return false;
			d3=ht1%goc.x;
			if(d3==0)
				return true;
		}
		
		if(goc.x==0 && goc.y!=0 && goc.z!=0){
			if(ht1!=0)
				return false;
			d3=ht3%goc.z;c3=ht3/goc.z;
			d2=ht2%goc.y;c2=ht2/goc.y;
			if(d3==0 && d2==0 && c2==c3)
				return true;
		}
		if(goc.x!=0 && goc.y!=0 && goc.z==0){
			if(ht3!=0)
				return false;
			d1=ht1%goc.x;c1=ht1/goc.x;
			d2=ht2%goc.y;c2=ht2/goc.y;
			if(d1==0 && d2==0 && c2==c1)
				return true;
		}
		if(goc.x!=0 && goc.y==0 && goc.z!=0){
			if(ht2!=0)
				return false;
			d3=ht3%goc.z;c3=ht3/goc.z;
			d1=ht1%goc.x;c1=ht1/goc.x;
			if(d3==0 && d1==0 && c1==c3)
				return true;
		}
		
		if(goc.x!=0 && goc.y!=0 && goc.z!=0){
			d3=ht3%goc.z;c3=ht3/goc.z;
			d2=ht2%goc.y;c2=ht2/goc.y;
			d1=ht1%goc.x;c1=ht1/goc.x;
			if(d1==0 && d3==0 && d2==0 && c2==c3 && c1==c2)
				return true;
		}
		
		return false;
		
	}
	



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("ratios.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		goc=new CauHinh(Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st=new StringTokenizer(f.readLine());
		m1=new CauHinh(Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		
		st=new StringTokenizer(f.readLine());
		m2=new CauHinh(Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		st=new StringTokenizer(f.readLine());
		m3=new CauHinh(Integer.parseInt(st.nextToken()), 
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		
		if(goc.x==0 && goc.y==0 && goc.z==0){
			if(m1.x==0 && m1.y==0 && m1.z==0){
				kq=1;kq1=1;
			}
			else if(m2.x==0 && m2.y==0 && m2.z==0){
				kq=1;kq2=1;
			}
			else if(m1.x==0 && m1.y==0 && m1.z==0){
				kq=1;kq3=1;
			}
			if(kq==0)
				out.println("NONE");
			else
				out.println(kq1+" "+kq2+" "+kq3+" "+kq);
			
			out.close();
			System.exit(0);
		}
		
		
		int ht1,ht2,ht3;
		for(int i=0;i<100;i++){
			for(int j=0;j<100;j++){
				for(int k=0;k<100;k++){
					if(i==0 && j==0 && k==0){
						
					}
					else{
						ht1=i*m1.x+j*m2.x+k*m3.x;
						ht2=i*m1.y+j*m2.y+k*m3.y;
						ht3=i*m1.z+j*m2.z+k*m3.z;
						
						boolean ok=kiemTra(ht1, ht2, ht3);
						
						if(ok){
							if(min>(i+j+k)){
								min=i+j+k;
								kq1=i;kq2=j;kq3=k;
							}
						}
					}
				}
			}
		}
		
		
		if(min>1000)
			out.println("NONE");
		else{
			kq=(kq1*m1.x+kq2*m2.x+kq3*m3.x)/goc.x;
			out.println(kq1+" "+kq2+" "+kq3+" "+kq);
		}
		
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
		
	}

}
