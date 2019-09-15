/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boilingpoint.tinycalculatortests;

import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author lserd
 */
public class NewSeleneseIT {
    
    
    
    public NewSeleneseIT(){
        System.setProperty("webdriver.gecko.driver", "c:/Gecko/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","c:/WebDriver/chromedriver.exe");
    }
    
    
//    @Test
//    public void testSimple() throws Exception {
//        // Create a new instance of the Firefox driver
//        // Notice that the remainder of the code relies on the interface, 
//        // not the implementation.
//
//        WebDriver driver = new ChromeDriver();
//
//        // And now use this to visit NetBeans
//        driver.get("http://www.netbeans.org");
//        // Alternatively the same thing can be done like this
//        // driver.navigate().to("http://www.netbeans.org");
//
//        // Check the title of the page
//        // Wait for the page to load, timeout after 10 seconds
//        (new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().contains("NetBeans");
//            }
//        });
//
//        //Close the browser
//        driver.quit();
//    }
//    
//    
//    @Test
//    public void GoogleSearchButtonByName()
//    {
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.google.com");
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("Welcome to Selenium");
//        WebElement googleSearch = driver.findElement(By.name("btnK"));
//        googleSearch.submit();
//        driver.quit();
//    }
//   
    @Test
    public void Add(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        
        WebElement inputParam1 = driver.findElement(By.id("param1"));
        WebElement inputParam2 = driver.findElement(By.id("param2"));
        WebElement btnAdd = driver.findElement(By.id("add"));

 
     
        inputParam1.clear();
        inputParam1.sendKeys("10");
        
        inputParam2.clear();
        inputParam2.sendKeys("5");
         
        
        // Add
        btnAdd.click();
        WebElement divResult = driver.findElement(By.id("result"));
        Assert.assertEquals("Result: 15.0",divResult.getText());

        driver.quit();
          
    }
    
    @Test
    public void Subtract(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        
        WebElement inputParam1 = driver.findElement(By.id("param1"));
        WebElement inputParam2 = driver.findElement(By.id("param2"));
        WebElement btnSub = driver.findElement(By.id("subtract"));

     
        inputParam1.clear();
        inputParam1.sendKeys("10");
        
        inputParam2.clear();
        inputParam2.sendKeys("5");
         

        
        // Subtract
        btnSub.click();
        WebElement divResult = driver.findElement(By.id("result"));
        Assert.assertEquals("Result: 5.0",divResult.getText());

        driver.quit();
          
    }
    
    @Test
    public void Multiply(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        
        WebElement inputParam1 = driver.findElement(By.id("param1"));
        WebElement inputParam2 = driver.findElement(By.id("param2"));
        WebElement btnMul = driver.findElement(By.id("multiply"));

     
        inputParam1.clear();
        inputParam1.sendKeys("10");
        
        inputParam2.clear();
        inputParam2.sendKeys("5");
         

        
        // Multiply
        btnMul.click();
        WebElement divResult = driver.findElement(By.id("result"));
        Assert.assertEquals("Result: 50.0",divResult.getText());

        driver.quit();
          
    }
    
    @Test
    public void Divide(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        
        WebElement inputParam1 = driver.findElement(By.id("param1"));
        WebElement inputParam2 = driver.findElement(By.id("param2"));
        WebElement btnDiv = driver.findElement(By.id("divide"));

     
        inputParam1.clear();
        inputParam1.sendKeys("10");
        
        inputParam2.clear();
        inputParam2.sendKeys("5");
         

        
        // Divide
        btnDiv.click();
        WebElement divResult = driver.findElement(By.id("result"));
        Assert.assertEquals("Result: 2.0",divResult.getText());

        driver.quit();
          
    }
    
    
    @Test
    public void ActionBuildPerform(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/TinyCalculator/index.xhtml");
        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));
        // Add all the actions into the Actions builder.
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
            .click(one)
            .click(three)
            .click(five)
            .keyUp(Keys.CONTROL);
        // Generate the composite action.
        Action compositeAction = builder.build();
        // Perform the composite action.
        compositeAction.perform();
    }
}
