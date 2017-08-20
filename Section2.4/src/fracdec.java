/*
 ID: htluand1
 TASK: fracdec
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
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class fracdec {

	public static void main(String[] args) throws IOException{
		// long start=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("fracdec.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		int tu=Integer.parseInt(st.nextToken());
		int mau=Integer.parseInt(st.nextToken());
		
		if(tu%mau==0)
			out.println(1.0*tu/mau);
		else{
			List<Integer> l2=new ArrayList<Integer>();
			// int i=-1;
			boolean daXuatHien=false;
			int l1[]=new int[1000000];Arrays.fill(l1, -1);
			int kq=tu/mau;
			StringBuilder s=new StringBuilder();s.append(kq+".");
			tu=(tu-kq*mau)*10;
			l1[tu]=0;kq=tu/mau;l2.add(kq);
			tu=(tu-kq*mau)*10;
			int dem=1;
			while(tu!=0){
				// System.out.println(tu);
				if(l1[tu]!=-1){
					daXuatHien=true;
				}
				if(daXuatHien)	break;
				else{
					l1[tu]=dem;kq=tu/mau;l2.add(kq);
					dem++;
					tu=(tu-kq*mau)*10;
				}
			}
			// System.out.println(l1[tu]);
			if(daXuatHien){
				for(int j=0;j<l2.size();j++)
					if(j!=l1[tu])	s.append(l2.get(j));
					else		s.append("("+l2.get(j));
				s.append(")");
			}
			else{
				for(int j=0;j<l2.size();j++)
					s.append(l2.get(j));
			}
			String str=s.toString();
			for(int j=0;j<str.length();j++)
				if(j!=0 && j%76==0)
					out.print("\n"+str.charAt(j));
				else
					out.print(str.charAt(j));
			
			out.println();
		}
		
		out.close();
		
		// long fi=System.currentTimeMillis();
		// System.out.println(fi-start);
		
		System.exit(0);
	}
}

/*
if(tu%mau==0)
	out.println(1.0*tu/mau);
else{
	List<Integer> l1=new ArrayList<Integer>();List<Integer> l2=new ArrayList<Integer>();
	int i=-1;
	boolean daXuatHien=false;
	int hash[]=new int[mau];
	int kq=tu/mau;
	StringBuilder s=new StringBuilder();s.append(kq+".");
	tu=(tu-kq*mau)*10;
	l1.add(tu);kq=tu/mau;l2.add(kq);
	tu=(tu-kq*mau)*10;
	while(tu!=0){
		System.out.println(tu);
		for(i=0;i<l1.size();i++)
			if(tu==l1.get(i)){
				daXuatHien=true;break;
			}
		if(daXuatHien)	break;
		else{
			l1.add(tu);kq=tu/mau;l2.add(kq);
			tu=(tu-kq*mau)*10;
		}
	}
	if(daXuatHien){
		for(int j=0;j<l2.size();j++)
			if(j!=i)	s.append(l2.get(j));
			else		s.append("("+l2.get(j));
		s.append(")");
	}
	else{
		for(int j=0;j<l2.size();j++)
			s.append(l2.get(j));
	}
	String str=s.toString();
	for(int j=0;j<str.length();j++)
		if(j!=0 && j%76==0)
			out.print("\n"+str.charAt(j));
		else
			out.print(str.charAt(j));
	
	out.println();
	*/