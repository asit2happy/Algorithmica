package SetMapProblem;

import java.util.Arrays;

public class Anagrams {

	public static boolean anagrams1(String s1, String s2) {
		if(s1.length()!=s2.length()) return false;
		char[] ch1=s1.toCharArray();
		char[] ch2=s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		for(int i=0;i<ch1.length;i++) {
			if(ch1[i]!=ch2[i])
				return false;	
		}
		return true;
	}
	
	public static boolean anagrams2(String s1,String s2) {
		int[] aux=new int[26];
		for(int i=0; i<s1.length(); i++) {
			++aux[s1.charAt(i)-'a'];
		}
		for(int i=0;i<s2.length();i++) {
			int index = aux[s2.charAt(i)]-'a';
			if(index==0)
				return false;
			--aux[index];
		}
		return true;
	}
	
	public static void main(String[] args) {
		

	}

}
