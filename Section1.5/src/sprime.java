/*
 ID: htluand1
 TASK: sprime
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class sprime {

	public static boolean laSoNguyenTo(long x){
		for(long i=2;i*i<=x;i++){
			if(x%i==0)
				return false;
		}
		return true;
	}

	public static void Thu(int so,int mu,PrintWriter out){
		if(mu==1)
			out.println(so);
		else{
			for(int le=1;le<=9;le+=2){
				int somoi=so*10+le;
				if(laSoNguyenTo(somoi))
					Thu(somoi, mu-1, out);
			}
		}
			
	}
	
	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		
		int[] set={2,3,5,7};
		
		for(int i=0;i<set.length;i++){
			Thu(set[i],n,out);
		}

		out.close();
		
		// long fi=System.currentTimeMillis();
		
		// System.out.println(fi-s);
		System.exit(0);
		
	}
}



// Sang nguyen to
/*
for(int i=2;i<=n;i++){
	soNguyenTo[i]=true;
}



public static boolean laSoNguyenTo(int n){
		for(int i=2;i*i<=n;i++)
			if(n%i==0)
				return false;
		return true;
	}
	
	public static boolean laSoSieuNguyenTo(int n){
		while(n>=0){
			if(!laSoNguyenTo(n))
				return false;
			n=n/10;
		}
		return true;
	}

for(int i=2;i*i<=n;i++){
	if(soNguyenTo[i]){
		for(int j=i*i;j<=n;j+=i)
			soNguyenTo[j]=false;
	}
}
*/

/*
static boolean[] soNguyenTo=new boolean[1000000000];
static int start;
static int finish;

static class So {
	int i;
	boolean laSoNguyenTo;
	
	public So(int i){
		this.i=i;this.laSoNguyenTo=true;
	}
	
	public So(int i,boolean b){
		this.i=i;this.laSoNguyenTo=b;
	}
}

static LinkedList<So> so=new LinkedList<So>();

public static void TaoDaySo(int min,int max){
	// so.add(new So(0,false));so.add(new So(1,false));
	for(int i=min;i<max;i++){
		so.add(new So(i));
	}
}

public static void TaoDaySoNguyenTo(int min,int max){
	for(int i=2;i*i<max;i++){
		if(min<=i && max>=i && so.get(i).laSoNguyenTo)
			for(int j=i*i;j<max;j+=i){
				so.get(j).laSoNguyenTo=false;
			}
	}
}

public static boolean laSoSieuNguyenTo(int n){
	while(n!=0){
		if(!so.get(n).laSoNguyenTo)
			return false;
		n=n/10;
	}
	return true;
}

	static Deque q;
	
	public static void sinhSoSieuNguyenTo(long x,int n){
		q=new LinkedList<Long>();
		long finish=(long) Math.pow(10, n);
		q.addLast(x);
		
		while((long) q.peekFirst()<finish){
			long a=(long) q.getFirst();
			for(int i=1;i<=9;i+=2){
				long somoi=a*10+i;
				if(laSoNguyenTo(somoi)){
					q.addLast(somoi);
				}
			}
		}
	}
*/