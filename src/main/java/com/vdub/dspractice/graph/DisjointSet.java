package com.vdub.dspractice.graph;

public class DisjointSet {

	int[] root;
	int[] rank;
	int count;

	DisjointSet(int size) {
		root = new int[size];
		for (int i = 0; i < size; i++) {
			root[i] = i;
		}
		rank = new int[size];
		count = size;
	}

	int find(int x) {
		if (root[x] != x) {
			root[x] = find(root[x]);
		}
		return root[x];
	}

	void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				root[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				root[rootX] = root[rootY];
			} else {
				root[rootY] = rootX;
				rank[rootX] += 1;
			}
			count--;
		}
	}

	int getCount() {
		return count;
	}

}
