package com.github.wojtechm.snake;

public class View {

    private final Dimensions dimensions;
    private final Snake snake;
    private final FoodContainer foodContainer;

    public View(Dimensions dimensions, Snake snake, FoodContainer foodContainer) {
        this.dimensions = dimensions;
        this.snake = snake;
        this.foodContainer = foodContainer;
    }

    public void printGame() {
        for (int y = dimensions.height - 1; y >= 0; y--) {
            for (int x = 0; x < dimensions.width; x++) {
                printPoint(y, x);
            }
            System.out.println();
        }
    }

    private void printPoint(int y, int x) {
        Point point = new Point(x, y);
        if (snake.isOnPoint(point)) {
            System.out.print("#");
        } else if (foodContainer.contains(point)) {
            System.out.print("f");
        } else {
            System.out.print(".");
        }
    }
}
