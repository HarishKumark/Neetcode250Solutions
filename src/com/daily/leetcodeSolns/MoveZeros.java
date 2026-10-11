package com.daily.leetcodeSolns;

public class MoveZeros {

    public static void main(String[] args) {

        MoveZeros moveZeros = new MoveZeros();
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeros.moveZeros(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void moveZeros(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        for (int i = count; i < arr.length; i++) {
            arr[i] = 0;
        }

    }
}
