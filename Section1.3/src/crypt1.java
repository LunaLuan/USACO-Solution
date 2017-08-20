/*
 ID: htluand1
 TASK: crypt1
 LANG: JAVA
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


public class crypt1 {
	
	static boolean isPermutation(int k, int a[]) {
		boolean ok = true;
		while(k > 0) {
			int j = k % 10;
			k /= 10;
			
			boolean has = false;
			for(int i = 0; i < a.length; i++) {
				if(j == a[i]) {
					has = true;
					break;
				}
			}
			
			if(!has) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("crypt1.in"));
		PrintWriter out=new PrintWriter(new File("crypt1.out"));
		
		int N = in.nextInt();
		int n[] = new int[N];
		for(int i = 0; i < N; i++)
			n[i] = in.nextInt();
		
		HashSet<Integer> numbersSet = new HashSet<Integer>();
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		// generate permutation
		for(int i = 0; i < N; i++) {
			int x = n[i];
			for(int j = 0; j < N; j++) {
				x = x * 10 + n[j];
				for(int k = 0; k < N; k++) {
					x = x * 10 + n[k];
					if(x >= 100) {
						numbersSet.add(x);
						numbersList.add(x);
					}
					x /= 10;
				}
				x /= 10;
			}
			x /= 10;
		}
		
		int result = 0;
		for(int numerator: numbersList) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int part1 = n[i] * numerator;
					int part2 = n[j] * numerator;
					
					if(numbersSet.contains(part1) 
							&& numbersSet.contains(part2)) {
						int denominator = part1 * 10 + part2;
						if(denominator >= 1000 
								&& isPermutation(denominator, n)) {
							result++;
						}
					}
				}
			}
		}
		
		out.println(result);
		
		out.close();
		System.exit(0);
			
	}

	
}

/*
public static LinkedList doiSangChuoi(int m){
		LinkedList<Integer> so=new LinkedList<Integer>();
		while(m!=0){
			so.addFirst(m%10);
			m=m/10;
		}
		return so;
	}
	
	public static boolean laChinhHop(int m,int[] set){
		String so=String.valueOf(m);
		int trung=0;
		for(int i=0;i<so.length();i++){
			for(int k=0;k<set.length;k++)
				if(so.charAt(i)-'0'==set[k]){
					trung=1;break;
				}
			if(trung==0)
				return false;
			trung=0;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("crypt1.in"));
		PrintWriter out=new PrintWriter(new File("crypt1.out"));
		
		int n=in.nextInt();
		int[] set=new int[n];
		for(int i=0;i<set.length;i++)
			set[i]=in.nextInt();
		
		int soluong=0;
		
		for(int i=100;i<1000;i++){
			if(laChinhHop(i,set))
				for(int k=10;k<100;k++){
					if(laChinhHop(k,set))
						if(laChinhHop(k*i,set) && k<10000)
							if(laChinhHop(k/10*i,set) && k/10*i<1000)
								if(laChinhHop(k%10*i,set) && k%10*i<1000){
									soluong++;
									// System.out.println(k+" "+i);
								}
			}
		}
		
		out.println(soluong);
		// System.out.println(laChinhHop(1776,set));
		out.close();
		System.exit(0);
			
	}

*/
