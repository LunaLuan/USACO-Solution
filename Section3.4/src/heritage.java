/*
ID: htluand1
TASK: heritage
LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class heritage {
	
	static char key[];
	static int kytu[];
	
	static class Node {
		int key;
		Node left,right,parent;
		
		Node(int k){
			key=k;left=null;right=null;parent=null;
		}
	}
	
	static Node root;
	static String kq="";
	
	static void insert(int key){
		if(root==null){
			root=new Node(key);
			return;
		}
		Node cuNode=root,cuParent = null;
		while(cuNode!=null){
			if(key<cuNode.key){
				cuParent=cuNode;
				cuNode=cuNode.left;
			
			}
			else{
				cuParent=cuNode;
				cuNode=cuNode.right;
			}
		}
		cuNode=new Node(key);
		cuNode.parent=cuParent;
		if(cuParent.key>key)
			cuParent.left=cuNode;
		else
			cuParent.right=cuNode;
	}
	
	
	static void LRN(Node current){
		if(current!=null){
			LRN(current.left);
			LRN(current.right);
			kq+=key[current.key];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// long s=System.currentTimeMillis();
		
		BufferedReader f=new BufferedReader(new FileReader("heritage.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("heritage.out")));
		
		String in=f.readLine();
		
		key=new char[in.length()+1];
		kytu=new int[26];
		
		for(int i=0;i<in.length();i++){
			key[i+1]=in.charAt(i);
			kytu[in.charAt(i)-'A']=i+1;
			// System.out.println(key[i+1]+" "+kytu[in.charAt(i)-'A']);
		}
		root=null;
		in=f.readLine();
		for(int i=0;i<in.length();i++){
			insert(kytu[in.charAt(i)-'A']);
			// System.out.println(kytu[in.charAt(i)-'A']);
		}
		
		LRN(root);
		out.println(kq);
		
		out.close();
		
		// System.out.println(System.currentTimeMillis()-s);
		
		System.exit(0);
		
		
	}

}
