/*
 ID: htluand1
 TASK: ttwo
 LANG: JAVA
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ttwo {
	
	static char map[][];
	
	static void move(int dt[]){
		int tempx=dt[0],tempy=dt[1];
		if(dt[2]==1)
			tempx--;
		else if(dt[2]==2)
			tempy++;
		else if(dt[2]==3)
			tempx++;
		else if(dt[2]==4)
			tempy--;
		
		if(tempx>=0 && tempx<10 && tempy>=0 && tempy<10){
			if(map[tempx][tempy]!='*'){
				dt[0]=tempx;dt[1]=tempy;
			}
			else{
				dt[2]++;
				if(dt[2]==5) dt[2]=1;
			}
		}
		else{
			dt[2]++;
			if(dt[2]==5) dt[2]=1;
		}
	}

	public static void main(String[] args) throws IOException {
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("ttwo.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
		
		map=new char[10][10];
		
		int F[]=new int[3];F[2]=1;
		int C[]=new int[3];C[2]=1;
		
		for(int i=0;i<10;i++){
			map[i]=f.readLine().toCharArray();
			for(int j=0;j<10;j++){
				if(map[i][j]=='F'){
					F[0]=i;F[1]=j;
					map[i][j]='.';
				}
				if(map[i][j]=='C'){
					C[0]=i;C[1]=j;
					map[i][j]='.';
				}
			}
		}
		
		int t;
		boolean daGap=false;
		for(t=1;t<1000000;t++){
			move(F);
			move(C);
			if(F[0]==C[0] && F[1]==C[1]){
				daGap=true;break;
			}
		}
		
		if(!daGap)
			out.println(0);
		else
			out.println(t);
		
		out.close();
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-s);
		
		System.exit(0);
	}

}
