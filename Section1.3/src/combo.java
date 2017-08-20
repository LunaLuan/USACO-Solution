/*
 ID: htluand1
 TASK: combo
 LANG: JAVA
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

// Tham khao:http://m.blog.csdn.net/blog/u013534690/40597329

public class combo {
	// Kho value
	static int length;
	static int[] combo1=new int[3];
	static int[] combo2=new int[3];
	
	public static boolean close(int a,int b){
		if(Math.abs(a-b)<=2) return true;
		if(Math.abs(a-b)>=length-2) return true;
		return false;
	}
	
	public static boolean LaKhoa(int i,int j,int k){
		if(close(i,combo1[0]) && close(j,combo1[1]) && close(k,combo1[2])
				|| close(i,combo2[0]) && close(j,combo2[1]) && close(k,combo2[2]))
			return true;
		return false;
		
		/*
		if((Math.abs(i-combo1[0])<=2 || Math.abs(i-combo1[0]-length)>=length-2)
				&& (Math.abs(j-combo1[1])<=2 || Math.abs(j-combo1[1])>=length-2)
				&& (Math.abs(k-combo1[2])<=2 || Math.abs(k-combo1[2])>=length-2))
			return true;
		if((Math.abs(i-combo2[0])<=2 || Math.abs(i-combo2[0])>=length-2)
				&& (Math.abs(j-combo2[1])<=2 || Math.abs(j-combo2[1])>=length-2)
				&& (Math.abs(k-combo2[2])<=2 || Math.abs(k-combo2[2])>=length-2))
			return true;
		/*
		if((Math.abs(i-combo1[0])<=2 || Math.abs(i-combo1[0]+length)<=2)
				&& (Math.abs(j-combo1[1])<=2 || Math.abs(j-combo1[1]+length)<=2)
				&& (Math.abs(k-combo1[2])<=2 || Math.abs(k-combo1[2]+length)<=2))
			return true;
		if((Math.abs(i-combo2[0])<=2 || Math.abs(i-combo2[0]+length)<=2)
				&& (Math.abs(j-combo2[1])<=2 || Math.abs(j-combo2[1]+length)<=2)
				&& (Math.abs(k-combo2[2])<=2 || Math.abs(k-combo2[2]+length)<=2))
			return true;
			*/

	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("combo.in"));
		PrintWriter out=new PrintWriter(new File("combo.out"));
		
		LinkedList<Integer> temp=new LinkedList<Integer>();
		length=in.nextInt();
		while(in.hasNext())
			temp.addLast(in.nextInt());
		
		for(int i=0;i<temp.size()/2;i++){
			combo1[i]=temp.get(i);
			combo2[i]=temp.get(i+temp.size()/2);
		}
		
		int soluong=0;
		
		for(int i=1;i<=length;i++){
			for(int j=1;j<=length;j++){
				for(int k=1;k<=length;k++){
					if(LaKhoa(i,j,k)){
						soluong++;
						// System.out.println(i+","+j+","+k);
					}
				}
			}
		}
		
		out.println(soluong);
		out.close();
		System.exit(0);
	}

	

}
