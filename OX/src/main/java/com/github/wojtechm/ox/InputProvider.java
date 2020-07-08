package com.github.wojtechm.ox;

import java.util.Scanner;

public enum InputProvider {
    INSTACE;

    private static final Scanner s = new Scanner(System.in);

    public String getString() {
        return s.nextLine();
    }

    public int getInt() {
        while (!s.hasNextInt()) {
            s.nextLine();
        }
        return s.nextInt();
    }
}
