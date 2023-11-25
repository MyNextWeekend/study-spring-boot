package com.example.studyspringboot;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    @Test
    public void test01() {
        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        Hashtable<String, Integer> hashMap = new Hashtable<>();

        hashMap.put("number", 0);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                Integer number = hashMap.get("number");
                hashMap.put("number", number + 1);
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap);

    }

    @Test
    public void test02() {
        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        Hashtable<String, Integer> hashMap = new Hashtable<>();

        hashMap.put("number", 0);

        Runnable task = () -> {
            synchronized (hashMap) { // 对map进行加锁，读取和写入需要同时进行
                for (int i = 0; i < 1000; i++) {
                    Integer number = hashMap.get("number");
                    hashMap.put("number", number + 1);
                }
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap);

    }


}
