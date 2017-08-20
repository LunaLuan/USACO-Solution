/*
ID: htluand1
TASK: kimbits
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


public class kimbits {
	
	static int N;
	static int L;
	static long I;
		
	/*
	static void tao(String s,PrintWriter out){
		// System.out.println(s);
		if(s.length()==N){
			int dem=0;
			for(int i=0;i<s.length();i++)
				if(s.charAt(i)=='1')
					dem++;
			if(dem<=L){
				soLg++;
				if(soLg==I){
					out.println(s);
					out.close();
					System.out.println(System.currentTimeMillis()-st);
					System.exit(0);
				}
			}
			return;
		}
		
		tao(s+"0",out);
		tao(s+"1",out);
		
	}
	*/
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long start=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("kimbits.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		I=Long.parseLong(st.nextToken());
		
		int combo[][]=new int[N+1][L+1];
		for(int i=0;i<=N;i++){
			combo[i][0]=1;
		}
		for(int i=1;i<=N;i++){
			for(int j=1;j<=L;j++){
				combo[i][j]=combo[i-1][j]+combo[i-1][j-1];
			}
		}
		/*
		for(int i=0;i<=N;i++){
			for(int j=0;j<=L;j++){
				System.out.print(combo[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		char kq[]=new char[N];
		Arrays.fill(kq, '0');
		int l=L;
		for(int i=0;i<N;i++){
			int sum=0;
			for(int j=0;j<=L;j++)
				sum+=combo[N-i-1][j];
			if(sum<I){
				kq[i]='1';
				L--;
				I-=sum;
			}
		}
		
		out.println(kq);
		out.close();
		
		// System.out.println(System.currentTimeMillis()-start);
		
		System.exit(0);
		
	}

}

/*
String s="";
for(int i=0;i<N;i++)
	s+="0";
char c[]=s.toCharArray();

int dem=0;
while(dem<I-1){
	// System.out.println(c);
	for(int i=s.length()-1;i>=0;i--){
		if(c[i]=='0'){
			c[i]='1';
			for(int j=i+1;j<s.length();j++){
				c[j]='0';
			}
			break;
		}
	}
	
	int so1=0;
	for(int i=0;i<s.length();i++){
		if(c[i]=='1')
			so1++;
	}
			
	if(so1<=L)
		dem++;
}
*/
