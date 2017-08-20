/*
ID: htluand1
TASK: fact4
LANG: JAVA
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;


public class fact4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("fact4.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
		
		int N=Integer.parseInt(f.readLine());
		
		
		int duoi=1;
		for(int i=2;i<=N;i++){
			int temp=duoi*i;
			while(temp%10==0)
				temp/=10;
			duoi=temp%10000;
		}
		
		out.println(duoi%10);
		out.close();
		/*
		long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
		
		BigInteger gt=BigInteger.ONE;
		for(long i=2;i<=N;i++){
			gt=gt.multiply(BigInteger.valueOf(i));
			System.out.println(i+" "+gt.toString());
		}
		*/
		
		System.exit(0);
		
		
	}

}


/*
String temp=String.valueOf(i*duoi);
int j;
for(j=temp.length()-1;j>=0;j--)
	if(temp.charAt(j)!='0')
		break;
duoi=temp.charAt(j)-'0';
*/

/*
int duoi=1;
for(int i=2;i<=N;i++){
	String temp=String.valueOf(duoi*i);
	int j;
	for(j=temp.length()-1;j>=0;j--)
		if(temp.charAt(j)!='0')
			break;
	duoi=temp.charAt(j)-'0';
}

out.println(duoi);
out.close();
*/
