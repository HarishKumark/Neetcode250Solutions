package com.daily.neetcodeSolns;

import java.util.ArrayList;
import java.util.List;

public class Encode_Decode {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
//        res.add("we");
//        res.add("say");
//        res.add(":");
//        res.add("!@#$%^&*()");
//        res.add("yes");
//
        res.add("Hello");
        res.add("World");


        String encode = new Encode_Decode().encode(res);
        System.out.println(encode);
        List<String> decode = new Encode_Decode().decode(encode);
        System.out.println(decode);

    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append("#").append(s.length()).append("#").append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int temp = i + 1;
            if (str.charAt(i) == '#') {
                //finding the next #
                while (str.charAt(i + 1) != '#') {
                    i++;
                }
                int startingIndex = i + 1;
                String numberInStr = str.substring(temp, startingIndex);
//                System.out.println(numberInStr);
                int lenOfStr = Integer.parseInt(numberInStr);
                String substring = str.substring(startingIndex + 1, startingIndex + lenOfStr + 1);
                res.add(substring);
                i = startingIndex + lenOfStr;
            }
        }
        return res;
    }
}
