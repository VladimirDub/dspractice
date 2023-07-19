package com.vdub.dspractice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BellmanFordTest {

	@Test
	public void optimized() {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 1));
		edges.add(new Edge(0, 2, 5));
		edges.add(new Edge(1, 2, 1));

		int[] result = BellmanFord.bellmanFordOptimized(3, edges, 0);
		Assert.assertEquals(1, result[1]);
		Assert.assertEquals(2, result[2]);
	}

	@Test
	public void optimizedPositiveCycle() {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 2));
		edges.add(new Edge(0, 3, 4));
		edges.add(new Edge(1, 2, 2));
		edges.add(new Edge(2, 3, 2));
		edges.add(new Edge(3, 1, -3));


		int[] result = BellmanFord.bellmanFordOptimized(4, edges, 0);
		Assert.assertEquals(1, result[1]);
		Assert.assertEquals(3, result[2]);
		Assert.assertEquals(4, result[3]);
	}

	@Test
	public void SPFA() {
		List<List<Pair>> adj = new ArrayList<>();
		adj.add(Arrays.asList(new Pair(1, 1), new Pair(2, 5)));
		adj.add(Arrays.asList(new Pair(2, 1)));
		adj.add(new ArrayList<>());

		int[] result = BellmanFord.SPFA(3, adj, 0);
		Assert.assertEquals(1, result[1]);
		Assert.assertEquals(2, result[2]);
	}

	@Test
	public void SPFAPositiveCycle() {
		List<List<Pair>> adj = new ArrayList<>();
		adj.add(Arrays.asList(new Pair(1, 2), new Pair(3, 4)));
		adj.add(Arrays.asList(new Pair(2, 2)));
		adj.add(Arrays.asList(new Pair(3, 2)));
		adj.add(Arrays.asList(new Pair(1, -3)));

		int[] result = BellmanFord.SPFA(4, adj, 0);
		Assert.assertEquals(1, result[1]);
		Assert.assertEquals(3, result[2]);
		Assert.assertEquals(4, result[3]);
	}

	@Test
	public void KEdges() {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1,100));
		edges.add(new Edge(1, 2, 100));
		edges.add(new Edge(2, 0, 100));
		edges.add(new Edge(1, 3, 600));
		edges.add(new Edge(2, 3, 200)); //important to check that shortest path is ignored due to extra hop

		int result = BellmanFord.bellmanFordKEdges(4, edges, 0, 3, 2);

		Assert.assertEquals(700, result);
	}

	
}
