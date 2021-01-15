package com.alevel;

import java.util.*;

public class CountCharacter {
    private char[] characters;
    private Map<Character, Integer> map = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public void count(String s){
        characters = s.toCharArray();
        for (char ch:characters) {
            if(map.get(ch) == null) {
                map.put(ch, 1);
            }
            else {
                Integer counter = map.get(ch);
                counter++;
                map.put(ch, counter);
            }
        }
        sort();
        for (String str: result) {
            System.out.println(str);
        }
    }

    private void sort(){
        int[] arr = new int[map.size()];
        int i = 0;
        for (char ch: map.keySet()) {
            arr[i] = map.get(ch);
            i++;
        }
        for(i=0; i<arr.length-1; i++){
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        i = 0;
        for(;i< arr.length; i++) {
            for (char ch : map.keySet()) {
                if (arr[i] == map.get(ch)) {
                    result.add(ch + " = " + arr[i]);
                    map.remove(ch);
                    break;
                }
            }
        }
    }
}
