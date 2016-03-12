package inna.qa.dp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquestionTests {

    @Test
    public void test0(){
        Equastion e =new Equastion(1,1,1);
        Assert.assertEquals(e.rootNumber(),0);
    }

    @Test
    public void test1(){
        Equastion e =new Equastion(1,2,1);
        Assert.assertEquals(e.rootNumber(),1);
    }

    @Test
    public void test2(){
        Equastion e =new Equastion(1,5,6);
        Assert.assertEquals(e.rootNumber(),2);
    }

    @Test
    public void testLinear(){
        Equastion e =new Equastion(0,1,1);
        Assert.assertEquals(e.rootNumber(),1);
    }

    public void testConstant(){
        Equastion e =new Equastion(0,0,1);
        Assert.assertEquals(e.rootNumber(),0);
    }

    public void testZero(){
        Equastion e =new Equastion(0,0,0);
        Assert.assertEquals(e.rootNumber(),-1);
    }
}
