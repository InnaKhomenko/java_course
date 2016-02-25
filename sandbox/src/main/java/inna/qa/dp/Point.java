package inna.qa.dp;

/**
 * Created by inna on 24.02.16.
 */
public class Point {

  public double p1;
  public double p2;
  public double p3;
  public double p4;
  public double y1;
  public double y2;

  public Point(double p1, double p2, double p3, double p4) {
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }


  public double distance(Point p1,Point p2, Point p3,Point p4){
    return  (Math.sqrt(Math.pow(this.p3 - this.p1, 2) + Math.pow(this.p4 - this.p2, 2)));
   // return 0;
  }
}
