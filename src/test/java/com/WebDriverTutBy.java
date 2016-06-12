package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Gleb on 12.06.2016.
 */
public class WebDriverTutBy {

    /**
     * Find positions for "���������� �� ������������" in tut.by
     * no input parameters
     * no return parameters
     */
    @Test
    public void testFindWork_GetPositionsOfQASpecialist(){
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.tut.by/");

        Assert.assertTrue(driver.getTitle().contains("TUT.BY"));

        driver.findElement(By.linkText("������")).click();

        driver.findElement(By.name("text")).sendKeys("���������� �� ������������");
        driver.findElement(By.name("text")).sendKeys(Keys.RETURN);
        
        String regex = "���������� �� ������������";
        List<WebElement> links = driver.findElements(By.partialLinkText(regex));

        if (links.size() == 0) {
            System.out.println("No results");
            Assert.assertTrue(false);
        }
        else {
            for (int i = 0; i<links.size(); i++){
                System.out.println(links.get(i));
            }
        }

       driver.close();
    }
}
