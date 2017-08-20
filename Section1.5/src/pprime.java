/*
 ID: htluand1
 TASK: pprime
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class pprime {
	
	static int start;
	static int finish;
	
	
	public static boolean laSoNguyenTo(int x){
		for(int i=2;i*i<=x;i++)
			if(x%i==0)
				return false;
		return true;
	}
	
	public static void soNghichDao1(PrintWriter out){
		int[] set={2,3,5,7};
		for(int i=0;i<set.length;i++){
			if(set[i]>=start && set[i]<=finish)
				out.println(set[i]);
		}
	}
	
	public static void soNghichDao2(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			int somoi=d1*10+d1;
			if(somoi>=start && somoi<=finish && laSoNguyenTo(somoi))
				out.println(somoi);
		}
	}
	
	public static void soNghichDao3(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			for(int d2=0;d2<=9;d2++){
				int somoi=d1*100 + d2*10 + d1;
				if(somoi>=start && somoi<=finish && laSoNguyenTo(somoi))
					out.println(somoi);
			}
		}
	}
	
	public static void soNghichDao4(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			for(int d2=0;d2<=9;d2++){
				int somoi=d1*1000 + d2*100 +d2*10 + d1;
				if(somoi>=start && somoi<=finish && laSoNguyenTo(somoi))
					out.println(somoi);
			}
		}
	}
	
	public static void soNghichDao5(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			for(int d2=0;d2<=9;d2++){
				for(int d3=0;d3<=9;d3++){
					int somoi=d1*10000+d2*1000+d3*100+d2*10+d1;
					if(somoi>=start && somoi<=finish && laSoNguyenTo(somoi))
						out.println(somoi);
				}
			}
		}
	}
	
	public static void soNghichDao6(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			for(int d2=0;d2<=9;d2++){
				for(int d3=0;d3<=9;d3++){
					int somoi=d1*100000+d2*10000+d3*1000+d3*100+d2*10+d1;
					if(somoi>=start && somoi<=finish && laSoNguyenTo(somoi))
						out.println(somoi);
				}
			}
		}
	}
	
	public static void soNghichDao7(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			for(int d2=0;d2<=9;d2++){
				for(int d3=0;d3<=9;d3++){
					for(int d4=0;d4<=9;d4++){
						int somoi=d1*1000000+d2*100000+d3*10000+d4*1000+d3*100+d2*10+d1;
						if(somoi>=start && somoi<=finish && laSoNguyenTo(somoi))
							out.println(somoi);
					}
				}
			}
		}
	}
	
	public static void soNghichDao8(PrintWriter out){
		for(int d1=1;d1<=9;d1+=2){
			for(int d2=0;d2<=9;d2++){
				for(int d3=0;d3<=9;d3++){
					for(int d4=0;d4<=9;d4++){
						int somoi=d1*10000000+d2*1000000+d3*100000+d4*10000+d4*1000+d3*100+d2*10+d1;
						if(somoi<=start && somoi>=finish && laSoNguyenTo(somoi))
							out.println(somoi);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		start=Integer.parseInt(st.nextToken());
		finish=Integer.parseInt(st.nextToken());
		
		soNghichDao1(out);
		soNghichDao2(out);
		soNghichDao3(out);
		soNghichDao4(out);
		soNghichDao5(out);
		soNghichDao6(out);
		soNghichDao7(out);
		soNghichDao8(out);
		
		out.close();
		System.exit(0);
		
	}
	
}

/*
static class So {
	int i;
	boolean laNguyenTo;
	boolean laNghichDao;
	
	public So(int i){
		this.i=i;
		this.laNguyenTo=true;
	}
	
	public So(int i,boolean laNguyenTo){
		this.i=i;this.laNguyenTo=laNguyenTo;
	}
}

static LinkedList<So> so=new  LinkedList<So>();

public static void TaoDaySo(int n){
	so.add(new So(0,false));so.add(new So(1,false));
	for(int i=2;i<=n;i++)
		so.add(new So(i));
}

public static void TaoDaySoNguyenTo(int n){
	for(int i=2;i*i<=so.size();i++){
		if(so.get(i).laNguyenTo)
			for(int j=i*i;j<=so.size();j+=i)
				so.get(j).laNguyenTo=false;
	}
}

public static void TaoDaySoNghichDao(int n){
	int mu=0;
	while(n!=0){
		n=n/10;mu++;
	}
	
	for(int d1=0;d1<=9;d1++){
		if(mu>=1)
			so.get(d1).laNghichDao=true;
		
		if(mu>=2)
			so.get(d1*10+d1).laNghichDao=true;
		
		for(int d2=0;d2<=9;d2++){
			if(mu>=3)
				so.get(d1*100+d2*10+d1).laNghichDao=true;
			
			if(mu>=4)
				so.get(d1*1000+d2*100+d2*10+d1).laNghichDao=true;
			
			for(int d3=1;d3<=9;d3+=2){
				if(mu>=5)
					so.get(d1*10000+d2*1000+d3*100+d2*10+d1);
				
				if(mu>=6)
					
			}
		}
	}
}

*/
