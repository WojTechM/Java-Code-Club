package com.github.wojtechm.snake;

public class CollisionChecker {

    private final Dimensions dimensions;
    private final FoodContainer foodContainer;
    private final Snake snake;

    public CollisionChecker(Dimensions dimensions, FoodContainer foodContainer, Snake snake) {
        this.dimensions = dimensions;
        this.foodContainer = foodContainer;
        this.snake = snake;
    }

    public CollisionType inDirection(Direction nextDirection) {
        Point head = snake.getHead();
        Point nextPosition = head.nextPositionInDirection(nextDirection);
        return foodContainer.contains(nextPosition) ? CollisionType.FOOD : CollisionType.EMPTY;
    }

    public boolean isSnakeColliding() {
        return snakeIsOutOfBoard() || snakeAteItself();
    }

    private boolean snakeIsOutOfBoard() {
        Point head = snake.getHead();
        return head.x < 0 || head.x > dimensions.width || head.y < 0 || head.y > dimensions.height;
    }

    private boolean snakeAteItself() {
        return snake.collidesWithItself();
    }
}
