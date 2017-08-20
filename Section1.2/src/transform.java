/*
 ID: htluand1
 TASK: transform
 LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class transform {

	static int N;

	static void printArray(char a[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}

	static char[][] rotate90(char before[][]) {
		char temp[][] = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp[j][N - i - 1] = before[i][j];
			}
		}
		return temp;
	}
	
	static char[][] reflect(char before[][]) {
		char temp[][] = new char[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				temp[i][N - j - 1] = before[i][j];
			}
		}
		return temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"transform.out")));

		N = Integer.parseInt(f.readLine());
		char before[][] = new char[N][N];
		char after[][] = new char[N][N];
		for (int i = 0; i < N; i++)
			before[i] = f.readLine().toCharArray();
		for (int i = 0; i < N; i++)
			after[i] = f.readLine().toCharArray();
		
		
		char r90[][] = rotate90(before);
		char r180[][] = rotate90(r90);
		char r270[][] = rotate90(r180);
		
		// System.out.println(Arrays.deepEquals(before, after));
		
		if(Arrays.deepEquals(after, r90))
			out.println(1);
		else if(Arrays.deepEquals(after, r180))
			out.println(2);
		else if(Arrays.deepEquals(after, r270))
			out.println(3);
		else if(Arrays.deepEquals(after, reflect(before)))
			out.println(4);
		else if(Arrays.deepEquals(after, reflect(r90)) 
				|| Arrays.deepEquals(after, reflect(r180))
				|| Arrays.deepEquals(after, reflect(r270)))
			out.println(5);
		else if(Arrays.deepEquals(before, after))
			out.println(6);
		else
			out.println(7);
			
		
		out.close();
		System.exit(0);
	}

}

/*
 * public static char[][] xoay90Nguoc(char[][] board){ char[][] temp=new
 * char[board.length][board.length]; char[] hang=new char[board.length]; for(int
 * i=0;i<board.length;i++){ for(int j=0;j<board.length;j++){
 * //hang[j]=board[i][j]; temp[board.length-j-1][i]=board[i][j]; } } return
 * temp; }
 * 
 * public static char[][] xoay270(char[][] board){ return xoay90Nguoc(board); }
 * 
 * public static char[][] xoay180(char[][] board){ return
 * xoay90Nguoc(xoay90Nguoc(board)); }
 * 
 * public static char[][] xoay90(char[][] board){ return
 * xoay90Nguoc(xoay180(board)); }
 * 
 * public static char[][] phanChieu(char[][] board){ char[][] temp=new
 * char[board.length][board.length]; for(int i=0;i<board.length;i++){ for(int
 * j=0;j<board.length;j++) temp[i][j]=board[i][board.length-j-1]; } return temp;
 * }
 * 
 * public static char[][] combo14(char[][] board){ return
 * phanChieu(xoay90(board)); }
 * 
 * public static char[][] combo24(char[][] board){ return
 * phanChieu(xoay180(board)); }
 * 
 * public static char[][] combo34(char[][] board){ return
 * phanChieu(xoay270(board)); }
 * 
 * 
 * int length=in.nextInt();
 * 
 * char[][] bandau=new char[length][length]; char[][] saunay=new
 * char[length][length];
 * 
 * for(int i=0;i<length;i++) bandau[i]=in.next().toCharArray();
 * 
 * for(int i=0;i<length;i++) saunay[i]=in.next().toCharArray();
 * 
 * 
 * if(Arrays.deepEquals(saunay, xoay90(bandau))) out.println(1); else
 * if(Arrays.deepEquals(saunay, xoay180(bandau))) out.println(2); else
 * if(Arrays.deepEquals(saunay, xoay270(bandau))) out.println(3); else
 * if(Arrays.deepEquals(saunay, phanChieu(bandau))) out.println(4); else
 * if(Arrays.deepEquals(saunay, combo14(bandau)) || Arrays.deepEquals(saunay,
 * combo24(bandau)) || Arrays.deepEquals(saunay, combo34(bandau)))
 * out.println(5); else if(Arrays.deepEquals(saunay, bandau)) out.println(6);
 * else out.println(7);
 */
