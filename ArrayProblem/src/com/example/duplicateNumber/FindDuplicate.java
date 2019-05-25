package com.example.duplicateNumber;

import java.util.Arrays;
import java.util.BitSet;

/*
   Given an array of n numbers in which each element is in the range of 1 to (n-1). 
   Find an efficient algorithm that returns the duplicate.
*/

public class FindDuplicate {

	// Name method [t=O(n^2), s=O(1)]
	public static int findDuplicate1(int[] in) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return -1;
	}

	// Adhoc Strategy [t=O(nlogn), s=O(1)]
	public static int findDuplicate2(int[] in) {
		Arrays.sort(in);
		for (int i = 1; i < in.length - 1; ++i) {
			if (in[i - 1] == in[i])
				return in[i];
		}
		return -1;
	}

	// Negation Method [t=O(n), s=O(1)]
	public static int findDuplicate3(int[] in) {
		for (int i = 0; i < in.length; ++i) {
			int element = Math.abs(in[i]); // sometimes i will be negetive
			if (in[element] < 0)
				return element;
			in[element] *= -1;
		}
		return -1;
	}

	// Bit Array Method [t=O(n), s=O(n)]
	public static int findDuplicate4(int[] in) {

		BitSet bset = new BitSet(in.length);

		for (int i = 0; i < in.length; ++i) {
			if (bset.get(in[i]) == true)
				return in[i];
			bset.set(in[i], true);
		}
		return -1;
	}

	// [1,2,3,4,5,5]
	public static int[] test1(int n) {
		int[] in = new int[n];
		int i;
		for (i = 0; i < n - 1; i++) {
			in[i] = i + 1;
		}
		in[i] = i;
		return in;
	}

	// [5,4,3,2,1,5]
	public static int[] test2(int n) {
		int[] in = new int[n];
		int i;
		for (i = 0; i < n - 1; ++i)
			in[i] = n - (i + 1);
		in[i] = i;
		return in;
	}

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int[] in = test1(n);

		long start = System.currentTimeMillis();
		System.out.println(findDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) / 1000.0 + " secs");
	}

}

