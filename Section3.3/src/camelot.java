/*
ID: htluand1
TASK: camelot
LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class camelot {
	
	static int R,C;
	static int map[][][][];
	static int mapForKing[][];
	/*
	static class Min {
		int x,y;
		int soBuoc;
		int index;
		
		Min(int xi,int yi,int soBuoci,int indexi){
			x=xi;y=yi;soBuoc=soBuoci;index=indexi;
		}
	}
	
	static List<Min> min;
	*/
	
	static void BFS(int x,int y,int Xindex,int Yindex){
		Deque<Integer> qX=new LinkedList<Integer>();
		Deque<Integer> qY=new LinkedList<Integer>();
		
		qX.addLast(x);qY.addLast(y);
		
		boolean daDi[][]=new boolean[C][R];
		
		int soBuoc=0;
		daDi[x][y]=true;
		while(!qX.isEmpty()){
			int size=qX.size();
			for(int i=0;i<size;i++){
				x=qX.removeFirst();y=qY.removeFirst();
				map[y][x][Yindex][Xindex]+=soBuoc;
				
				// daDi[x][y]=true;
				
				if((x-2)>=0 && (x-2)<=C-1 && (y-1)>=0 && (y-1)<=R-1 && !daDi[x-2][y-1]){
					qX.addLast(x-2);qY.addLast(y-1);
					daDi[x-2][y-1]=true;
				}
				if((x-2)>=0 && (x-2)<=C-1 && (y+1)>=0 && (y+1)<=R-1 && !daDi[x-2][y+1]){
					qX.addLast(x-2);qY.addLast(y+1);
					daDi[x-2][y+1]=true;
				}
				
				if((x-1)>=0 && (x-1)<=C-1 && (y-2)>=0 && (y-2)<=R-1 && !daDi[x-1][y-2]){
					qX.addLast(x-1);qY.addLast(y-2);
					daDi[x-1][y-2]=true;
				}
				if((x-1)>=0 && (x-1)<=C-1 && (y+2)>=0 && (y+2)<=R-1 && !daDi[x-1][y+2]){
					qX.addLast(x-1);qY.addLast(y+2);
					daDi[x-1][y+2]=true;
				}
				
				if((x+2)>=0 && (x+2)<=C-1 && (y-1)>=0 && (y-1)<=R-1 && !daDi[x+2][y-1]){
					qX.addLast(x+2);qY.addLast(y-1);
					daDi[x+2][y-1]=true;
				}
				if((x+2)>=0 && (x+2)<=C-1 && (y+1)>=0 && (y+1)<=R-1 && !daDi[x+2][y+1]){
					qX.addLast(x+2);qY.addLast(y+1);
					daDi[x+2][y+1]=true;
				}
				
				if((x+1)>=0 && (x+1)<=C-1 && (y-2)>=0 && (y-2)<=R-1 && !daDi[x+1][y-2]){
					qX.addLast(x+1);qY.addLast(y-2);
					daDi[x+1][y-2]=true;
				}
				if((x+1)>=0 && (x+1)<=C-1 && (y+2)>=0 && (y+2)<=R-1 && !daDi[x+1][y+2]){
					qX.addLast(x+1);qY.addLast(y+2);
					daDi[x+1][y+2]=true;
				}
			}
			soBuoc++;
		}
	}
	
	static void createMapForKing(int x,int y){
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				mapForKing[i][j]=Math.max(Math.abs(y-i),Math.abs(x-j));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("camelot.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		
		int xV,yV;
		st=new StringTokenizer(f.readLine());
		xV=st.nextToken().charAt(0)-'A';
		yV=Integer.parseInt(st.nextToken())-1;
		
		List<Integer> xMa=new ArrayList<Integer>();
		List<Integer> yMa=new ArrayList<Integer>();
		String ma=f.readLine();
		while(ma!=null){
			st=new StringTokenizer(ma);
			while(st.countTokens()>0){
				int x=st.nextToken().charAt(0)-'A';
				int y=Integer.parseInt(st.nextToken())-1;
				xMa.add(x);yMa.add(y);
			}
			ma=f.readLine();
		}
		if(xMa.size()==0){
			out.println("0");
			out.close();
			System.exit(0);
		}
		
		
		map=new int[R][C][R][C];
		mapForKing=new int[R][C];
		
		createMapForKing(xV, yV);
		
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				BFS(j,i,j,i);
		
		int min=10000;
		for(int k=0;k<xMa.size();k++){
			int x=xMa.get(k),y=yMa.get(k);
			int ketHop[][]=new int[R][C];
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++)
					ketHop[i][j]=mapForKing[i][j]+map[i][j][y][x];
			}
			for(int u=0;u<R;u++){
				for(int v=0;v<C;v++){
					for(int i=0;i<R;i++){
						for(int j=0;j<C;j++){
							if(ketHop[u][v]+map[i][j][u][v]<ketHop[i][j]){
								ketHop[i][j]=ketHop[u][v]+map[i][j][u][v];
							}
						}
					}
				}
			}
			for(int kTemp=0;kTemp<xMa.size();kTemp++){
				if(k!=kTemp){
					int xTemp=xMa.get(kTemp),yTemp=yMa.get(kTemp);
					for(int i=0;i<R;i++)
						for(int j=0;j<C;j++)
							ketHop[i][j]+=map[i][j][yTemp][xTemp];
				}
			}
			
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					// System.out.print(ketHop[i][j]+" ");
					if(ketHop[i][j]<min)
						min=ketHop[i][j];
				}
				// System.out.println();
			}
			// System.out.println();
		}	
		
		out.println(min);
		out.close();
		
		System.out.println(System.currentTimeMillis()-s);
		System.exit(0);
		
	}

}


/*
for(int i=0;i<R;i++){
	for(int j=0;j<C;j++)
		System.out.print(mapForKing[i][j]+" ");
	System.out.println();
}
for(int i=0;i<xMa.size();i++){
	BFS(xMa.get(i),yMa.get(i),i,0);
}
for(int i=0;i<min.size();i++){
	System.out.println(min.get(i).x+" "+min.get(i).y+" "+min.get(i).soBuoc+"  "+min.get(i).index);
}

for(int i=0;i<R;i++){
	for(int j=0;j<C;j++)
		System.out.print(map[i][j][1]+" ");
	System.out.println();
}
*/
