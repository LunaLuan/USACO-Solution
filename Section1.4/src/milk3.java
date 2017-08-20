/*
 ID: htluand1
 TASK: milk3
 LANG: JAVA
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class milk3 {
	// Tham khao: http://blog.csdn.net/supersnow0622/article/details/9493955
	
	static int A,B,C;
	static boolean[][][] used=new boolean[25][25][25];
	static boolean[] recorder;
	
	public static void move(int a,int b,int c){
		if(used[a][b][c])
			return;
		else
			used[a][b][c]=true;
		
		if(a==0 && recorder[c]==false)
			recorder[c]=true;
		// c sang a
		if(a+c>=A)
			move(A,b,a+c-A);
		else
			move(a+c,b,0);
		// c sang b
		if(b+c>=B)
			move(a,B,b+c-B);
		else
			move(a,b+c,0);
		
		// a sang b
		if(a+b>=B)
			move(a+b-B,B,c);
		else
			move(0,b+a,c);
		// a sang c
		if(a+c>=C)
			move(a+c-C,b,C);
		else
			move(0,b,c+a);
		
		// b sang a,c
		if(b+a>=A)
			move(A,a+b-A,c);
		else
			move(a+b,0,c);
		
		if(b+c>=C)
			move(a,b+c-C,C);
		else
			move(a,0,b+c);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("milk3.in"));
		PrintWriter out=new PrintWriter(new File("milk3.out"));
		
		A=in.nextInt();
		B=in.nextInt();
		C=in.nextInt();
		in.close();
		
		recorder=new boolean[C+1];
		
		move(0,0,C);
		
		List<Integer> l=new ArrayList<Integer>();
		for(int i=0;i<C+1;i++)
			if(recorder[i]){
				l.add(i);
			}
		
		for(int i=0;i<l.size();i++){
			out.print(l.get(i));
			if(i<l.size()-1)
				out.print(" ");
		}
		
		out.println();
		out.close();
		
		System.exit(0);
		
	}
	
}



/*
public class milk3 {
	
	static int[] max={2,5,10};
	// static int[] a=new int[3];
	
	static List<Integer> l=new ArrayList<Integer>();
	
	static int[][][] daxet=new int[25][25][25];

	public static void move(int s,int m,int f,int[] a){
		if(a[0]==0)
			l.add(a[2]);
		
		if(daxet[a[0]][a[1]][a[2]]>6){
			return;
		}
		if(a[s]==0 || a[f]==max[f] ){
			if(a[0]==0 && a[1]==3 && a[2]==7)
				
			return;
		}
		
		else{
			daxet[a[0]][a[1]][a[2]]++;
			System.out.println(a[0]+" "+a[1]+" "+a[2]+"("+s+","+m+","+f+")");
			
			/*
			a[f]+=min(a[s],max[f]);
			a[s]-=min(a[s],max[f]);
			
			if(a[s]+a[f]<max[f]){
				a[f]=a[f]+a[s];a[s]=0;
			}
			else{
				a[s]=a[f]+a[s]-max[f];a[f]=max[f];
			}
			/*
			if(a[0]==0 && a[1]==3 && a[2]==7)
				System.out.println("Ở đây,đã bị out ra tại "+s+" "+m+" "+f);
			
			int[] a1=a.clone();//System.out.println("Clone:"+a1[0]+" "+a1[1]+" "+a1[2]+"("+s+","+m+","+f+")");
			int[] a2=a.clone();
			int[] a3=a.clone();
			int[] a4=a.clone();
			int[] a5=a.clone();
			int[] a6=a.clone();
			
			System.out.println("Clone:"+a1[0]+" "+a1[1]+" "+a1[2]+"("+s+","+m+","+f+")");
			move(s,m,f,a1);
			move(s,f,m,a2);System.out.println("Clone2:"+a2[0]+" "+a2[1]+" "+a2[2]+"("+s+","+m+","+f+")");
			move(m,f,s,a3);move(m,s,f,a4);
			move(f,m,s,a5);move(f,s,m,a6);
			
			//daxet[a[0]][a[1]][a[2]]=true;
		}
	}
	/*
	public static int min(int a,int b){
		if(a>b)
			return b;
		return a;
	}
	
	public static void khoiTaoA(int[] a){
		a[0]=0;a[1]=0;a[2]=max[2];
		int[][][] daxet2=new int[25][25][25];
		daxet=daxet2.clone();
	}
	public static void main(String[] args){
		int [] a=new int[3];
		//khoiTaoA(a);
		//move(2,1,0,a);
		System.out.println();
		khoiTaoA(a);
		// System.out.println(daxet[2][3][5]);
		move(2,0,1,a);
		//System.out.println(daxet[2][0][1]);
		for(int x:l)
			System.out.print(x+" ");
	}
	
	
}
*/

