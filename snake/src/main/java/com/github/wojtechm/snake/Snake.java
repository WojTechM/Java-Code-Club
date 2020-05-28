package com.github.wojtechm.snake;

import java.util.*;

public class Snake {

    public Direction currentDirection;
    private final Deque<Point> entireBody;

    public Snake(Point startPoint, Direction direction) {
        currentDirection = direction;
        entireBody= new LinkedList<>();
        entireBody.add(startPoint);
    }

    public Point extendInDirection(Direction nextDirection) {
        currentDirection = nextDirection;
        Point newHead = getHead().nextPositionInDirection(nextDirection);
        entireBody.add(newHead);
        return newHead;
    }

    public void moveInDirection(Direction nextDirection) {
        extendInDirection(nextDirection);
        entireBody.removeFirst();
    }

    public Point getHead() {
        return entireBody.getLast();
    }

    public boolean collidesWithItself() {
        Point head = getHead();
        int size = entireBody.size();
        int index = -1;
        for (Point next : entireBody) {
            index++;
            if (index == size - 1) break;
            if (next.equals(head)) return true;
        }
        return false;
    }

    public boolean isOnPoint(Point point) {
        return entireBody.contains(point);
    }
}
