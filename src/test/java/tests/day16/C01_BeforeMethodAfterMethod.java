package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod  extends TestBaseBeforeMethodAfterMethod {

    // tests classi olusturduk
    // utilities leri kopyaladik ve Before'lari BeforeMethod ve After'lari AfterMethod yaptik

    // TestNG framework'unde @Before ve @After notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    //Çalışma prensibi JUnit deki Before,After ile aynıdır

    @Test
    public void amazonTesti() {
       driver.get("https://www.amazon.com");

    }

    @Test (groups ="gp1")
    public void bestBuyTesti() {
        driver.get("https://www.bestbuy.com");

    }

    @Test
    public void techproeducationTesti() {
        driver.get("https://www.techproeducation.com");

    }

















}
