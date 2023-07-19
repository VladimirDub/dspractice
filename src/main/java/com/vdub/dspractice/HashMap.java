package com.vdub.dspractice;

public class HashMap<K, V> {

	private static class Entry<K, V> {
		private K key;
		private V value;
		Entry<K, V> next;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}		

		public void setValue(V value) {
			this.value = value;
		}

		public V getValue() {
			return value;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

		public Entry<K, V> getNext() {
			return next;
		}
	}

	private Entry<K, V>[] table;
	private int capacity;
	private double loadFactor;
	private int size;

	public HashMap(int capacity, double loadFactor) {
		table = new Entry[capacity];
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}

	public void put(K key, V value) {
		int idx = index(key);
		Entry<K, V> entry = table[idx];
 		while (entry != null) {
			if (entry.getKey().equals(key)) {
				entry.setValue(value);
				return;
			}
			entry = entry.getNext();
		}
		Entry<K, V> current = new Entry<>(key, value);
		current.setNext(table[idx]);
		table[idx] = current;
		size++;
		if (size > capacity * loadFactor) resize();
	}

	public V get(K key) {
		int idx = index(key);
		Entry<K, V> entry = table[idx];
		while (entry != null) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
			entry = entry.getNext();
		}
		return null;
	}

	public boolean remove(K key) {
		int idx = index(key);
		Entry<K, V> current = table[idx];
		Entry<K, V> prev = null;
		while (current != null) {
			if (current.getKey() == key) {
				if (prev == null) {
					table[idx] = current.getNext();
				} else {
					prev.setNext(current.getNext());
				}
				size--;
				return true;
			}
			prev = current;
			current = current.getNext();
		}
		return false;
	}

	public int size() {
		return size;
	}

	private int index(K key) {
		int hash = key.hashCode();
		return hash % capacity;
	}

	private void resize() {

	}
	
}
