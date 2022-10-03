package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {

     /*Testlerimizi çalıştırırken istediğimiz sıraya göre çalışmasını istersek
    priority methodunu kullanırız
     Priority kullanmazsak default olarak 0 dır
     */

    @Test (priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");

    }

    @Test  // Burayı 0 kabul eder
    public void bestBuyTest() {
        driver.get("https://www.bestbuy.com");

    }

    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");

    }

    @Test (priority = -1)
    public void hepsiBuradaTest() {
        driver.get("https://www.hepsiburada.com");

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
}
