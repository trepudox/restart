package com.trepudox.java17plus;

public class TesteRecords {

    public static void main(String[] args) {
        Point point = new Point(1, 2);
    }

}

record Point(int x, int y) {

    public int sum() {
        return this.x + this.y;
    }

}
