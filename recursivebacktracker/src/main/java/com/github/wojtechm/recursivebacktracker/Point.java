package com.github.wojtechm.recursivebacktracker;

import java.util.Objects;

public class Point {
    final int X;
    final int Y;

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public Point onTop() {
        return new Point(X, Y - 1);
    }

    public Point onDown() {
        return new Point(X, Y + 1);
    }

    public Point onLeft() {
        return new Point(X - 1, Y);
    }

    public Point onRight() {
        return new Point(X + 1, Y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return X == point.X &&
                Y == point.Y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
