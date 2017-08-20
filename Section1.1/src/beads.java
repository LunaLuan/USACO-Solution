/*
 ID: htluand1
 TASK: beads
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Tham khao: https://gist.github.com/AlexanderMitov/8240415
public class beads {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f=new BufferedReader(new FileReader("beads.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		int count=Integer.parseInt(f.readLine());
		String necklace= f.readLine();
		necklace+=necklace;
		
		// [0][n] la do, [1][n] la xanh
		int left[][]=new int[2][necklace.length()];
		int right[][]=new int[2][necklace.length()];
		
		char temp[]=necklace.toCharArray();
		// khoi tao trai
		if(temp[0]=='r') 
			left[0][0]=1;
		else if(temp[0]=='b')
			left[1][0]=1;
		else if(temp[0]=='w') {
			left[1][0]=1;
			left[0][0]=1;
		}
		// khoi tao phai
		if(temp[temp.length-1]=='r') 
			right[0][temp.length-1]=1;
		else if(temp[temp.length-1]=='b')
			right[1][temp.length-1]=1;
		else if(temp[temp.length-1]=='w') {
			right[1][temp.length-1]=1;
			right[0][temp.length-1]=1;
		}
		
		
		for(int i=1;i<temp.length;i++) {
			if(temp[i]=='r') {
				left[0][i]=left[0][i-1]+1;
				left[1][i]=0;
			}
			else if(temp[i]=='b') {
				left[0][i]=0;
				left[1][i]=left[1][i-1]+1;
			}
			else if(temp[i]=='w') {
				left[0][i]=left[0][i-1]+1;
				left[1][i]=left[1][i-1]+1;
			}
		}
		for(int i=temp.length-2;i>=0;i--) {
			if(temp[i]=='r') {
				right[0][i]=right[0][i+1]+1;
				right[1][i]=0;
			}
			else if(temp[i]=='b') {
				right[0][i]=0;
				right[1][i]=right[1][i+1]+1;
			}
			else if(temp[i]=='w') {
				right[0][i]=right[0][i+1]+1;
				right[1][i]=right[1][i+1]+1;
			}
		}
		int max=0;
		for(int i=0;i<temp.length-1;i++) {
			int tong=max(left[0][i], left[1][i]) + max(right[0][i+1], right[1][i+1]);
			max=max(max, tong);
		}
		
		if(max>count)
			max=count;
		
		
		
		out.println(max);
		out.close();
		System.exit(0);
	}

	private static int max(int a,int b) {
		// TODO Auto-generated method stub
		if(a>b)
			return a;
		else
			return b;
	}
}

/*
Scanner in=new Scanner(new File("beads.in"));
PrintWriter out=new PrintWriter(new File("beads.out"));

int N=in.nextInt();
String chars=in.next();
chars=chars.concat(chars);
char[] s=chars.toCharArray();

int size=s.length;
int[][] left=new int[size+1][2];// Arrays.fill(left,0);
int[][] right=new int[size+1][2];// Arrays.fill(right,0);
/*
if(s[0]=='r')
	left[0][0]=1;
else if(s[0]=='b')
	left[0][1]=1;
else{
	left[0][0]=1;left[0][1]=1;
}

if(s[size-1]=='r')
	left[size-1][0]=1;
else if(s[size-1]=='b')
	left[size-1][1]=1;
else{
	left[size-1][0]=1;left[size-1][1]=1;
}

for(int i=1;i<size;i++){
	if(s[i-1]=='r'){
		left[i][0]=left[i-1][0]+1;
		left[i][1]=0;
	}
	else if(s[i-1]=='b'){
		left[i][1]=left[i-1][1]+1;
		left[i][0]=0;
	}
	else{
		left[i][0]=left[i-1][0]+1;
		left[i][1]=left[i-1][1]+1;
	}
}

for(int i=size-1;i>=0;i--){
	if(s[i]=='r'){
		right[i][0]=right[i+1][0]+1;
		right[i][1]=0;
	}
	else if(s[i]=='b'){
		right[i][1]=right[i+1][1]+1;
		right[i][0]=0;
	}
	else{
		right[i][0]=right[i+1][0]+1;
		right[i][1]=right[i+1][1]+1;
	}
}

int max=0;
for(int i=1;i<size;i++){
	max=max(max,max(left[i][0],left[i][1])+max(right[i][0],right[i][1]));
}
if(max>N)
	max=N;

out.println(max);
out.close();

System.exit(0);
*/
