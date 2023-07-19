package com.vdub.dspractice;

public class MinHeap {

	private int[] ar;
	private int size = 0;;
	private int capacity;

	MinHeap(int capacity) {
		ar = new int[capacity];
		ar[0] = Integer.MIN_VALUE;
		this.capacity = capacity;
	}

	MinHeap(int capacity, int[] init) {
		ar = new int[init.length == capacity ? capacity + 1 : capacity];
		ar[0] = Integer.MIN_VALUE;
		for (int i = 0; i < init.length; i++) {
			ar[i + 1] = init[i];
		}
		this.capacity = capacity;
		size = init.length;
		for (int i = init.length / 2 + 1; i > 0; i--) {
			heapify(i);
		}
	}

	public boolean add(int x) {
		if (size >= capacity) return false;
		ar[++size] = x;
		int current = size;
		while (ar[current >> 1] > x) {
			swap(current >> 1, current);
			current = current >> 1;
		}
		return true;
	}

	public int poll() {
		int res = ar[1];
		ar[1] = ar[size--];
		heapify(1);
		return res;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void heapify(int i) {
		int l = i << 1;
		int r = (i << 1) + 1;
		int min = i;
		if (l <= size && ar[l] < ar[min]) min = l;
		if (r <= size && ar[r] < ar[min]) min = r;
		if (min != i) {
			swap(min, i);
			heapify(min);
		}
	}

	private void swap(int x, int y) {
		int tmp = ar[x];
		ar[x] = ar[y];
		ar[y] = tmp;
	}
	
}
