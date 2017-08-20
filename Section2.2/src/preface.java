/*
 ID: htluand1
 TASK: preface
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


public class preface {
	
	static int gtri[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
	static int solg[]=new int[gtri.length];
	
	static void doi(int x){
		for(int i=0;i<gtri.length;i++){
			while(x>=gtri[i]){
				x-=gtri[i];
				solg[i]++;
			}
			if(x==0)
				return;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("preface.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		
		Arrays.fill(solg, 0);
		
		for(int i=1;i<=n;i++){
			doi(i);
		}
		
		int dem;
		
		dem=solg[12]+solg[11]+solg[9];
		if(dem>0)
			out.println("I "+dem);
		
		dem=solg[11]+solg[10];
		if(dem>0)
			out.println("V "+dem);
		
		dem=solg[9]+solg[8]+solg[7]+solg[5];
		if(dem>0)
			out.println("X "+dem);
		
		dem=solg[7]+solg[6];
		if(dem>0)
			out.println("L "+dem);
		
		dem=solg[5]+solg[4]+solg[3]+solg[1];
		if(dem>0)
			out.println("C "+dem);
		
		dem=solg[3]+solg[2];
		if(dem>0)
			out.println("D "+dem);

		dem=solg[1]+solg[0];
		if(dem>0)
			out.println("M "+dem);
		
		out.close();
		System.exit(0);
	}
}


/*
static int dau1[]=new int[4];
static int dau5[]=new int[3];

static void doi(int x){
	if(x==0)	return;
	
	if(x==1)	{dau1[0]++;return;}
	if(x==5)	{dau5[0]++;return;}
	
	if(x==10)	{dau1[1]++;return;}
	if(x==50)	{dau5[1]++;return;}
	
	if(x==100)	{dau1[2]++;return;}
	if(x==500)	{dau5[2]++;return;}
	
	if(x==1000)	{dau1[3]++;return;}
	
	if(x==4)	{dau1[0]++;dau5[0]++;return;}
	if(x==9)	{dau1[0]++;dau1[1]++;return;}
	if(x==40)	{dau1[1]++;dau5[1]++;return;}
	if(x==90)	{dau1[1]++;dau1[2]++;return;}
	if(x==400)	{dau1[2]++;dau5[2]++;return;}
	if(x==900)	{dau1[2]++;dau1[3]++;return;}
	
	
	if(x==900+400) {doi(900);doi(400);return;}
	if(x==900+90) {doi(900);doi(90);return;}
	if(x==900+40) {doi(900);doi(40);return;}
	if(x==900+9) {doi(900);doi(9);return;}
	if(x==900+4) {doi(900);doi(4);return;}
	
	if(x==400+90) {doi(400);doi(90);return;}
	if(x==400+40) {doi(400);doi(40);return;}
	if(x==400+9) {doi(400);doi(9);return;}
	if(x==400+4) {doi(400);doi(4);return;}
	
	if(x==90+40) {doi(90);doi(40);return;}
	if(x==90+9) {doi(90);doi(9);return;}
	if(x==90+4) {doi(90);doi(4);return;}
	
	if(x==40+9) {doi(40);doi(9);return;}
	if(x==40+4) {doi(40);doi(4);return;}
	
	if(x>1000){
		while(x>1000){
			x-=1000;
			dau1[3]++;
			
		}
		doi(x);
		return;
	}
	
	if(x>500){
		while(x>500){
			x-=500;
			dau5[2]++;
		}
		doi(x);
		return;
	}
	
	if(x>100){
		while(x>100){
			x-=100;
			dau1[2]++;
		}
		doi(x);
		return;
	}
	if(x>50){
		while(x>50){
			x-=50;
			dau5[1]++;
		}
		doi(x);
		return;
	}
	
	if(x>10){
		while(x>10){
			x-=10;
			dau1[1]++;
		}
		doi(x);
		return;
	}
	
	if(x>5){
		while(x>5){
			x-=5;
			dau5[0]++;
		}
		doi(x);
		return;
	}
	
	if(x>1){
		while(x>1){
			x-=1;
			dau1[0]++;
			// System.out.println("Ghi 1");
		}
		doi(x);
		return;
	}
}
*/