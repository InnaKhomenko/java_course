package inna.qa.dp;

public class Point {//создание класса Point

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance2(Point p1, Point p2) {//метод вычисления расстояния в классе Point
        return (Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)));
    }

}
