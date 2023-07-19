package com.vdub.dspractice.graph;

import org.junit.Assert;
import org.junit.Test;

public class PrimMSTTest {
	
	@Test
	public void list() {
		int[][] graph = {
			{0, 1, 0, 0},
			{1, 0, 1, 0},
			{0, 1, 0, 1},
			{0, 0, 1, 0}
		};
		
		int[] mst = PrimMST.primMST(graph);
		
		for (int i = 1; i < graph.length; i++) {
			Assert.assertEquals(i - 1, mst[i]);
		}
	}

	@Test
	public void manual() {
		int[][] graph = {
			{0, 1, 0, 5},
			{1, 0, 1, 3},
			{0, 1, 0, 1},
			{5, 3, 1, 0}
		};

		int[] mst = PrimMST.primMST(graph);
		
		for (int i = 1; i < graph.length; i++) {
			Assert.assertEquals(i - 1, mst[i]);
		}
	}

}
