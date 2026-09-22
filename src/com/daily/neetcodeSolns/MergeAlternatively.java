package com.daily.neetcodeSolns;

public class MergeAlternatively {
    public static void main(String[] args) {
        String s = new MergeAlternatively().mergeAlternately("abcd", "pq");
        System.out.println(s);
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        if (word1.length() < word2.length()) {
            int i = 0;
            for (; i < word1.length(); i++) {
                    sb.append(word1.charAt(i)).append(word2.charAt(i));
            }
            sb.append(word2.substring(i, word2.length()));
        } else {
            int i = 0;
            for (; i < word2.length(); i++) {
                    sb.append(word1.charAt(i)).append(word2.charAt(i));
            }
            sb.append(word1.substring(i, word1.length()));

        }

        return sb.toString();
    }
}
