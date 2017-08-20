/*
 ID: htluand1
 TASK: barn1
 LANG: JAVA
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class barn1 {
	
	static void printArray(int c[]) {
		for(int i = 0; i < c.length; i++)
			System.out.print(c[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("barn1.in"));
		PrintWriter out=new PrintWriter(new File("barn1.out"));
		
		int M = in.nextInt();
		int S = in.nextInt();
		int C = in.nextInt();
		
		int c[] = new int[C];
		for(int i = 0; i < c.length; i++) {
			c[i] = in.nextInt();
		}
		Arrays.sort(c);
		// printArray(c);
		
		int empty[] = new int[c.length - 1];
		for(int i = 0; i < c.length - 1; i++) {
			empty[i] = c[i + 1] - c[i];
		}
		Arrays.sort(empty);
		// printArray(empty);
		
		int result = c[C - 1] - c[0] + 1;
		int currentIndexInEmpty = empty.length - 1;
		M = Math.min(M, empty.length + 1);
		for(int i = 0; i < M - 1; i++) {
			// System.out.println(result);
			result -= empty[currentIndexInEmpty] - 1;
			currentIndexInEmpty--;
		}
		
		out.println(result);
		
		out.close();
		System.exit(0);
		
	}
}

/*
static class GiamDan implements Comparator<Integer> {

	@Override
	public int compare(Integer i1, Integer i2) {
		// TODO Auto-generated method stub
		return i2-i1;
	}
	
}

static class TangDan implements Comparator<Integer> {

	@Override
	public int compare(Integer i1, Integer i2) {
		// TODO Auto-generated method stub
		return i1-i2;
	}
	
}


public static void main(String[] args) throws IOException{
	Scanner in=new Scanner(new File("barn1.in"));
	PrintWriter out=new PrintWriter(new File("barn1.out"));
	
	int max=in.nextInt();
	int stalls_number=in.nextInt();
	Integer[] point=new Integer[in.nextInt()];
	for(int i=0;i<point.length;i++)
		point[i]=in.nextInt();
	Arrays.sort(point,new TangDan());
	int length=point[point.length-1]-point[0]+1;
	
	
	Integer[] kc=new Integer[point.length-1];
	for(int i=0;i<kc.length;i++)
		kc[i]=point[i+1]-point[i]-1;
	
	
	
	
	
	Arrays.sort(kc,new GiamDan());
	int i=0;
	int k=max;
	while(k>1 && i<kc.length){
		length-=kc[i];
		i++;k--;
	}
	
	
	out.println(length);
	
	out.close();
	System.exit(0);
	
}
*/
