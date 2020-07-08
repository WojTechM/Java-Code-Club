package com.github.wojtechm.ox;

import java.util.Arrays;

class Board {

    private final char[] chars;

    Board(int width, int height) {
        chars = new char[width * height];
    }

    char symbolAt(int position) {
        if (isOutsideBoard(position)) {
            throw new RuntimeException("You cannot place that symbol at position " + position);
        }
        return chars[position];
    }

    private boolean isOutsideBoard(int position) {
        return position < 0 || position >= chars.length;
    }

    void markAtPoint(int position, char symbol) {
        chars[position] = symbol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i % 3 == 0) sb.append("\n");
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
