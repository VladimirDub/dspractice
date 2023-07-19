package com.vdub.dspractice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ColoringTest {

	private List<List<Integer>> graph() {
		List<List<Integer>> l = new ArrayList<>();
		l.add(Arrays.asList( 1 , 2, 3 ));
		l.add(Arrays.asList( 0 , 2 ));
		l.add(Arrays.asList( 0, 1, 3 ));
		l.add(Arrays.asList( 0, 2 ));
		return l;
	}

	@Test
	public void successfulColoring() {
		List<List<Integer>> graph = graph();
		Assert.assertTrue(Coloring.color(3, graph, new int[4]));
	}

	@Test
	public void unsuccessfulColoring() {
		List<List<Integer>> graph = graph();
		int[] colors = new int[4];
		
		boolean result = Coloring.color(2, graph, colors);

		System.out.println(Arrays.toString(colors));
		Assert.assertFalse(result);
	}

	@Test
	public void greedy() {
		int n = 3;
		List<Edge> edges = Arrays.asList(
			new Edge(0, 1, 0),
			new Edge(1, 2, 0),
			new Edge(2, 0, 0)	
		);

		int[] colors = Coloring.greedy(n, 3, edges);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) Assert.assertNotEquals(colors[i], colors[j]);
			}
		}
	}
	
}
