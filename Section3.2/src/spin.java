/*
ID: htluand1
TASK: spin
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
import java.util.List;
import java.util.StringTokenizer;


public class spin {

	static class Wheel {
		int speed;
		List<Integer> wedges;
	} 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("spin.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
		
		Wheel set[]=new Wheel[5];
		for(int i=0;i<5;i++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			
			set[i]=new Wheel();
			set[i].speed=Integer.parseInt(st.nextToken());
			set[i].wedges=new ArrayList<Integer>();
			
			int solg=Integer.parseInt(st.nextToken());
			for(int j=0;j<solg;j++){
				int temp=Integer.parseInt(st.nextToken());
				set[i].wedges.add(temp);
				set[i].wedges.add((temp+Integer.parseInt(st.nextToken()))%360);
			}
		}
		
		int t=0;
		
		while(true){
			
			int phanBo[]=new int[360];
			
			for(int i=0;i<5;i++){
				for(int j=0;j<set[i].wedges.size();j+=2){
					int start=set[i].wedges.get(j);
					int finish=set[i].wedges.get(j+1);
					if(start<=finish){
						for(int p=start;p<=finish;p++)
							phanBo[p]++;
					}
					else{
						for(int p=start;p<=359;p++)
							phanBo[p]++;
						for(int p=0;p<=finish;p++)
							phanBo[p]++;
					}
						
				}
			}
			
			boolean thoat=false;
			for(int i=0;i<360;i++)
				if(phanBo[i]==5)
					thoat=true;
			
			if(thoat)
				break;
			
			t++;
			if(t>100000){
				out.println("none");
				out.close();
				// System.out.println(System.currentTimeMillis()-s);
				System.exit(0);
			}
			
			for(int i=0;i<5;i++){
				for(int j=0;j<set[i].wedges.size();j++){
					set[i].wedges.set(j, (set[i].wedges.get(j)+set[i].speed)%360);
				}
			}

		}
		
		
		
		out.println(t);
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
		
	}

}
