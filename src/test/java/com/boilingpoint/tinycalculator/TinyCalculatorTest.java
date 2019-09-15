/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boilingpoint.tinycalculator;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TinyCalculatorTest {

    private static WebDriver _driver;
    
    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.gecko.driver", "c:/Gecko/geckodriver.exe");
        _driver = new FirefoxDriver();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        _driver.quit();
    }
            
    @Before
    public void setUp() {
        _driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        setValue("form:param1","6");
        setValue("form:param2","4");
    }
    
    private void setValue(String id, String value){
        WebElement element = _driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }
    
    @Test
    public void testAdd() {
        _driver.findElement(By.id("form:add")).click();
        String text = _driver.findElement(By.id("form:result")).getText();
        assertThat(text, equalTo("10.0"));
    }
    
    @Test
    public void testSubstract() {
        _driver.findElement(By.id("form:sub")).click();
        String text = _driver.findElement(By.id("form:result")).getText();
        assertThat(text, equalTo("2.0"));
    }
    
    @Test
    public void testMultiply() {
        _driver.findElement(By.id("form:mul")).click();
        String text = _driver.findElement(By.id("form:result")).getText();
        assertThat(text, equalTo("24.0"));
    }
    
    @Test
    public void testDivide() {
        _driver.findElement(By.id("form:div")).click();
        String text = _driver.findElement(By.id("form:result")).getText();
        assertThat(text, equalTo("1.5"));
    }
    
}