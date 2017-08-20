/*
 ID: htluand1
 TASK: friday
 LANG: JAVA
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class friday2 {
	
	static final int[] max_ngay_nam_thuong=	{0,31,28,31,30,31,30,31,31,30,31,30,31};
	static final int[] max_ngay_nam_nhuan=	{0,31,29,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) throws IOException{
		Scanner in=new Scanner(new File("friday.in"));
		PrintWriter out=new PrintWriter(new File("friday.out"));
		
		int thu=2;
		int[] save=new int[9];
		
		int n=in.nextInt();
		
		for(int nam=1900;nam<=1900+n-1;nam++){
			for(int thang=1;thang<=12;thang++){
				int lui2=lui2ngay(thu);
				save[lui2]++;
				thu=sangDauThangSau(thu,thang,laNhuan(nam));
				//System.out.println(thang+"\t"+thu+"\t"+lui2);
			}
		}
		
		out.print(save[7]);
		out.print(' ');
		out.print(save[8]);
		out.print(' ');
		out.print(save[2]);
		out.print(' ');
		out.print(save[3]);
		out.print(' ');
		out.print(save[4]);
		out.print(' ');
		out.print(save[5]);
		out.print(' ');
		out.print(save[6]);
		out.println();
		out.close();
		
		System.exit(0);
	}

	private static int sangDauThangSau(int thu, int thang, boolean laNhuan) {
		if(laNhuan){
			int t=(thu+(max_ngay_nam_nhuan[thang]%7));
			if(t>8)
				t-=7;
			return t;
		}
		else{
			int t=(thu+(max_ngay_nam_thuong[thang]%7));
			//System.out.println(t);
			if(t>8)
				t-=7;
			return t;
		}
			
	}

	private static boolean laNhuan(int nam) {
		// TODO Auto-generated method stub
		if(nam%100==0){
			if(nam%400==0)
				return true;
			else
				return false;
		}
		if(nam%4==0)
			return true;
		
		return false;
	}

	private static int lui2ngay(int thu) {
		// TODO Auto-generated method stub
		if(thu==2)
			return 7;
		else if(thu==3)
			return 8;
		else
			return thu-2;
	}
}
