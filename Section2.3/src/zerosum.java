/*
 ID: htluand1
 TASK: zerosum
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class zerosum {
	
	static PrintWriter out;
	
	static int tinh(String s){
		Stack<Integer> so1=new Stack<Integer>();
		int i=0;
		while(i<s.length()){
			int temp=0;
			if(s.charAt(i)>='1' && s.charAt(i)<='9'){
				temp+=s.charAt(i)-'0';
				while( (i+1)<s.length() && s.charAt(i+1)==' '){
					temp=10*temp+s.charAt(i+2)-'0';
					i+=2;
				}
				so1.push(temp);
				i++;
			}
			else{
				char op=s.charAt(i);
				i++;
				temp+=s.charAt(i)-'0';
				while( (i+1)<s.length() && s.charAt(i+1)==' '){
					temp=10*temp+s.charAt(i+2)-'0';
					i+=2;
				}
				int kq=0;
				if(op=='+')
					kq=so1.pop()+temp;
				else if(op=='-')
					kq=so1.pop()-temp;
				so1.push(kq);
				i++;
			}
		}
		return so1.pop();
	}

	static void tim(String bieuthuc,int viTri){
		if(viTri>bieuthuc.length()-2){
			int kq=tinh(bieuthuc);
			if(kq==0)
				out.println(bieuthuc);
		}
		else{
			char[] bt=bieuthuc.toCharArray();
			bt[viTri]=' ';
			tim(String.valueOf(bt),viTri+2);
			bt[viTri]='+';
			tim(String.valueOf(bt),viTri+2);
			bt[viTri]='-';
			tim(String.valueOf(bt),viTri+2);
		}
	}
	
	public static void main(String[] args) throws IOException{
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("zerosum.in"));
		out=new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		
		StringBuilder sb=new StringBuilder();
		sb.append("1");
		int i=2;
		while(i<=N){
			sb.append(" ");
			sb.append(""+i);
			i++;
		}
		
		tim(sb.toString(),1);
		out.close();
		
		// long fi=System.currentTimeMillis();
		
		// System.out.println(fi-s);
		System.exit(0);
	}
}
