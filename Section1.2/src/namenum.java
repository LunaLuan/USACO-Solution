/*
ID: htluand1
TASK: namenum
LANG: JAVA
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class namenum {
	
	static char board[][] = {
		{},
		{},
		{'A', 'C'}, // 2
		{'D', 'F'}, // 3
		{'G', 'I'}, // 4
		{'J', 'L'}, // 5
		{'M', 'O'}, // 6
		{'P', 'S'}, // 7
		{'T', 'V'}, // 8
		{'W', 'Y'}  // 9
 	};

	public static void main(String[] args) throws IOException {
		File dictionary = new File("dict.txt");
		Scanner dict = new Scanner(dictionary);
		Scanner in = new Scanner(new File("namenum.in"));
		PrintWriter out = new PrintWriter(new File("namenum.out"));
		
		ArrayList<String> result = new ArrayList<String>();
		
		String number = in.nextLine();
		while(dict.hasNext()) {
			String name = dict.nextLine();
			
			if(number.length() != name.length())
				continue;
			else {
				boolean choose = true;
				for(int i = 0; i < number.length(); i++) {
					int index = number.charAt(i) - '0';
					if(name.charAt(i) >= board[index][0] 
							&& name.charAt(i) <= board[index][1])
						continue;
					else {
						choose = false;
						break;
					}
				}
				if(choose)
					result.add(name);
			}
		}
		
		if(result.size() == 0)
			out.println("NONE");
		else {
			for(String s: result)
				out.println(s);
		}
		

		out.close();
		System.exit(0);

	}
}

/*
 * static char[][] board={ {}, {}, {'A','B','C'}, {'D','E','F'}, {'G','H','I'},
 * {'J','K','L'}, {'M','N','O'}, {'P','R','S'}, {'T','U','V'}, {'W','X','Y'} };
 * 
 * 
 * public static boolean laTrongKhoang(char a,char b,char c){ if(b>=a && b<=c)
 * return true; return false; }
 * 
 * public static void main(String[] args) throws IOException{ File
 * dictionary=new File("dict.txt"); Scanner dict=new Scanner(dictionary);
 * Scanner in =new Scanner(new File("namenum.in")); PrintWriter out=new
 * PrintWriter(new File("namenum.out"));
 * 
 * String number=in.next(); LinkedList<String> list=new LinkedList<String>();
 * 
 * //System.out.println(+6);
 * 
 * for(int i=0;i<5000;i++){
 * 
 * if(dict.hasNextLine()){
 * 
 * String ten=dict.nextLine();
 * 
 * if(ten.length()==number.length()){ boolean chon=true;
 * 
 * for(int k=0;k<number.length();k++){
 * if(!laTrongKhoang(board[number.charAt(k)-'0'][0],
 * ten.charAt(k),board[number.charAt(k)-'0'][2])){ chon=false; break; } }
 * if(chon) list.add(ten); } } else break;
 * 
 * } if(list.isEmpty()) out.println("NONE"); else for(int i=0;i<list.size();i++)
 * out.println(list.get(i));
 * 
 * out.close(); System.exit(0);
 * 
 * }
 */