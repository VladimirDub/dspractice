package com.vdub.dspractice.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {


	public static Pair[] dijkstra(List<List<Pair>> adj, int source) {
		int size = adj.size();
		Pair[] result = new Pair[size];
		for (int i = 0; i < size; i++) {
			result[i] = new Pair(i, Integer.MAX_VALUE);
		}

		PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getWeight));
		Pair first = new Pair(source, 0);
		result[source] = first;
		queue.add(first);

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int current = p.getWeight();
			for (Pair a : adj.get(p.getVertex())) {
				if (result[a.getVertex()].getWeight() > a.getWeight() + current) {
					result[a.getVertex()] = new Pair(p.getVertex(), a.getWeight() + current);
					queue.add(new Pair(a.getVertex(), a.getWeight() + current));
				}
			}
		}

		return result;
	}
	
}
