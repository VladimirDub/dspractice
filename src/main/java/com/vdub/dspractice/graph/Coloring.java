package com.vdub.dspractice.graph;

import java.util.List;

public class Coloring {

	/** 
	 * @param c - number of colors
	 * @param adj - adjacency list
	 * @param colors - empty array of vertex colors;
	 * @return boolean - indicates whether coloring is possible or not
	 */
	public static boolean color(int c, List<List<Integer>> adj, int[] colors) {
		return color(c, adj, colors, 0);
	}

	
	/** 
	 * @param adj
	 * @param colors
	 * @param v
	 * @return boolean
	 */
	private static boolean color(int c, List<List<Integer>> adj, int[] colors, int v) {
		if (v == adj.size()) return true;
		for (int i = 1; i <= c; i++) {
			if (valid(adj, colors, v, i)) {
				colors[v] = i;
				if (color(c, adj, colors, v + 1)) return true;
				colors[v] = 0;
			}
		}
		return false;
	}

	private static boolean valid(List<List<Integer>> adj, int[] colors, int v, int c) {
		for (int a : adj.get(v)) {
			if (colors[a] == c) return false;
		}
		return true;
	}

	//Can be used when number of colors is equal or less than the maximum vertex degree plus 1
	//Or for fining the upper limit for chromatic number
	public static int[] greedy(int n, int c, List<Edge> edges) {
		int[] result = new int[n];
		boolean stop = false;
		do {
			stop = true;
			for (Edge edge : edges) {
				int u = Math.min(edge.getSrc(), edge.getDst());
				int v = Math.max(edge.getSrc(), edge.getDst());
				if (result[u] == result[v]) {
					stop = false;
					result[v] = (result[u] + 1) % c;
				}
			}
		} while(!stop);
		return result;
	}
	
}
