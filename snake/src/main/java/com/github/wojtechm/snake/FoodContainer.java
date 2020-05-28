package com.github.wojtechm.snake;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FoodContainer {

    private final int foodLimit;
    private final Dimensions boardDimensions;
    List<Point> pointList;

    public FoodContainer(int foodLimit, Dimensions boardDimensions) {
        this.foodLimit = foodLimit;
        this.boardDimensions = boardDimensions;
        pointList = new LinkedList<>();
        randomlyDistributeFoodOnBoard();
    }

    private void randomlyDistributeFoodOnBoard() {
        for (int i = 0; i < foodLimit; i++) {
            addFoodWithRandomPosition();
        }
    }

    private void addFoodWithRandomPosition() {
        Point randomPoint;
        do {
            randomPoint = getRandomPoint();
        } while (pointList.contains(randomPoint));
        pointList.add(randomPoint);
    }

    private Point getRandomPoint() {
        return new Point(getRandomNumberInRange(boardDimensions.width),
                getRandomNumberInRange(boardDimensions.height));
    }

    private int getRandomNumberInRange(int range) {
        return ThreadLocalRandom.current().nextInt(range);
    }

    public void removeFoodAtPoint(Point point) {
        pointList.remove(point);
        addFoodWithRandomPosition();
    }

    public boolean contains(Point nextPosition) {
        return pointList.contains(nextPosition);
    }
}
