package com.github.wojtechm.recursivebacktracker;

public class Cell {
    final Point point;
    private boolean top;
    private boolean down;
    private boolean left;
    private boolean right;
    boolean wasVisited;

    public Cell(Point point) {
        this.top = true;
        this.down = true;
        this.left = true;
        this.right = true;
        this.point = point;
    }

    public boolean wasVisited() {
        return wasVisited;
    }

    public void markAsVisited() {
        wasVisited = true;
    }

    public void demolishTopWall() {
        top = false;
    }
    public void demolishDownWall() {
        down = false;
    }

    public void demolishLeftWall() {
        left = false;
    }

    public void demolishRightWall() {
        right = false;
    }

    public boolean isTop() {
        return top;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}

