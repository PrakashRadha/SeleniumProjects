package com.testng;

import org.testng.Assert;
import org.testng.annotations.*;

public class MyFirstTest {
    @Test(priority = -1)
    public void myName() {
        System.out.println("My name is Ram");
        Assert.assertFalse(true);
    }

    @Test(priority = 0)
    public void myCity() {
        System.out.println("My city is Chennai");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "myName")
    public void myQualification() {
        System.out.println("I'm a graduate");
    }

    @Test
    public void nationality() {
        System.out.println("I'm an Indian");
    }
}
