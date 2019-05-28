package SetMapProblem;

import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

	public static boolean anagrams1(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i])
				return false;
		}
		return true;
	}

	public static boolean anagrams2(String s1, String s2) {
		int[] aux = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			++aux[s1.charAt(i) - 'a'];
		}
		for (int i = 0; i < s2.length(); i++) {
			int index = aux[s2.charAt(i)] - 'a';
			if (index == 0)
				return false;
			--aux[index];
		}
		return true;
	}

	public static boolean anagram3(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); ++i) {
			if (! hm.containsKey(s1.charAt(i))) {
				hm.put(s1.charAt(i), 1);
			} else {
				int temp = hm.get(s1.charAt(i));
				hm.put(s1.charAt(i), ++temp);
			}
		}
		for (int i = 0; i < s2.length(); ++i) {
			if (! hm.containsKey(s2.charAt(i)))
				return false;
			int tmp = hm.get(s2.charAt(i));
			if (tmp == 1)
				hm.remove(s1.charAt(i));
			else
				hm.put(s1.charAt(i), --tmp);
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
