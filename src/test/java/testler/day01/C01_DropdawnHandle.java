package testler.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_DropdawnHandle {
    WebDriver driver;

    @Test
    public void test1(){
        driver.get("https://www.amazon.de/");
        WebElement DropDownElementi= driver.findElement(By.xpath("//select [@id='searchDropdownBox']"));
        Select select=new Select(DropDownElementi);
        select.selectByVisibleText("Baby");
        List<WebElement> list1=select.getOptions();
        List<String> list2=new ArrayList<>();
        for (WebElement each:list1
             ) {
            System.out.println(each.getText());
            list2.add(each.getText());
        }
        Assert.assertTrue(list2.contains("Kindle-Shop"));
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
  @AfterMethod
    public void teardown(){
        driver.close();
  }
}
