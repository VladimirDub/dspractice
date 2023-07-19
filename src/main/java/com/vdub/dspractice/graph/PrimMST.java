package com.vdub.dspractice.graph;

import java.util.Arrays;

public class PrimMST {

	public static int[] primMST(int[][] graph) {
		int size = graph.length;
		int[] parent = new int[size];
		parent[0] = -1;
		boolean[] set = new boolean[size];
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;

			for (int i = 0; i < size; i ++) {
			int min = findMin(dist, set);
			set[min] = true;
			for (int j = 0; j < size; j++) {
				if (graph[min][j] > 0 && !set[j] && dist[j] > graph[min][j]) {
					dist[j] = graph[min][j];
					parent[j] = min;
				}
			}
		}

		return parent;
	}

	//returns an index of the closes vertex
	private static int findMin(int[] dist, boolean[] set) {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < dist.length; i++) {
			if (!set[i] && dist[i] < min) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}
	
}
