/*
ID: htluand1
TASK: fence9
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


public class fence9 {
	
	// static int xO=0,yO=0;
	static int xA,yA;
	static int xP;
	
	static double OA(int y){
		return (double)xA/yA*y;
	}
	
	static double AP(int y){
		return (double)y*(xA-xP)/yA+xP;
	}
	
	static int lamTronXuong(double y){
		int len=(int) Math.ceil(y);
		int xuong=(int) Math.floor(y);
		if(len-xuong==0)
			return xuong-1;
		else
			return xuong;
	}
	
	static double lamTronLen(double y){
		if(Math.floor(y)==Math.ceil(y))
			return Math.ceil(y)+1.0;
		else
			return Math.ceil(y);
		//vreturn Math.ceil(y)+1.0;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("fence9.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("fence9.out")));
		
		StringTokenizer st=new StringTokenizer(f.readLine());
		xA=Integer.parseInt(st.nextToken());
		yA=Integer.parseInt(st.nextToken());
		xP=Integer.parseInt(st.nextToken());
		
		int max=Math.max(xA, xP);
		int min=Math.min(xA, xP);
		
		int tong=0;
		for(int i=1;i<yA;i++){
			double left=Math.floor(OA(i))+1;
			double right;
			if(xA!=xP)
				right=Math.ceil(AP(i))-1;
			else
				right=xA-1;
			tong+=right-left+1;
			
		}
		
		
		out.println(tong);
		
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
	}

}

/*
if(i<=min){
	tong+=Math.floor(OA(i));
}
else{
	if(min==xA)
		tong+=Math.floor(AP(i));
	else
		tong+=Math.floor(OA(i))-Math.floor(AP(i));
}
*/

/*
if(i<=min){
	for(int j=1;j<OA(i);j++)
		tong++;
	// tong+=lamTronXuong(OA(i));
	// System.out.println(i+" "+lamTronXuong(OA(i))+"(OA)");
}
else {
	if(min==xA){
		for(int j=1;j<OA(i);j++)
			tong++;
		// tong+=lamTronXuong(AP(i));
		// System.out.println(i+" "+lamTronXuong(AP(i))+"(AP)");
	}
	else {
		tong+=(lamTronXuong(OA(i))-lamTronLen(AP(i))+1);
		// System.out.println(i+" "+lamTronXuong(OA(i))+"(OA)"+" "+lamTronLen(AP(i)));
	}
}
*/