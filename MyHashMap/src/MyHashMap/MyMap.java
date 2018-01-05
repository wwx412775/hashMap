package MyHashMap;

public interface MyMap<K,V> {
	
	V put(K key, V value);
	
	V get(K key);
	
	int size();
	
	interface Entry<K,V>{
		K getKey();
		
		V getValue();
	}
}
