/*
 ID: htluand1
 TASK: dualpal
 LANG: JAVA
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class dualpal {
	
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
		Scanner in = new Scanner(new File("dualpal.in"));
		PrintWriter out = new PrintWriter(new File("dualpal.out"));

		int N = in.nextInt();
		int S = in.nextInt();
		
		while(N != 0) {
			S++;
			int k = 0;
			for(int i = 2; i <= 10 ; i++) {
				boolean ip = isPalindrome(getNumberInBase(S, i));
				if(ip)
					k++;
			}
			// System.out.println(S + " " + k);
			if(k >= 2) {
				out.println(S);
				N--;
			}
		}
		
		out.close();
		System.exit(0);

	}

}

/*
 * public static boolean laSoDoiXung(int[] x){ for(int i=0;i<x.length/2;i++)
 * if(x[i]!=x[x.length-1-i]) return false; return true; }
 * 
 * public static int[] doiCoSo(int x,int n){ Stack<Integer> s=new
 * Stack<Integer>(); while(x!=0){ s.push(x % n); x=x/n; } int[] dadoi=new
 * int[s.size()]; int i=0; while(!s.isEmpty()){ dadoi[i]=s.pop();i++; } return
 * dadoi; }
 * 
 * public static boolean coNhieuHon1CoSoDoiXung(int x){ int soluong=0; for(int
 * i=2;i<=10;i++){ if(laSoDoiXung(doiCoSo(x,i))){ soluong++; if(soluong==2)
 * return true; } } return false; }
 * 
 * public static void main(String[] args) throws IOException{ Scanner in=new
 * Scanner(new File("dualpal.in")); PrintWriter out=new PrintWriter(new
 * File("dualpal.out"));
 * 
 * int soluong=in.nextInt(); int start=in.nextInt();
 * 
 * while(soluong>0){ start++; if(coNhieuHon1CoSoDoiXung(start)){
 * out.println(start); soluong--; } }
 * 
 * 
 * out.close(); System.exit(0); }
 */
