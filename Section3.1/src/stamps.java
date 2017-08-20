/*
ID: htluand1
TASK: stamps
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
import java.util.Comparator;
import java.util.StringTokenizer;


public class stamps {

	static int set[];
	static int K;
	static int v=3000000;
	
	static int soLanDoi(int sum,int i){
		if(i<0)
			return v;
		if(sum==0)
			return 0;
		if(sum<0)
			return v;
		
		return Math.min(1+soLanDoi(sum-set[i],i), soLanDoi(sum,i-1));
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long sta=System.currentTimeMillis();
		
		
		BufferedReader f=new BufferedReader(new FileReader("stamps.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
		
		
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		K=Integer.parseInt(st.nextToken());
		set=new int[Integer.parseInt(st.nextToken())];
		
		st=new StringTokenizer(f.readLine());
		for(int i=0;i<set.length;i++){
			if(st.countTokens()==0)
				st=new StringTokenizer(f.readLine());
			set[i]=Integer.parseInt(st.nextToken());
		}
		
		//Arrays.sort(set);
		
		int a[]=new int[v];
		int s;
		for(s=1;s<v;s++){
			int min,asi_1;
			int x,y;
			if(s>=set[0])
				x=1+a[s-set[0]];
			else
				x=v;
			a[s]=x;
			asi_1=x;
			for(int i=1;i<set.length;i++){
				if(s>=set[i])
					x=1+a[s-set[i]];
				else
					x=v;
				min=Math.min(x, asi_1);
				asi_1=min;
				if(min<a[s])
					a[s]=min;
			}
			if(a[s]>K)
				break;
		}
		
		out.println(s-1);
		out.close();
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-sta);
		
		System.exit(0);
		
	}

}

/*
int i=1;
while(true){
	int temp=soLanDoi(i,set.length-1);
	if(temp<=K)
		i++;
	else
		break;
}
*/

/*
int a[][]=new int[v][set.length];

for(int i=0;i<set.length;i++)
	a[0][i]=0;
int s;
for(s=1;s<v;s++){
	for(int i=0;i<set.length;i++){
		int x,y;
		if(s>=set[i])
			x=1+a
			[s-set[i]][i];
		else
			x=v;
		if(i>0)
			y=a[s][i-1];
		else
			y=v;
		
		a[s][i]=Math.min(x, y);	
	}
	int min=v;
	for(int i=0;i<set.length;i++)
		if(a[s][i]<min)
			min=a[s][i];
	if(min>K)
		break;
}
*/
