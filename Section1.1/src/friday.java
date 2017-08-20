/*
 ID: htluand1
 LANG: JAVA
 PROB: friday
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class friday {
	
	static int[] soNgayTrongThang={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int soNgayTrongThangNhuan[]={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	static boolean laNamNhuan(int nam) {
		if(nam%100==0) {
			if(nam%400==0)
				return true;
			else
				return false;
		}
		if(nam%4==0)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("friday.in"));
		PrintWriter out=new 
				PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		
		int N=Integer.parseInt(f.readLine());
		int thu[]=new int[9];
		
		int ngayDauThang=2;
		for(int i=0;i<N;i++) {
			boolean laNamNhuan= laNamNhuan(1900+i);
			for(int j=0;j<12;j++) {
				int ngay13= ngayDauThang-2;
				if(ngay13<2)
					ngay13= ngay13+7;
				thu[ngay13]++;
				
				int soNgayTrongThangJ;
				if(j==1) {
					if(laNamNhuan)
						soNgayTrongThangJ=29;
					else
						soNgayTrongThangJ=28;
				}
				else {
					soNgayTrongThangJ=soNgayTrongThang[j];
					
				}
				int soNgayLech= soNgayTrongThangJ % 7;
				ngayDauThang+=soNgayLech;
				if(ngayDauThang>8) {
					ngayDauThang=ngayDauThang-7;
				}
				
			}
		}
		
		out.println(thu[7]+" "+thu[8]+" "+thu[2]+" "+
					thu[3]+" "+thu[4]+" "+thu[5]+" "+thu[6]);
		out.close();
		System.exit(0);
	}

}

/*
static class Date {
	int ngay;
	int thang;
	int nam;
	
	int thu;
	
	final int[] max_ngay_trong_thang={0,31,0,31,30,31,30,31,31,30,31,30,31};
	
	public Date(int th,int n,int t,int na){
		thu=th;ngay=n;thang=t;nam=na;
	}
	
	public boolean laNhuan(){
		if(nam%100==0){
			if(nam%400==0)
				return true;
		}
		else if(nam%4==0)
			return true;
		return false;
	}
	
	public void tangNgay(){
		tangThu();
		// Thang 2
		if(thang==2){
			if(laNhuan()){
				if(ngay==29){
					ngay=1;thang=3;
					return;
				}
			}
			else if(ngay==28){
				ngay=1;thang=3;
				return;
			}
			ngay++;
		}
		// Cac thang khac
		else{
			if(ngay==max_ngay_trong_thang[thang]){
				if(thang==12){
					ngay=1;thang=1;nam++;
					return;
				}
				else {
					ngay=1;thang++;
					return;
				}
			}
			ngay++;
		}
		//
		
	}
	
	public void tangThu(){
		if(thu==8)
			thu=2;
		else
			thu++;
	}
}
*/

/*
int n=in.nextInt();
int[] thu=new int[9];

Date time=new Date(2,1,1,1900);

while(true){
	//System.out.println(time.ngay+"\t"+time.thang+"\t"+time.nam);
	if(time.ngay==13)
		thu[time.thu]++;
	time.tangNgay();
	if(time.ngay==14 && time.thang==12 && time.nam==1900+n-1)
		break;
}

out.print(thu[7]);
out.print(' ');
out.print(thu[8]);
out.print(' ');
out.print(thu[2]);
out.print(' ');
out.print(thu[3]);
out.print(' ');
out.print(thu[4]);
out.print(' ');
out.print(thu[5]);
out.print(' ');
out.print(thu[6]);
*/