/*
 ID: htluand1
 TASK: gift1
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
import java.util.Scanner;
import java.util.StringTokenizer;

public class gift1 {

	static int findIndex(String list[], String name) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));

		int NP = Integer.parseInt(f.readLine());

		String listName[] = new String[NP];
		int initial_money_value[] = new int[NP];
		int final_money_value[] = new int[NP];

		for (int i = 0; i < NP; i++) {
			listName[i] = f.readLine();
		}

		for (int i = 0; i < NP; i++) {
			int index = findIndex(listName, f.readLine());
			String s = f.readLine();
			StringTokenizer st = new StringTokenizer(s);

			initial_money_value[index] = Integer.parseInt(st.nextToken());
			int coutFriends = Integer.parseInt(st.nextToken());
			

			if(coutFriends==0){
				final_money_value[index]+=initial_money_value[index];
				continue;
			}
			
			final_money_value[index] += initial_money_value[index]
					% coutFriends;
			for (int j = 0; j < coutFriends; j++) {
				int indexFriend = findIndex(listName, f.readLine());
				final_money_value[indexFriend] += initial_money_value[index]
						/ coutFriends;
			}
			
		}
		
		for(int i=0;i<NP;i++) {
			// System.out.println(listName[i]+" "+ (final_money_value[i]- initial_money_value[i]));
			out.println(listName[i]+" "+ (final_money_value[i]- initial_money_value[i]));
		}
		out.close();
		System.exit(0);
	}
	
}

/*
 * Scanner in=new Scanner(new File("gift1.in")); PrintWriter out=new
 * PrintWriter(new File("gift1.out"));
 * 
 * String[] set=new String[in.nextInt()]; int[] bandau=new int[set.length];
 * int[] conlai=new int[set.length];
 * 
 * //in.next(); for(int i=0;i<set.length;i++) set[i]=in.next();
 * 
 * for(int i=0;i<set.length;i++){ int k; String person=in.next(); int
 * money=in.nextInt(); for(k=0;k<set.length;k++) if(set[k].matches(person))
 * break; bandau[k]=money; //System.out.println(k); int chia=in.nextInt();
 * if(chia!=0){ conlai[k]+=bandau[k]%chia;
 * 
 * for(int m=0;m<chia;m++){ String friend=in.next(); int l;
 * for(l=0;l<set.length;l++) if(set[l].matches(friend)) break;
 * conlai[l]+=bandau[k]/chia; }
 * 
 * } }
 * 
 * for(int i=0;i<set.length;i++) out.println(set[i]+" "+(conlai[i]-bandau[i]));
 * 
 * out.close(); System.exit(0);
 */
