/*
 ID: htluand1
 TASK: runround
 LANG: JAVA 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class runround {

	static int hash1[];
	static int hash2[];
	static int a[];
	static int length;
	
	static void doiSoRaMang(int x){
		a=new int[10];
		hash1=new int[10];
		hash2=new int[10];
		length=0;
		while(x!=0){
			a[length]=x%10;
			x=x/10;
			length++;
		}
	}
	
	static void run(){
		int i=length-1;
		
		while(true){
			int k=i;
			for(int xoay=0;xoay<a[i];xoay++){
				k--;
				if(k<0)
					k=length-1;
			}
			if(k!=i && hash1[a[k]]==0)
				hash1[a[k]]=1;
			else
				return;
			i=k;
		 }
		
		
	}
			
		
	
	static boolean test(int x){
		doiSoRaMang(x);
		for(int i=0;i<length;i++){
			if(a[i]==0)
				return false;
			if(hash2[a[i]]==0)
				hash2[a[i]]=1;
			else
				return false;
		}
		run();
		for(int i=0;i<length;i++){
			if(hash1[a[i]]==0)
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException{
		long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("runround.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		int x=Integer.parseInt(st.nextToken());
		
		x++;
		while(!test(x)){
			// System.out.println(x+" "+test(x));
			x++;
		}
			
		out.println(x);
		out.close();
		
		long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
				
		
		System.exit(0);
	}
}

/*
 for(int i=length-1;i>=0;i--){
			int k=i;
			for(int xoay=0;xoay<a[i];xoay++){
				k--;
				if(k<0)
					k=length-1;
			}
			if(k!=i){
				if(i==0)
					
				hash1[a[k]]=1;
			}
		}
while(!daXetHet){
			int k=i;
			for(int xoay=0;xoay<a[i];xoay++){
				k--;
				if(k<0)
					k=length-1;
			}
			if(k!=i && hash1[a[k]]==0)
				hash1[a[k]]=1;
			else
				return;
			
			if(k==length-1)
				return;
			
			int daxet=0;
			for(int j=0;j<length;j++)
				if(hash1[a[j]]==1)
					daxet++;
			if(daxet==length)
				daXetHet=true;
			
			i=k;
		 }
*
*
*/
