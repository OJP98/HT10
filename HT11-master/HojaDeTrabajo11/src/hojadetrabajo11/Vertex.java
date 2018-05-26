package hojadetrabajo11;
public class Vertex<K, V> {
    private K key;
    private V value;
    public Vertex(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}