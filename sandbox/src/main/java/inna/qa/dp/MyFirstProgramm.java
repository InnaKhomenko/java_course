package inna.qa.dp;


public class MyFirstProgramm {

  public static void main(String[] args) {

    double x1 = 4;
    double x2 = 3;
    double y1 = 3;
    double y2 = 6;

    Point pp1 = new Point(x1, y1, x2, y2);

    System.out.println("Расстояние между точками " + " = " + (pp1.distance(pp1,pp1,pp1,pp1)));

  }
}