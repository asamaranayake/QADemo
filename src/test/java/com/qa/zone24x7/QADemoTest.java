package com.qa.zone24x7;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QADemoTest {

    private QADemoApp qaDemoApp;


    @BeforeMethod
    public void setUp(){
        qaDemoApp = new QADemoApp();
    }

    @Test
    public void testAddition(){
        int actualResult = qaDemoApp.addition(2,2);
        Assert.assertEquals(actualResult , 4 ,"2 + 2 Should be 4");
        System.out.println("Test is Completed " + actualResult);
    }
}
