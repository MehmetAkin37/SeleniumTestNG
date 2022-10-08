package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class C06_Odev {

    /*
    ODEV :

        Yeni bir Class Olusturun : C03_SoftAssert
     “http://zero.webappsecurity.com/” Adresine gidin
     Sign in butonuna basin
     Login kutusuna “username” yazin
     Password kutusuna “password” yazin
     Sign in tusuna basin
     Online banking menusu icinde Pay Bills sayfasina gidin
     “Purchase Foreign Currency” tusuna basin
     “Currency” drop down menusunden Eurozone’u secin
     soft assert kullanarak "Eurozone (Euro)" secildigini test edin
     soft assert kullanarak DropDown listesinin su secenekleri oldugunu
     test edin  "Select One", "Australia (dollar)", "Canada (dollar)",
     "Switzerland (franc)","China  (yuan)","Denmark (krone)","Eurozone (euro)",
     "Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)","Mexico (peso)",
     "Norway (krone)","New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

     */

    //Yeni bir Class Olusturun : C03_SoftAssert
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    @Test
    public void test01() {
        //"http://zero.webappsecurity.com/" Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");


        //Sign in butonuna basin
        Driver.getDriver().findElement(By.cssSelector("[id=\"signin_button\"]")).click();

        //Login kutusuna "username" yazin
        Driver.getDriver().findElement(By.xpath("//*[contains(@id,\"user_login\")]")).sendKeys("username");


        //Password kutusuna "password" yazin
        Driver.getDriver().findElement(By.xpath("//*[contains(@type,\"password\")]")).sendKeys("password");


        //Sign in tusuna basin
        Driver.getDriver().findElement(By.cssSelector("[type=\"submit\"]")).click();

        // WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.visibilityOf())
        Driver.getDriver().navigate().back();

        //Online banking menusu icinde Pay Bills sayfasina gidin
        WebElement onlineBaking = Driver.getDriver().findElement(By.xpath("//strong[text()='Online Banking']"));
        wait.until(ExpectedConditions.visibilityOf(onlineBaking));
        onlineBaking.click();

        Driver.getDriver().findElement(By.cssSelector("#pay_bills_link")).click();


        //"Purchase Foreign Currency" tusuna basin
        Driver.getDriver().findElement(By.xpath("(//ul)[5]//li[3]")).click();

        //"Currency" drop down menusunden Eurozone'u secin
        WebElement dropDown = Driver.getDriver().findElement(By.cssSelector("[class=\"span4\"][name=\"currency\"]"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");


        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String actualDropDownTitle = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualDropDownTitle, "Eurozone (euro)");


        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin  "
        List<WebElement> list = select.getOptions();

        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));


        // Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China  (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)","Mexico (peso)",
        // "Norway (krone)","New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        for (int i = 0; i < expectedList.size(); i++) {
            softAssert.assertEquals(list.get(i).getText(), expectedList.get(i));
        }


        softAssert.assertAll();

        Driver.quitDriver();


    }


}
    /*
    ODEV :

    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

     */

      /*
      ODEV :
      Bir class oluşturun: DependsOnTest
      https://www.amazon.com/ adresine gidin.
      Test : Amazon ana sayfaya gittiginizi test edin
      Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
      arama yapin ve aramanizin gerceklestigini Test edin
      Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
      $16.83 oldugunu test edin

       */