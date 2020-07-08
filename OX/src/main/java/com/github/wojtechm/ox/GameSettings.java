package com.github.wojtechm.ox;

public class GameSettings implements GameState {
    @Override
    public GameState update() {
        Settings settings = new Settings(3, 3, 3);
        return new PlayerPreparation(settings);
    }
}
