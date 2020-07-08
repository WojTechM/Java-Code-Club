package com.github.wojtechm.ox;

public class StartGame implements GameState {
    @Override
    public GameState update() {
        System.out.println("Hello to OX game!");
        return new GameSettings();
    }
}
