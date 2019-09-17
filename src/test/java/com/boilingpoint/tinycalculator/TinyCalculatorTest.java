/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boilingpoint.tinycalculator;

import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author ext_lesters
 */
public class TinyCalculatorTest
{
    private static WebDriver _driver;
    
    public TinyCalculatorTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        System.setProperty("webdriver.gecko.driver","c:/WebDriver/geckodriver.exe");
        _driver = new FirefoxDriver();
    }
    
    @AfterClass
    public static void tearDownClass()
    {
        _driver.quit();
    }
    
    @Before
    public void setUp()
    {
        _driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        setValue("param1","6");
        setValue("param2","4");
                
    }
    
    private void setValue(String id, String value){
        WebElement element = _driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }
    
    @After
    public void tearDown()
    {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAdd() {
        _driver.findElement(By.id("add")).click();
        String text = _driver.findElement(By.id("result")).getText();
        assertThat(text,equalTo("Result: 10.0"));
        
    }
    
    @Test
    public void testSubstract(){
        _driver.findElement(By.id("subtract")).click();
        String text = _driver.findElement(By.id("result")).getText();
        assertThat(text,equalTo("Result: 2.0"));
    }
    
    @Test
    public void testMultiply(){
        _driver.findElement(By.id("multiply")).click();
        String text = _driver.findElement(By.id("result")).getText();
        assertThat(text,equalTo("Result: 24.0"));
    }
    
    
    @Test
    public void testDivide(){
        _driver.findElement(By.id("divide")).click();
        String text = _driver.findElement(By.id("result")).getText();
        assertThat(text,equalTo("Result: 1.5"));
    }
}
