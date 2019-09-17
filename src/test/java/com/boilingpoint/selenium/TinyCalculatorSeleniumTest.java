/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boilingpoint.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ext_lesters
 */
public class TinyCalculatorSeleniumTest
{
    private static WebDriver _driver;
    
    @BeforeAll
    public static void setUpClass(){
        System.setProperty("webdriver.gecko.driver","c:/WebDriver/geckodriver.exe");
        _driver = new FirefoxDriver();
    }
    
    @AfterAll
    public static void tearDownClass() {
        _driver.quit();
    }
    
    @BeforeEach
    public void setUp(){
        _driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        setValue("param1","6");
        setValue("param2","4");
    }
    
    private void setValue(String id, String value){
        WebElement element = _driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(value);
    }
    
    @Test
    public void testAdd() {
        _driver.findElement(By.id("foadd")).click();
        String text = _driver.findElement(By.id("result")).getText();
        assertEquals("Result: 10.0",text);
        
    }
    
//    @Test
//    public void testSubstract(){
//        _driver.findElement(By.id("subtract")).click();
//        String text = _driver.findElement(By.id("result")).getText();
//        assertEquals("2.0",text);
//    }
//    
//    @Test
//    public void testMultiply(){
//        _driver.findElement(By.id("multiply")).click();
//        String text = _driver.findElement(By.id("result")).getText();
//        assertEquals("24.0",text);
//    }
//    
//    
//    @Test
//    public void testDivide(){
//        _driver.findElement(By.id("divide")).click();
//        String text = _driver.findElement(By.id("result")).getText();
//        assertEquals("1.5",text);
//    }
    
    
    
    
    
    /*
    @Test
    public void testSimple() throws Exception
    {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit NetBeans
        driver.get("http://www.netbeans.org");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.netbeans.org");

        // Check the title of the page
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>()
        {
            @Override
            public Boolean apply(WebDriver d)
            {
                return d.getTitle().contains("NetBeans");
            }
        });

        //Close the browser
        driver.quit();
    }
    */
}
