package com.github.wojtechm.snake;

public enum Direction {
    UP("w"), DOWN("s"), LEFT("a"), RIGHT("d"), NONE("");

    public final String asKey;

    Direction(String asKey) {
        this.asKey = asKey;
    }
}
