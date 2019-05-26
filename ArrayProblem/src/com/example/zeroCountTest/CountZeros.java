package com.example.zeroCountTest;

import java.util.Random;

/*
Given an array of integers which consists of zeros followed by non-zeros entries.
Find an efficient algorithm that return no of zeros.
*/

public class CountZeros {

	// Name Method (t=O(n), space=O(1))
	public static int countZeros1(int[] in) {
		int i;
		for (i = 0; i < in.length; ++i) {
			if (in[i] != 0)
				break;
		}
		return i + 1;
	}

	// Divide and prune (t=O(logn), space=O(1))
	public static int countZeros2(int[] in) {
		int l = 0, r = in.length - 1;
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (in[m] == 0)
				l = m;
			else
				r = m - 1;
		}
		if (in[r] == 0)
			return r + 1;
		else
			return l + 1;
	}

	public static int[] testcase1(int n) {
		int[] in = new int[n];
		Random r = new Random(100);
		for (int i = n / 3; i < n; ++i)
			in[i] = r.nextInt(100) + 1;
		return in;
	}

	public static int[] testcase2(int n) {
		return new int[n];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = testcase2(n);
		// System.out.println(Arrays.toString(in));
		System.out.println(countZeros1(in));
		System.out.println(countZeros2(in));
	}

}
