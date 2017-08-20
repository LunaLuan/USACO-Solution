/*
 ID: htluand1
 TASK: prefix
 LANG: JAVA
 */

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class prefix {

	static String s;
	static List<String> goc;
	
	
	public static void main(String[] args) throws IOException{
		
		Scanner in=new Scanner(new FileReader("prefix.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		
		String temp=in.next();
		goc=new ArrayList<String>();
		while(!temp.equals(".")){
			goc.add(temp);
			temp=in.next();
		}
		
		// String next=in.nextLine();
		StringBuilder sb=new StringBuilder();
		while(in.hasNext()){
			sb.append(in.nextLine());
		}
		s=sb.toString();
		// System.out.println(s);
		
		int t[][]=new int[goc.size()][s.length()];
		
		for(int j=s.length()-1;j>=0;j--){
			for(int i=0;i<goc.size();i++){
				if(j+goc.get(i).length()>s.length())
					t[i][j]=0;
				else{
					String test=s.substring(j, j+goc.get(i).length()  );
					if(!test.equals(goc.get(i)))
						t[i][j]=0;
					else{
						int max=0;
						for(int k=0;k<goc.size();k++){
							if(j+goc.get(i).length()<s.length() 
									&& t[k][j+goc.get(i).length()]>max)
								max=t[k][j+goc.get(i).length()];
						}
						t[i][j]=goc.get(i).length()+max;
					}
				}
			}
		}
		
		int max=0;
		for(int k=0;k<goc.size();k++)
			if(t[k][0]>max)
				max=t[k][0];
		
		out.println(max);
		out.close();
		
		// System.out.println(s.length());
		// System.out.println(System.currentTimeMillis()-st);
		
		
		System.exit(0);
		
	}
}

/*
static int longest(int start,int vitri){
	if(start>=s.length())
		return 0;
	/*
	if(end+start>=s.length())
		return 0;
	
	else{
		int end=goc.get(vitri).length();
		if(end+start<=s.length()){
			String test=s.substring(start,end+start);
			if(!test.equals(goc.get(vitri)))
				return 0;
			else{
				int max=0;
				for(int i=0;i<goc.size();i++){
					int temp=longest(start+test.length(),i);
					if(temp>max)
						max=temp;
				}
				return test.length()+max;
			}
		}
		else
			return 0;
	}
	
}
*/
