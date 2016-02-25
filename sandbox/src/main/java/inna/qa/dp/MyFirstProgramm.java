package inna.qa.dp;

public class MyFirstProgramm {

    public static double distance(Point p1, Point p2) { //функция, вычисляющая расстояние между двумя точками
        return (Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)));
    }

    public static void main(String[] args) {//запускаемый класс
//объявляем координаты (x,y) 2х точек
        double x1 = 4;
        double x2 = 3;
        double y1 = 3;
        double y2 = 6;

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        System.out.println("Расстояние между точками " + " = " + (distance(p1, p2)));//вызов функции вычисления расстояния
        System.out.println("Расстояние между точками " + " = " + (p1.distance2(p1, p2)));//вызов метода вычисления расстояния в классе Point

    }

}
