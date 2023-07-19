package com.vdub.dspractice.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BellmanFord {

	private static int INFINITY = Integer.MAX_VALUE / 2;

	/** 
	 * @param n - number of vertices
	 * @param edges - list of directed edges
	 * @param src - source vertex
	 * @return int[] - distance to vertices
	 */
	public static int[] bellmanFordOptimized(int n, List<Edge> edges, int src) {
		int[] result = new int[n];
		Arrays.fill(result, INFINITY);
		result[src] = 0;
		for (int i = 0; i < n -1; i++) {
			for (Edge edge : edges) {
				result[edge.getDst()] = Math.min(result[edge.getDst()], result[edge.getSrc()] + edge.getWeight());
			}
		}
		return result;
	}

	/** 
	 * @paran n - number of vertices
	 * @param adj - adjacency list
	 * @param src - source vertex
	 * @return int[] - distance to vertices
	 */
	public static int[] SPFA(int n, List<List<Pair>> adj, int src) {
		int[] result = new int[n];
		Queue<Integer> queue = new LinkedList<>();
		boolean[] marked = new boolean[n];
		Arrays.fill(result, INFINITY);
		result[src] = 0;
		queue.add(src);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			marked[v] = false;
			for (Pair p : adj.get(v)) {
				if (result[p.getVertex()] > result[v] + p.getWeight()) {
					result[p.getVertex()] = result[v] + p.getWeight();
					if (!marked[p.getVertex()]) {
						marked[p.getVertex()] = true;
						queue.add(p.getVertex());
					}
				}
			}
		}
		return result;
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
		int[] prev;
		int[] current = new int[n];
		Arrays.fill(current, INFINITY);
		current[src] = 0;
		for (int i = 0; i < k; i++) {
			prev = current.clone();
			for (Edge edge : edges) {
				current[edge.getDst()] = Math.min(current[edge.getDst()], prev[edge.getSrc()] + edge.getWeight());
			}
		}
		return current[dst] == INFINITY ? -1 : current[dst];
	}
	
}
