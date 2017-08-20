/*
 ID: htluand1
 TASK: sort3
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


public class sort3 {
	
	public static void swap(int i,int j,int[] a){
		int tg=a[i];
		a[i]=a[j];
		a[j]=tg;
	}
	
	public static int tim(int x,int start,int finish,int[] a){
		for(int i=start;i<finish;i++){
			if(a[i]==x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int[] a=new int[N];
		
		for(int i=0;i<N;i++){
			st=new StringTokenizer(f.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			// System.out.println(a[i]);
		}
		/*
		for(int i=0;i<N;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		*/
		int soLan=0;
		int so1=0,so2=0,so3=0;
		
		for(int i=0;i<N;i++){
			if(a[i]==1)
				so1++;
			if(a[i]==2)
				so2++;
			if(a[i]==3)                 
				so3++;
		}
		
		for(int i=0;i<so1;i++){
			int vitri;
			if(a[i] != 1){
				if(a[i] == 2){
					vitri=tim(1, so1 , so1+so2 , a);
					if(vitri!=-1){
						swap(i,vitri,a);soLan++;
					}
					else {
						vitri=tim(1, so1+so2 , N  , a);
						if(vitri!=-1){
							swap(i,vitri,a);soLan++;
						}
					}
				}
				else if (a[i] == 3){
					vitri=tim(1, so1+so2 , N , a);
					if(vitri!=-1){
						swap(i,vitri,a);soLan++;
					}
					else {
						vitri=tim(1, so1 , so1+so2  , a);
						if(vitri!=-1){
							swap(i,vitri,a);soLan++;
						}
					}
				}
			}
		}
		
		for(int i=so1;i<so1+so2;i++){
			int vitri;
			if(a[i] != 2){
				vitri=tim(2, so1+so2 , N , a);
				if(vitri!=-1){
					swap(i,vitri,a);soLan++;
				}
			}
		}
		/*
		for(int i=0;i<N;i++){
			System.out.print(a[i]+" ");
		}
		
		System.out.println(so1+" "+so2+" "+so3);
		*/
		
		out.println(soLan);
		
		out.close();
		System.exit(0);
	}
}

/*
for(j=i+1;j<N;j++){
	if(a[j]<=a[min])
		min=j;
}
if(min!=i){
	int tg=a[i];
	a[i]=a[min];
	a[min]=tg;
	soLan++;
}
else if(min==3)
	break;
*/

/*
for(int i=so1;i<so1+so2;i++){
	int vitri;
	if(a[i]==1){
		vitri=tim(2, 0, so1, a);
		if(vitri!=-1){
			swap(i,vitri,a);soLan++;
		}
	}
	else if(a[i]==3){
		vitri=tim(2, so1+so2 , N , a);
		if(vitri!=-1){
			swap(i,vitri,a);soLan++;
		}
	}
}

for(int i=so1+so2;i<N;i++){
	int vitri;
	if(a[i]==1){
		vitri=tim(3, 0, so1, a);
		if(vitri!=-1){
			swap(i,vitri,a);soLan++;
		}
	}
	else if(a[i]==2){
		vitri=tim(2, so1 , so1+so2 , a);
		if(vitri!=-1){
			swap(i,vitri,a);soLan++;
		}
	}
}
*/