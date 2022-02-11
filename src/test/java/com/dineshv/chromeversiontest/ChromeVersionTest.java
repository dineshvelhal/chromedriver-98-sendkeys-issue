package com.dineshv.chromeversiontest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeVersionTest {

   ChromeDriver driver;
   String message = "This is a text area";

   @BeforeMethod
   public void setup() {
      System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_98.exe");

      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://dineshvelhal.github.io/testautomation-playground/keyboard_events.html");
   }

   @Test
   public void testBrowserVersion() throws InterruptedException {
      WebElement area = driver.findElement(By.id("area"));

      area.sendKeys(message);
      Thread.sleep(1000);
      area.sendKeys(Keys.chord(Keys.CONTROL, "A"));
      area.sendKeys(Keys.chord(Keys.CONTROL, "C"));
      area.clear();
      Thread.sleep(1000);
      area.sendKeys(Keys.chord(Keys.CONTROL, "V"));

      String text = area.getAttribute("value");

      System.out.println(text);
      Assert.assertEquals(text, message);
   }

   @AfterMethod
   public void tearDown() throws InterruptedException {
      Thread.sleep(5000);
      driver.quit();
   }
}
