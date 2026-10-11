package com.daily.leetcodeSolns;

public class RecordEx {
    public static void main(String[] args) {
        Customer testUser = new Customer("testUser", 20);
        System.out.println(testUser);
        System.out.println(testUser.name() + " :::: " + testUser.age());
    }
}
