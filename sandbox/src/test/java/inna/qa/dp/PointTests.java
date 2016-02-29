package inna.qa.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;


public class PointTests {
    @Test
    public void TestDistance() {

        double x1 = 4;
        double x2 = 3;
        double y1 = 3;
        double y2 = 6;

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        Assert.assertEquals(p2.distance2(p1, p2), 3.1622776601683795);
        Assert.assertEquals(p1.distance_P1(p1, p2), 1.0);
        Assert.assertEquals(p1.distance_P2(p1, p2), 9.0);

    }
}
