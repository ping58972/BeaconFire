/*
 * Author: Ping Nalongsone Danddank.
 * email: ndanddank@gmail.com
 * Question 3. Design and implement your own generic HashMap which should support linked list structure
(cannot use LinkedList from Java Collections, must implement your own linked list) for each
slot in the bucket. Please at least implement put() and get() method.
 * */
import java.util.Arrays;

public class MyHashMap <K, V>{
    // private class for Linked Nodes of key and value.
    private class Node<K, V>{
        K key; V value; Node<K, V> next;
        Node(K key, V value){
            this.key = key; this.value = value;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    private final Node<K, V>[] keyArray; // array of node that store node linked list.
    private final int capacity;// initilize size for array for storing keys.
    public MyHashMap(int capacity){
        keyArray = new Node[capacity];
        this.capacity = capacity;
    }
    // get value from the map by key, if the key not exited just  return null.
    // @params: key - K, generic class, must be exited inside the map otherwise return null.
    // @return V - the value by key or null if  key not exited.
    public V get(K key){
        if(isEmpty()){
            return null;
        }
        int index = key.hashCode()%capacity;//insert
        Node<K, V> node = keyArray[index];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    // put value to the map by key, if the key exited just replace to new value and return previous value.
    // and if key not exit yet just insert the new key and value follow by hash function.
    // @params: key - K, generic class, must be unique inside the map.
    //          value - V, generic class, store beside with key.
    // @return V - the previous value or null if it is new key.
    public V put(K key, V value){
        int index = key.hashCode()%capacity;
        Node<K, V> node = keyArray[index];
        if (node == null){
            keyArray[index] = new Node<>(key, value);
            return null;
        }
        Node<K, V> last = node;
        while(node != null){
            if(node.key.equals(key)){
                V temp = node.value;
                node.value = value;
                return temp;
            }
            last = node;
            node = node.next;
        }
        last.next = new Node<>(key, value);
        return null;
    }
    // remove an element by key and return its value, if the key not exited return null.
    // @params: key - K, generic class.
    // @return V - the value or null if it is new key.
    public V remove(K key){
        if( isEmpty()){
            return null;
        }
        int index = key.hashCode()%capacity;
        Node<K, V> node = keyArray[index];
        Node<K, V> currentNode = node;
        Node<K, V> prevNode = null;
        if(currentNode != null && currentNode.key.equals(key)) {
            V temp = currentNode.value;
            keyArray[index] = currentNode.next;
            return temp;
        }
        while(currentNode != null && !currentNode.key.equals(key)){
                prevNode = currentNode;
                currentNode = currentNode.next;
        }
        if(currentNode == null) return null;
        V v = currentNode.value;
        prevNode.next = currentNode.next;
        return v;
    }
    public boolean isEmpty(){
        for(Node<K, V> node : keyArray){
            if(node != null) return false;
        }
        return true;
    }
    public boolean containsValue(V value){
        if( isEmpty()){
            return false;
        }
        for(Node<K, V> node : keyArray){
            while(node != null){
                if(node.value.equals(value))
                    return true;
                node = node.next;
            }
        }
        return false;
    }
    public boolean containsKey(K key){
        if( isEmpty()){
            return false;
        }
        int index = key.hashCode()%capacity;
        Node<K, V> node = keyArray[index];
        while(node != null){
            if(node.key.equals(key))
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "keyArray=" + Arrays.toString(keyArray) +
                ", capacity=" + capacity +
                '}';
    }
    // testing MyHashMap class.
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>(10);
        myHashMap.put("key", "value");
        myHashMap.put("key1", "value1");
        myHashMap.put("key2", "value2");
        myHashMap.put("key3", "value3");
        myHashMap.put("key3", "value33");
        myHashMap.put("key4", "value4");
        myHashMap.put("key5", "value5");
        myHashMap.put("key6", "value6");
        myHashMap.put("key7", "value7");
        myHashMap.put("key8", "value8");
        myHashMap.put("key9", "value9");
        myHashMap.put("key10", "value10");
        myHashMap.put("key11", "value11");
        myHashMap.put("key12", "value12");
        String value = myHashMap.get("key7");
        System.out.println(value);
        System.out.println(myHashMap.containsKey("key1"));
        System.out.println(myHashMap.containsKey("key5"));
        System.out.println(myHashMap.containsValue("value"));
        System.out.println(myHashMap.containsValue("value56"));

        System.out.println(myHashMap);
        System.out.println("after remove 'key3': ");
        String v = myHashMap.remove("key3");
        System.out.println(v);
        System.out.println(myHashMap);
        System.out.println("after remove 'key10': ");
        String vv = myHashMap.remove("key10");
        System.out.println(vv);
        System.out.println(myHashMap);
        System.out.println(myHashMap.containsKey("key9"));

    }

}
