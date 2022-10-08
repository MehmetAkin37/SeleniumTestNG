package tests.day21;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class HepsiBurada {

    /*
    //Hepsiburada sayfasına gidiniz
    //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
    //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
    //Sayfayı kapatalım
     */

    WebDriver driver= Driver.getDriver();
    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws IOException {
        driver.get("https://www.hepsiburada.com/");
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("hepsiburada"));
        ReusableMethods.waitFor(2);
        // driver.findElement(By.xpath("//li[contains(span,'Elektronik')]")).click();



////label[starts-with(@id,’message’)  //a[starts-with(@class,'sf-ChildMenuItems')]

        String sayfaAdi;
        String dinamikpath;
        for (int i = 1; i <66 ; i++) {
            ReusableMethods.hover(driver.findElement(By.xpath("//li[contains(span,'Elektronik')]")));
            ReusableMethods.waitFor(2);
            ReusableMethods.hover(driver.findElement(By.xpath("//li[contains(a,'Bilgisayar/Tablet')]")));
            dinamikpath="(//a[starts-with(@class,'sf-ChildMenuItems-KdzkrxSVhcwDy3od0Yre item')]//following::span)["+i+"]";
            WebElement sayfa= driver.findElement(By.xpath(dinamikpath));
            sayfaAdi=sayfa.getText();
            sayfa.click();
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshot(sayfaAdi);
            driver.navigate().back();
            ReusableMethods.waitFor(3);

        }

    }









}
