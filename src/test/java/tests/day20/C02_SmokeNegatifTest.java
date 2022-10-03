package tests.day20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegatifTest {

    @Test
    public void yanlisKullanici() {   // 1. Senaryo : Yanlis kullanici dogru sifre

        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //  login butonuna bas
        hmcPage.login.click();

        //  test data username: manager1 ,  test data password : Manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.ENTER).perform();


        //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatin
        Driver.closeDriver();

    }


    @Test
    public void yanlisSifre() {  // 2. Senaryo : Yanlis sifre dogru kullanici

        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //  login butonuna bas
        hmcPage.login.click();

        //  test data username: manager1 ,  test data password : manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPass"))
                .sendKeys(Keys.ENTER).perform();


        //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatin
        Driver.closeDriver();


    }


    @Test
    public void yanlisKullaniciSifre() { // 3. Senaryo : Yanlis kullanici yanlis sifre


        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //  login butonuna bas
        hmcPage.login.click();

        //  test data username: manager1 ,  test data password : manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPass"))
                .sendKeys(Keys.ENTER).perform();


        //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());

        //Sayfayi kapatin
        Driver.closeDriver();

    }


}
