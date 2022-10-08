package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {


    @Test
    public void test01() throws IOException {

        // Hepsiburada sayfasina gidiniz
        Driver.getDriver().get("https://hepsiburada.com");

        // Ve sayfanin resmini aliniz
        ReusableMethods.getScreenshot("hepsiburada");

        // Sayfayi kapatiniz
        Driver.closeDriver();


    }



    @Test
    public void test02() throws IOException {
        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        AmazonPage amznPage = new AmazonPage();

        //Nutella aratınız
        amznPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("AramaSonucuWE", amznPage.aramaSonucuWE);

    }

}
