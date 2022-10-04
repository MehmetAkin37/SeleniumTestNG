package tests.Practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P04 {

    /*
    Keşif Testi (Exploratory Testing), diğer test yaklaşımlarında kolayca
    kapsanmayan hataları ve eksiklikleri keşfetmeye, ortaya çıkarmaya dayanır.
     Özellikle yazılım test döngüsünün başlarında sıkça başvurulan bir test türüdür.
     Test uzmanı açısından ise istediği şekilde son kullanıcı senaryoları oluşturma
     imkanı olduğu için eğlencelidir.
     */

    @Test
    public void test01() throws InterruptedException {


        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");


        // To-dos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebUniversityPage webUniversityPage = new WebUniversityPage();
        List<String> worklist = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka",
                               "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        Actions actions = new Actions(Driver.getDriver());

        for (String w: worklist) {
            actions.click(webUniversityPage.adNewToDo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }

        //Tüm yapılacakların üzerini çiz.
        List<WebElement> todos = webUniversityPage.todosWebelement;
        for (WebElement w:todos) {
            w.click();

        }

        //Tüm yapılacakları sil.
        List<WebElement> deleteButtons = webUniversityPage.deleteButtonsWebelement;
        for (WebElement w:deleteButtons) {
            w.click();

        }

        Thread.sleep(2000);
        //Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniversityPage.newtodosWebelement;
        Assert.assertEquals(0, newtodos.size());

        //Assert.assertTrue(webUniversityPage.adNewToDo.getText().isEmpty());









    }

}
