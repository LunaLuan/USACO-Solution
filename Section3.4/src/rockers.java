/*
ID: htluand1
TASK: rockers
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


public class rockers {
	
	static int N;
	static int items[];
	static int T;
	static int M;
	
	// static int kq=0;
	
	static int giai(int current[],int index){
		if(index==N) {
			return 0;
		}
		else {
			int max=giai(current,index+1);
			for(int i=0;i<M;i++){
				if(current[i]+items[index]<=T){
					current[i]+=items[index];
					int temp=giai(current,index+1)+1;
					if(temp>max)
						max=temp;
					current[i]-=items[index];
				}
			}
			return max;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("rockers.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		N=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		items=new int[N+1];
		st=new StringTokenizer(f.readLine());
		for(int i=1;i<N+1;i++){
			items[i]=Integer.parseInt(st.nextToken());
		}
		/*
		for(int i=0;i<N;i++){
			int current[]=new int[M];
			giai(current, i);
		}
		*/
		int dp[][][]=new int[25][25][25];
		int best=0;
		for(int a=0;a<M;a++){
			for(int b=0;b<T+1;b++){
				for(int c=0;c<=N;c++){
					for(int d=c+1;d<=N;d++){
						if(b+items[d]<=T){
							if(dp[a][b][c]+1>dp[a][b+items[d]][d])
								dp[a][b+items[d]][d]=dp[a][b][c]+1;
						}
						else {
							if(dp[a][b][c]+1>dp[a+1][items[d]][d])
								dp[a+1][items[d]][d]=dp[a][b][c]+1;
						}
						
					}
					if(dp[a][b][c]>best)
						best=dp[a][b][c];
				}
			}
		}
		out.println(best);
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
	}

}

/*
int temp1[][]=current.clone(),temp2[][]=current.clone();
for(int i=0;i<soTui;i++){
	boolean daThay=false;
	if(current[1][i]+items[index]<=max){
		temp2[1][i]+=items[index];
		temp2[0][i]++;
		giai(temp2,index+1);
		daThay=true;
		break;
	}
	if(daThay)	break;
}
giai(temp1,index+1);
*/
