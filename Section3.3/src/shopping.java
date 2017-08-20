/*
 ID: htluand1
 TASK: shopping
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
import java.util.TreeMap;



public class shopping {
	
	
	
	static int s,b,v=100000000;
	static int maHang[],canMua[],giaGoc[];
	
	static TreeMap<Integer,Integer> KhuyenMai=new TreeMap<Integer, Integer>();
	static List<Integer> maKhuyenMai;
	static TreeMap<Integer,Integer> DP=new TreeMap<Integer, Integer>();
	
	static void tao(int keyCode,int doDai){
		if(doDai==b){
			int min=0;
			int temp=keyCode;
			for(int i=0;i<b;i++){
				min+=(temp%10)*giaGoc[b-i-1];
				temp/=10;
			}
			// System.out.print(keyCode+" "+min);
			for(int i=0;i<maKhuyenMai.size();i++){
				min=Math.min(min, ApDung(keyCode,maKhuyenMai.get(i)));
				// System.out.print(" "+ApDung(keyCode,maKhuyenMai.get(i)));
			}
			// System.out.println(" ("+min+")");
			DP.put(keyCode, min);
			// System.out.println();
		}
		else{
			for(int i=0;i<=canMua[doDai];i++){
				tao(keyCode*10+i,doDai+1);
			}
		}
	}
	

	static int ApDung(int keyCode, int kmCode) {
		// TODO Auto-generated method stub
		int tempKey=keyCode,tempKm=kmCode;
		for(int i=0;i<b;i++){
			int key=tempKey%10,km=tempKm%10;
			if(key<km)
				return v;
			tempKey/=10;tempKm/=10;
		}
		// return KhuyenMai.get(kmCode)+DP.get(keyCode);
		if(DP.containsKey(keyCode-kmCode)){
			return KhuyenMai.get(kmCode)+DP.get(keyCode-kmCode);
		}
		else
			return v;
	}


	public static void main(String[] args) throws IOException {
		// long start=System.currentTimeMillis();
		
		// TODO Auto-generated method stub
		BufferedReader f=new BufferedReader(new FileReader("shopping.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
		
		s=Integer.parseInt(f.readLine());
		StringTokenizer ctkm[]=new StringTokenizer[s];
		maKhuyenMai=new ArrayList<Integer>();
		for(int i=0;i<s;i++)
			ctkm[i]=new StringTokenizer(f.readLine());
		
		
		b=Integer.parseInt(f.readLine());
		maHang=new int[b];
		canMua=new int[b];
		giaGoc=new int[b];
		for(int i=0;i<b;i++){
			StringTokenizer st=new StringTokenizer(f.readLine());
			maHang[i]=Integer.parseInt(st.nextToken());
			canMua[i]=Integer.parseInt(st.nextToken());
			giaGoc[i]=Integer.parseInt(st.nextToken());
		}
		/*
		for(int i=0;i<b;i++)
			System.out.println(giaGoc[i]);
		int keyCode=1,temp=keyCode,gia=0;
		for(int i=0;i<b;i++){
			gia+=(temp%10)*giaGoc[b-i-1];
			temp/=10;
		}
		System.out.println(gia);
		*/
		
		for(int i=0;i<s;i++){
			int kmCode=0;
			int n=Integer.parseInt(ctkm[i].nextToken());
			boolean daXuatHien=false;
			for(int j=0;j<n;j++){
				int c=Integer.parseInt(ctkm[i].nextToken());
				int k=Integer.parseInt(ctkm[i].nextToken());
				for(int l=0;l<b;l++){
					if(maHang[l]==c){
						daXuatHien=true;
						kmCode+=k*Math.pow(10, b-l-1);
					}
				}
				if(!daXuatHien)
					break;
			}
			if(daXuatHien){
				// System.out.println(kmCode);
				int p=Integer.parseInt(ctkm[i].nextToken());
				KhuyenMai.put(kmCode, p);
				// System.out.println(KhuyenMai.get(kmCode));
				maKhuyenMai.add(kmCode);
			}
		}
		
		int target=0;
		for(int i=0;i<b;i++)
			target+=canMua[i]*Math.pow(10, b-i-1);
		
		tao(0,0);
		out.println(DP.get(target));
		
		// System.out.println(target);
		
		out.close();
		
		// System.out.println(System.currentTimeMillis()-start);
		
		System.exit(0);
		
		
	}

}
