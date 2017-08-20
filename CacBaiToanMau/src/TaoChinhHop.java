
public class TaoChinhHop {
	
	public static void TaoChinhHop(int[] set,int[] temp,int vitri){
		if(vitri==temp.length){
			for(int i=0;i<temp.length;i++)
				System.out.print(temp[i]);
			System.out.print(" ");
		}
		else{
			for(int i=0;i<set.length;i++){
				temp[vitri]=set[i];
				TaoChinhHop(set,temp,vitri+1);
			}
		}
	}
	
	public static void TaoChinhHop(int k,int[] set){
		int[] temp=new int[k];
		TaoChinhHop(set,temp,0);
	}
	
	public static void TaoChinhHop_DynamicProg(int k,int[] set){
		
	}

	public static void main(String[] args){
		int[] set={2,3,4,7};
		
		// Chinh hop chap 2
		for(int i=0;i<set.length;i++)
			for(int j=0;j<set.length;j++)
				System.out.print(set[i]+""+set[j]+" ");
		System.out.println();
		// Chinh hop chap 3
		for(int i=0;i<set.length;i++)
			for(int j=0;j<set.length;j++)
				for(int k=0;k<set.length;k++)
					System.out.print(set[i]+""+set[j]+""+set[k]+" ");
		
		
		System.out.println();
		// Chinh hop bat ky 
		System.out.println();
		TaoChinhHop(1,set); // Chinh hop chap 1
		System.out.println();
		TaoChinhHop(2,set); // Chinh hop chap 2
		System.out.println();
		TaoChinhHop(3,set); // Chinh hop chap 3
		System.out.println();
		TaoChinhHop(4,set); // Chinh hop chap 4
		
	}
}
