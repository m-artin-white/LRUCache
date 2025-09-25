import java.util.LinkedHashMap;

public class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    
    public LRUCache(){
        this.capacity = 10;
    }
    
    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        try{
            int value = map.get(key);
            map.remove(key);
            map.putLast(key, value);
            return value;
        }
        catch(NullPointerException e){
            return -1;
        }
    }

    public void put(int key, int val){
        if(map.size() < capacity){
            map.putLast(key, val);
        }else{
            map.pollFirstEntry();
            map.putLast(key, val);
        }
        System.out.println(map);
    }
}
