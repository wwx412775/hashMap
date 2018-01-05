package MyHashMap;

import java.util.Map;

public class MyHashMap<V,K> implements MyMap<K, V>{
	
	static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	private int size = 0;
	
	private Node<K,V>[] table;
	
	private MyHashMap() {
		table = new Node[DEFAULT_INITIAL_CAPACITY];

	}

	@Override
	public V put(K key, V value) {
		int index = indexOf(key);
		Node<K, V> element=table[index];
		if (null == element) {
			table[index] = new Node<K,V>(index, key, value, null);
			size ++;
		}else {
			table[index] = new Node<K,V>(index, key, value, element);
		}
		return table[index].getValue();
	}
	
	@Override
	public V get(K key) {
		int index = indexOf(key);
		Node<K, V> element=table[index];
		return  (key == null)? null:element.getValue();
	}
	
	private int indexOf(Object key) {
		return hash(key) % (DEFAULT_INITIAL_CAPACITY-1);
	}
	
	private int hash(Object key) {
		int h = 0;
		return (key == null) ? 0 : (h = key.hashCode())^(h>>>16);
	}

	

	@Override
	public int size() {
		return this.size();
	}
	
	class Node<K,V> implements Entry<K, V>{
		
		final int index;
		final K key;
		V value;
		Node<K,V> next;
		
		public Node(int index, K key, V value, Node<K, V> next) {
			super();
			this.index = index;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public final K getKey()    {return key;}
		public final V getValue()  {return value;}
		
	}

	
	public static void main(String[] args) {
		MyMap<String,String> map=  new MyHashMap<String,String>();
		System.out.println(map.put("hjjhj", "hhjjh"));
		System.out.println(map.get("hjjhj"));
	}
}
