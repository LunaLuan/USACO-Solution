/*
 ID: htluand1
 TASK: palsquare
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class palsquare {
	
	static char[] getNumberInBase(int number, int B) {
		String s = "";
		String b = "0123456789ABCDEFGHIJKLMN";
		while(number != 0) {
			int mol = number % B;
			number = number / B;
			
			// System.out.println(mol);
			s += b.charAt(mol);
		}
		String s1 = "";
		for(int i = s.length() - 1; i >= 0; i--) {
			s1 += s.charAt(i);
		}
		
		
		return s1.toCharArray();
	}
	
	static boolean isPalindrome(char a[]) {
		boolean ok = true;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != a[a.length - 1 - i]) {
				ok = false;
				break;
			}
		}
		return ok;
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("palsquare.in"));
		PrintWriter out = new PrintWriter(new File("palsquare.out"));

		int B = in.nextInt();
		for(int i = 1; i <= 300; i++) {
			int s = i * i;
			char is[] = getNumberInBase(i, B);
			char ss[] = getNumberInBase(s, B);
			
			if(isPalindrome(ss)) {
				for(int j = 0; j < is.length; j++)
					out.print(is[j]);
				out.print(" ");
				for(int j = 0; j < ss.length; j++)
					out.print(ss[j]);
				out.println();
			}
		}

		out.close();
		System.exit(0);
	}

}

/*
 * static char[] coso20={'0','1','2','3','4','5','6','7','8','9',
 * 'A','B','C','D','E','F','G','H','I','J'}; public static boolean
 * laSoDoiXung(int[] x){ for(int i=0;i<x.length/2;i++) if(x[i]!=x[x.length-1-i])
 * return false; return true; }
 * 
 * public static int[] doiCoSo(int x,int n){ Stack<Integer> s=new
 * Stack<Integer>(); while(x!=0){ s.push(x % n); x=x/n; } int[] dadoi=new
 * int[s.size()]; int i=0; while(!s.isEmpty()){ dadoi[i]=s.pop();i++; } return
 * dadoi; }
 * 
 * public static void inSo(int[] x,PrintWriter out){ for(int i=0;i<x.length;i++)
 * out.print(coso20[x[i]]); }
 * 
 * public static void main(String[] args) throws IOException { Scanner in=new
 * Scanner(new File("palsquare.in")); PrintWriter out=new PrintWriter(new
 * File("palsquare.out"));
 * 
 * int n=in.nextInt();
 * 
 * // int[] d={1,1,8,8,1}; //System.out.println(laSoDoiXung(d));
 * 
 * for(int i=1;i<=300;i++){ if(laSoDoiXung(doiCoSo(i*i,n))){
 * inSo(doiCoSo(i,n),out); out.print(" "); inSo(doiCoSo(i*i,n),out);
 * out.println(); } }
 * 
 * out.close(); System.exit(0); }
 */
