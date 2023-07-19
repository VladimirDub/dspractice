package com.vdub.dspractice.graph;

import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {
	
	@Test
	public void noUnion() {
		DisjointSet set = new DisjointSet(5);
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(i, set.find(i));
		}
	}

	@Test
	public void singleUnion() {
		int size = 3;
		DisjointSet set = new DisjointSet(size);
		
		set.union(0, 2);
		
		Assert.assertEquals(set.find(0), set.find(2));
		Assert.assertEquals(1, set.find(1));
	}

	@Test
	public void allUnion() {
		int size = 5;
		DisjointSet set = new DisjointSet(size);
		
		for (int i = 0; i < size - 1; i++) {
			set.union(i, i + 1);
		}

		int parent = set.find(0);
		for (int i = 1; i < size; i++) {
			Assert.assertEquals(parent, set.find(i));
		}
	}

	@Test
	public void graphsCount() {
		int size = 5;
		DisjointSet set = new DisjointSet(size);

		Assert.assertEquals(5, set.getCount());
		set.union(0, 1);
		Assert.assertEquals(4, set.getCount());
		set.union(2, 3);
		Assert.assertEquals(3, set.getCount());
		set.union(0, 2);
		Assert.assertEquals(2, set.getCount());
		set.union(1, 2);
		Assert.assertEquals(2, set.getCount());
	}

}
