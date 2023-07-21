package com.vdub.dspractice;

import org.junit.Assert;
import org.junit.Test;

public class HashMapTest {
	
	@Test
	public void putAndSize() {
		HashMap<String, String> map = new HashMap<>(16, 2);
		
		map.put("a", "1");

		Assert.assertEquals(1, map.size());
	}

	@Test
	public void get() {
		String key = "a";
		String value = "1";
		HashMap<String, String> map = new HashMap<>(16, 2);
		map.put(key, value);

		Assert.assertEquals(value, map.get(key));
	}

	@Test
	public void removeNonExisting() {
		HashMap<String, String> map = new HashMap<>(16, 2);

		Assert.assertFalse(map.remove(""));
	}

	@Test
	public void removeExisting() {
		String key = "a";
		HashMap<String, String> map = new HashMap<>(16, 2);
		map.put(key, "1");

		Assert.assertEquals(1, map.size());
		Assert.assertTrue(map.remove(key));
		Assert.assertNull(map.get(key));
		Assert.assertEquals(0, map.size());
	}

	@Test
	public void update() {
		String key = "a";
		String newV = "123";
		HashMap<String, String> map = new HashMap<>(16, 2);

		map.put(key, "1");
		map.put(key, newV);

		Assert.assertEquals(newV, map.get(key));
	}

	@Test
	public void collision() {
		int size = 10;
		HashMap<String, String> map = new HashMap<>(4, 2);
		for (int i = 0; i < size; i++) {
			map.put(Integer.toString(i), Integer.toString(i));
		}

		for (int i = 0; i < size; i++) {
			String str = Integer.toString(i);
			Assert.assertEquals(str, map.get(str));	
		}
	}

}
