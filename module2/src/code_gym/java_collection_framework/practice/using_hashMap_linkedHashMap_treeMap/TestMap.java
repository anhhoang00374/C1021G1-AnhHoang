package code_gym.java_collection_framework.practice.using_hashMap_linkedHashMap_treeMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Linh",30);
        hashMap.put("Bao",26);
        hashMap.put("Dung",20);
        hashMap.put("Tuan",30);
        hashMap.put("Hoa",21);
        hashMap.put("Dat",23);

        System.out.println("display hashmap");
        for(Map.Entry entry : hashMap.entrySet()){
            System.out.println(entry.getKey() + " : "+entry.getValue());
        }

        System.out.println("display treeMap");
        Map<String,Integer> treeMap = new TreeMap<>(hashMap);
        for (String key : treeMap.keySet()){
            System.out.println(key +" : " + treeMap.get(key));
        }

        System.out.println("display LinkedHashMap");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Linh", 30);
        linkedHashMap.put("Dung", 31);
        linkedHashMap.put("Hoang", 29);
        linkedHashMap.put("Hang", 29);
        for (String key : linkedHashMap.keySet()){
            System.out.println(key +" : " + linkedHashMap.get(key));
        }

    }
}
