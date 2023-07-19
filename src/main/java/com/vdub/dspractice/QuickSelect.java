package com.vdub.dspractice;

import java.util.Random;

public class QuickSelect {

	private static Random rnd = new Random();
	
	public static int quickSelect(int[] ar, int pos) {
		int l = 0;
		int r = ar.length - 1;
		while (l < r) {
			int x = partition(ar, l, r);
			if (x == pos) return ar[x];
			if (x < pos ) {
				l = x + 1;
			} else {
				r = x - 1;
			}
		}
		return ar[l];
	}

	static int partition(int ar[], int start, int end) {
		swap(ar, start + rnd.nextInt(end - start), end);
		int piv = ar[end];
		int x = start;
		for (int i = start; i < end; i++) {
			if (ar[i] < piv) {
				swap(ar, i, x);
				x++;
			}
		}
		swap(ar, x, end);
		return x;
	}

	static void swap(int[] ar, int x, int y) {
		int tmp = ar[x];
		ar[x] = ar[y];
		ar[y] = tmp;
	}

}
