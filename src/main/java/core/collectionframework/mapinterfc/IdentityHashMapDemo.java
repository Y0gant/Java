package core.collectionframework.mapinterfc;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        String key1 = "Key";
        String key2 = "Key";
        System.out.println("Identity hashcode of key1 :" + System.identityHashCode(key1));
        System.out.println("Identity hashcode of key2 :" + System.identityHashCode(key2));
        System.out.println("Hashcode of the key1 from string class :" + key1.hashCode());
        System.out.println("Hashcode of the key2 from string class :" + key2.hashCode());
        Map<String, Integer> map = new IdentityHashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println("Size of map =" + map.size());
        System.out.println(map);
    }
}
