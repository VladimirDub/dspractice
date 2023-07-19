package com.vdub.dspractice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DijkstraTest {

	@Test(expected = IndexOutOfBoundsException.class)
	public void emptyAdjacency() {
		Dijkstra.dijkstra(new ArrayList<>(), 0);
	}

	@Test
	public void singleNode() {
		List<List<Pair>> adj = new ArrayList<>();
		adj.add(new ArrayList<>());
		Pair[] result = Dijkstra.dijkstra(adj, 0);
		Assert.assertEquals(0, result[0].getWeight());
	}
	
	@Test
	public void manual() {
		List<List<Pair>> adj = new ArrayList<>();
		adj.add(Arrays.asList(new Pair(1, 1), new Pair(2, 5)));
		adj.add(Arrays.asList(new Pair(2, 1)));
		adj.add(new ArrayList<>());

		Pair[] result = Dijkstra.dijkstra(adj, 0);
		Assert.assertEquals(1, result[1].getWeight());
		Assert.assertEquals(0, result[1].getVertex());
		Assert.assertEquals(2, result[2].getWeight());
		Assert.assertEquals(1, result[2].getVertex());
	}
	
}
