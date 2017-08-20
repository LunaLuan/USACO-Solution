/*
 ID: htluand1
 TASK: castle
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


public class castle {
	
	static class Module {
		boolean wall[]=new boolean[4];  // tay(0) - bac(1) - dong(2) - nam(3) 
		int roomNumber=-1;
		
		public Module(int n) {
			if((n & 1) == 1)
				wall[0]=true;
			if((n & 2) == 2)
				wall[1]=true;
			if((n & 4) == 4)
				wall[2]=true;
			if((n & 8)==8)
				wall[3]=true;
		}
		
		
	}
	
	static Module map[][];
	static int hang;
	static int cot;
	static int rNumber;
	static int area[];
	static int maxArea;
	
	

	public static void paintRoom(int i,int j){
		if(map[i][j].roomNumber == -1){
			map[i][j].roomNumber=rNumber;
			if(!map[i][j].wall[3])
				paintRoom(i+1, j);
			if(!map[i][j].wall[1])
				paintRoom(i-1, j);
			if(!map[i][j].wall[0])
				paintRoom(i, j-1);
			if(!map[i][j].wall[2])
				paintRoom(i, j+1);
		}
	}
	

	static int maxAreaUpdate;
	
	public static boolean updateMaxArea(int soPhong1,int soPhong2,int bucTuong){
		int p;
		if(soPhong1==soPhong2)
			p=area[soPhong1];
		else
			p=area[soPhong1]+area[soPhong2];
		
		if(p>maxAreaUpdate){
			maxAreaUpdate=p;
			return true;
		}
		else
			return false;
	}
	
	public static void veLauDai(){
		
		for(int j=0;j<cot;j++){
			if(map[0][j].wall[1])
				System.out.print(" _");
			else
				System.out.print(" ");
		}	
		
		for(int i=0;i<hang;i++){
			
			System.out.println();
			
			for(int j=0;j<cot;j++){
				if(map[i][j].wall[0])
					System.out.print("|");
				else
					System.out.print(" ");
				
				if(map[i][j].wall[3])
					System.out.print("_");
				else
					System.out.print(" ");
				/*
				if(map[i][j].wall[2])
					System.out.print("|");
				else
					System.out.print(" ");
					*/
				
			}
			
			if(map[i][cot-1].wall[2])
				System.out.print("|");
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader f=new BufferedReader(new FileReader("castle.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		cot=Integer.parseInt(st.nextToken());
		hang=Integer.parseInt(st.nextToken());
		
		map=new Module[hang][cot];
		
		for(int i=0;i<hang;i++){
			st=new StringTokenizer(f.readLine());
			for(int j=0;j<cot;j++){
				map[i][j]=new Module(Integer.parseInt(st.nextToken()));
			}
		}
		
		// veLauDai();
		
		for(int i=0;i<hang;i++){
			for(int j=0;j<cot;j++){
				if(map[i][j].roomNumber == -1){
					paintRoom(i, j);
					rNumber++;
				}
			}
		}

		area=new int[rNumber];
		for(int i=0;i<hang;i++){
			for(int j=0;j<cot;j++){
				area[map[i][j].roomNumber]++;
			}
		}
		
		for(int i=0;i<rNumber;i++){
			if(area[i]>maxArea){
				maxArea=area[i];
			}
		}
		int r=0,c=0,wa = 0;
		for(int j=0;j<cot;j++){
			for(int i=hang-1;i>=0;i--){
				
				if(j>0){
					if(map[i][j].wall[0])
						if(updateMaxArea(map[i][j].roomNumber,map[i][j-1].roomNumber,0)){
							r=i;c=j;wa=0;
						}
				}
				
				if(i<hang-1){
					if(map[i][j].wall[3])
						if(updateMaxArea(map[i][j].roomNumber,map[i+1][j].roomNumber,3)){
							r=i;c=j;wa=3;
						}
				}
				
				if(i>0){
					if(map[i][j].wall[1])
						if(updateMaxArea(map[i][j].roomNumber,map[i-1][j].roomNumber,1)){
							r=i;c=j;wa=1;
						}
				}
				
				if(j<cot-1){
					if(map[i][j].wall[2])
						if(updateMaxArea(map[i][j].roomNumber, map[i][j+1].roomNumber, 2)){
							r=i;c=j;wa=2;
						}
				}
				
				
			}
		}
		String kq="";
		if(wa==0)
			kq="W";
		else if(wa==3)
			kq="S";
		else if(wa==1)
			kq="N";
		else if(wa==2)
			kq="E";
		
		out.println(rNumber);
		out.println(maxArea);
		out.println(maxAreaUpdate);
		out.println((r+1)+" "+(c+1)+" "+kq);
		
		out.close();
		System.exit(0);
		
	}
}

//System.out.println(r+" "+c+" "+wa+" "+maxAreaUpdate);




/*
System.out.println();
for(int i=0;i<hang;i++){
	for(int j=0;j<cot;j++){
		System.out.print(map[i][j].roomNumber+" ");
	}
	System.out.println();
}
*/
