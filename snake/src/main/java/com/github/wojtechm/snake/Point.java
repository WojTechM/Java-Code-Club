package com.github.wojtechm.snake;

import java.util.Objects;

public class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Point nextPositionInDirection(Direction nextDirection) {
        switch (nextDirection) {
            case UP:
                return new Point(x, y + 1);
            case DOWN:
                return new Point(x, y - 1);
            case LEFT:
                return new Point(x - 1, y);
            case RIGHT:
                return new Point(x + 1, y);
            default:
                return this;
        }
    }
}
