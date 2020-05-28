package com.github.wojtechm.snake;

public class SnakeGame {

    public static void main(String[] args) {
        Snake snake = new Snake(new Point(0,0), Direction.UP);
        Dimensions dimensions = new Dimensions(10, 10);
        FoodContainer foodContainer = new FoodContainer(10, dimensions);
        CollisionChecker collisionChecker = new CollisionChecker(dimensions, foodContainer, snake);
        InputProvider inputProvider = new InputProvider(System.in);
        View view = new View(dimensions, snake, foodContainer);

        boolean isRunning = true;
        while (isRunning) {
            view.printGame();
            Direction nextDirection = inputProvider.getDirection(snake.currentDirection);
            moveSnake(snake, collisionChecker, nextDirection, foodContainer);
            if (collisionChecker.isSnakeColliding()) {
                isRunning = false;
            }
        }
    }

    private static void moveSnake(Snake snake, CollisionChecker collisionChecker, Direction nextDirection, FoodContainer foodContainer) {
        if (nextDirection == Direction.NONE) {
            nextDirection = snake.currentDirection;
        }
        CollisionType collisionType = collisionChecker.inDirection(nextDirection);
        if (collisionType == CollisionType.FOOD) {
            Point newHeadPosition = snake.extendInDirection(nextDirection);
            foodContainer.removeFoodAtPoint(newHeadPosition);
        } else {
            snake.moveInDirection(nextDirection);
        }
    }
}
