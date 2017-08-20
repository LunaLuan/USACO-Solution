/*
ID: htluand1
TASK: concom
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


public class concom {

	public static void main(String[]args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("concom.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
		
		int N=Integer.parseInt(f.readLine());
		int a[][]=new int[102][102];
		int b[][]=new int[102][102];
		
		
		String chuoi=f.readLine();
		while(chuoi!=null){
			StringTokenizer st=new StringTokenizer(chuoi);
			int i=Integer.parseInt(st.nextToken()),j=Integer.parseInt(st.nextToken());
			a[i][j]=Integer.parseInt(st.nextToken());
			chuoi=f.readLine();	
		}
		/*
		for(int i=0;i<N+1;i++){
			for(int j=0;j<N+1;j++)
				System.out.print(a[i][j]+"\t");
			System.out.println();
		}
		*/
		for(int i=1;i<=101;i++){
			for(int j=1;j<=101;j++){
				if(i!=j && b[i][j]!=1 && a[i][j]>50){
						b[i][j]=1;
						for(int k=1;k<=101;k++){
								a[i][k]+=a[j][k];
								if(b[j][k]==1)
									b[i][k]=1;
						}
						j=0;
					
				}
			}
		}
		
		for(int i=1;i<=101;i++)
			for(int j=1;j<=101;j++)
				if(b[i][j]==1 && i!=j)
					out.println(i+" "+j);
		
		out.close();
		System.exit(0);
		
		
	}
}
