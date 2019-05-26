package SetMapProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/*
Given an unsorted array of integers and sum s.Find an efficient algorithm that 
determines whether the existing pair where sum is S.
*/

public class TwoSum {

	// Name Method, t=O(n2), S=O(1)
	public static boolean twoSum1(int[] in, int s) {
		for (int i = 0; i < in.length; i++) {
			for (int j = i + 1; j < in.length; j++) {
				if (s - in[i] == in[j])
					return true;
			}
		}
		return false;
	}

	// Adhoc Strategy, t=O(nlogn), S=O(1)
	public static boolean twoSum2(int[] in, int s) {
		Arrays.sort(in);
		for (int i = 0; i < in.length; i++) {
			if (Arrays.binarySearch(in, i + 1, in.length, s - in[i]) >= 0)
				return true;
		}
		return false;
	}

	// Adhoc Strategy, t=O(nlogn), S=O(1)
	public static boolean twoSum3(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if (hset.contains(s - in[i]))
				return true;
			else
				hset.add(in[i]);
		}
		return false;
	}

	public static int[] testcase1(int n) {
		int[] in = new int[n];
		Random r = new Random(100);
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n);
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = testcase1(n);
		// System.out.println(Arrays.toString(in));
		int s = Integer.MAX_VALUE;
		// System.out.println(s);
		long start = System.currentTimeMillis();
		System.out.println(twoSum3(in, s));
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) / 1000.0 + " secs");

	}

}
