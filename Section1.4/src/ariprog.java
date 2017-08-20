/*
 ID: htluand1
 TASK: ariprog
 LANG: JAVA
 */

// import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
// import java.util.LinkedList;
import java.util.Scanner;


public class ariprog {
	
	static int depth;
	static int m;
	// static int[] songuyento;
	
	static class CapSoCong {
		int a;
		int d;
		
		public CapSoCong(int an,int dn){
			a=an;d=dn;
		}
	}
	
	static class SoSanhCapSoCong implements Comparator<CapSoCong>{

		@Override
		public int compare(CapSoCong c1, CapSoCong c2) {
			// TODO Auto-generated method stub
			if(c1.d>c2.d)
				return c1.d-c2.d;
			else if(c1.d==c2.d)
				return c1.a-c2.a;
			return -1;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
		// long start=System.currentTimeMillis();
		
		Scanner in=new Scanner(new File("ariprog.in"));
		PrintWriter out=new PrintWriter(new File("ariprog.out"));
		
		depth=in.nextInt();
		m=in.nextInt();
		// in.close();
		/*
		for(int i=0;i<=m;i++){
			for(int j=i;j<=m;j++){
				System.out.print(i*i+j*j+"\t");
			}
			System.out.println();
		}
		*/
		
		boolean[] bitsquares=new boolean[m*m+m*m+1];
		for(int i=0;i<=m;i++)
			for(int j=i;j<=m;j++)
				bitsquares[i*i+j*j]=true;
		
		ArrayList<CapSoCong> temp=new ArrayList<CapSoCong>();
		
		for(int i=0;i<bitsquares.length;i++){
			if(bitsquares[i]==true){
				for(int d=1;d<=3000;d++){
					int soluong=1;
					for(int de=1;de<depth;de++){
						if((i+de*d)<bitsquares.length && bitsquares[i+de*d]==true){
							soluong++;
						}
						
						else
							break;
							
					}
					if(soluong==depth)
						temp.add(new CapSoCong(i, d));
				}
			}
		}
	
		if(temp.size()==0)
			out.println("NONE");
		else{
			Collections.sort(temp,new SoSanhCapSoCong());
			for(int i=0;i<temp.size();i++){
				// if(temp.get(i).a!=temp.get(i+1).a)
				out.println(temp.get(i).a+" "+temp.get(i).d);
			}
			// out.println(temp.get(temp.size()-1).a+" "+temp.get(temp.size()-1).d);
		}
		
		out.close();
		System.exit(0);
		
		// long finish=System.currentTimeMillis();
		
		// System.out.println(finish-start);
		
	}
}

/*
for(int i=0;i<=m;i++){
	for(int j=0;j<=m;j++)
		System.out.print(a[i][j]+"\t");
	System.out.println();
}
*/

/*
for(int k=0;k<=m;k++){
	for(int q=1;q<=depth;q++){
		if(timTrongHang(a[i][j]+d*q, a, k)){
			soluong++;
			if(soluong==depth){
				temp[length]=new CapSoCong(a[i][j], d);
				length++;
			}
				
		}
	}
}
*/
/*
for(int i=0;i<=m;i++){
	for(int j=i;j<=m;j++){
		// if(a[i][j]!=0){
			// System.out.println(a[i][j]);
			int soluong=1;
			
			for(int d=1;d<=a[m][m]/2;d++){
				
				for(int q=1;q<depth;q++){
					
					for(int k=0;k<=m;k++){
						if(timTrongHang(a[i][j]+d*q , a, k )){
							soluong++;
							// System.out.print((a[i][j]+d*q)+"("+soluong+")"+" ");
							break;
						}
					}
					
					if(soluong==depth){
						temp.add(new CapSoCong(a[i][j], d));
						// length++;
						
					}
					
				}
				soluong=1;
				// System.out.println();
				
			// }
			
			
		}
	}
}
*/
/*
int[][] a=new int[m+1][m+1];
ArrayList<CapSoCong> temp=new ArrayList<CapSoCong>();    ////CapSoCong[10000];int length=0;
for(int i=0;i<=m;i++)
	for(int j=i;j<=m;j++)
		a[i][j]=i*i+j*j;

for(int i=0;i<=m;i++){
	for(int j=i;j<=m;j++){
		if(a[i][j]!=0){
			// System.out.println(a[i][j]);
			
			
			for(int d=1;d<=a[m][m]/2;d++){
				int soluong=1;
				for(int q=1;q<depth;q++){
					
					for(int k=0;k<=m;k++){
						if(timTrongHang(a[i][j]+d*q , a, k )){
							soluong++;
							// System.out.print((a[i][j]+d*q)+"("+soluong+")"+" ");
							break;
						}
					}
					
					if(soluong==depth){
						temp.add(new CapSoCong(a[i][j], d));
						// System.out.println(i+" "+j+" "+a[i][j]+" "+d);
						// length++;
						
					}
					// soluong=1;

				}
				
				// System.out.println();
				
			}
			
			
		}
	}
}

// xet rieng truong hop a=0
int a0=0;


for(int d=1;d<=a[m][m]/2;d++){
	int soluong=1;
	for(int q=1;q<depth;q++){
		
		for(int k=0;k<=m;k++){
			if(timTrongHang(a0+d*q , a, k )){
				soluong++;
				// System.out.print((a[i][j]+d*q)+"("+soluong+")"+" ");
				break;
			}
		}
		
		if(soluong==depth){
			temp.add(new CapSoCong(a0, d));
			// length++;
			
		}
	}
	// soluong=1;
	// System.out.println();
	
}

*/

/*
public static boolean timTrongHang(int x,int[][] a,int i){
	int left=1,right=m,mid;
	while(left<=right){
		mid=(left+right)/2;
		if(x==a[i][mid])
			return true;
		else if(x>a[i][mid]){
			left=mid+1;
		}
		else{
			right=mid-1;
		}
	}
	return false;
	
	//if(Arrays.binarySearch(a, fromIndex, toIndex, key))
	/*
	for(int j=1;j<=m;j++){
		if(a[i][j]==x)
			return true;
		else if(a[i][j]>x)
			return false;
	}
	return false;
	
}
*/

