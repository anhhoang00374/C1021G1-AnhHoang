package code_gym.dsa_stack_queue.exercise;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharacter {
    private int id = 4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Character,Integer> treeMap = new TreeMap<Character,Integer>();
        System.out.println("vui long nhập vào chuổi");
        String str = sc.nextLine();

        for(int i = 0;i<str.length();i++){
            char character = str.charAt(i);
                if(treeMap.containsKey(character)){
                    treeMap.put(character,treeMap.get(character)+1);
                }else {
                    treeMap.put(character,1);
                }
            }

        for(Character key : treeMap.keySet()){
            System.out.println(key + ":" + treeMap.get(key));
        }

    }
}
