package test;

public class Main {
	
	public static String formatBigDecimal(int number) {
        String s= String.valueOf(number);
        String bulder="";
        int i;
        for(i=s.length();i-3>=0;i-=3) {
            bulder="."+s.substring(i-3, i) +bulder;
        }
        if(i==0)
        	return bulder.substring(1);
        bulder= s.substring(0,i)+ bulder;
        return bulder;
    }

	public static void main(String args[]) {
		System.out.println(formatBigDecimal(2300000));
		System.out.println(formatBigDecimal(230000000));
		System.out.println(formatBigDecimal(230000));
	}
}
