package DeQuy;

public class TowerOfHaNoi {
	
	public static void move(int sodia,char start,char mid,char finish){
		if(sodia==1){
			System.out.println("Chuyen dia 1 tu "+start+" sang "+finish);
		}
		else{
			move(sodia-1,start,finish,mid);
			System.out.println("Chuyen dia "+sodia+" tu "+start+" sang "+finish);
			move(sodia-1,mid,start,finish);
		}
	}
	
	public static void main(String[] args){
		move(10,'C','A','B');
	}
	
}
