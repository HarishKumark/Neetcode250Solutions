package com.daily.neetcodeSolns;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> columCheck = new HashSet<>();
            Set<Character> rowCheck = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (rowCheck.contains(board[i][j])) {
                        return false;
                    }
                    rowCheck.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (columCheck.contains(board[j][i])) {
                        return false;
                    }
                    rowCheck.add(board[j][i]);
                }

                if (i % 3 == 0 && j % 3 == 0) {
                    Set<Character> matrixCheck = new HashSet<>();
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (board[k][l] != '.') {
                                if (matrixCheck.contains(board[k][l])) {
                                    return false;
                                }
                                matrixCheck.add(board[k][l]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}
