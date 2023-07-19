package com.vdub.dspractice.graph;

import java.util.List;

public class BellmanFord {

	private static int INFINITY = Integer.MAX_VALUE / 2;

	/** 
	 * @param n - number of vertices
	 * @param edges - list of directed edges
	 * @param src - source vertex
	 * @return int[] - distance to vertices
	 */
	public static int[] bellmanFordOptimized(int n, List<Edge> edges, int src) {
		return new int[0];
	}

	/** 
	 * @paran n - number of vertices
	 * @param adj - adjacency list
	 * @param src - source vertex
	 * @return int[] - distance to vertices
	 */
	public static int[] SPFA(int n, List<List<Pair>> adj, int src) {
		return new int[0];
	}

	/** 
	 * Shortest past to destincation within K edges
	 * @param n - number of vertices
	 * @param edges - edges
	 * @param src - source vertex
	 * @param dst - destination vertex
	 * @param k - max number of edges
	 * @return int - -1 if not found
	 */
	public static int bellmanFordKEdges(int n, List<Edge> edges, int src, int dst, int k) {
		return 0;
	}
	
}
