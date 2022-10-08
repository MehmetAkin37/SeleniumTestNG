package tests.Practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuTestPage;
import utilities.Driver;

import java.util.List;


public class P05 {

    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    HerokuTestPage herokuTestPage;
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test01() throws InterruptedException {

        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        herokuTestPage = new HerokuTestPage();

        //kodlarımız yazarken clean code kapsamında daha sade kod yazabilmek amacı ile her test methodu içerisinde
        //ayrı bir object create etmektense bu objecti class seviyesinde instance olarak create edip
        //test methodlarında buna değer atamak ve kullanmak daha uygun bir yöntemdir

        herokuTestPage.onblur.click();
        herokuTestPage.onclick.click();
        herokuTestPage.onclick.click();
        actions.contextClick(herokuTestPage.contextmenu).
                doubleClick(herokuTestPage.doubleClick).
                click(herokuTestPage.onfocus).
                click(herokuTestPage.keydown)
                .sendKeys(Keys.ENTER).
                click(herokuTestPage.keyup).
                sendKeys(Keys.ENTER).
                click(herokuTestPage.keypress).
                sendKeys(Keys.ENTER).
                moveToElement(herokuTestPage.mouseOver).
                moveToElement(herokuTestPage.mouseLeave).
                moveToElement(herokuTestPage.mouseOver).
                click(herokuTestPage.mouseDown).perform();

        Thread.sleep(2000);

        List<WebElement> clicked = herokuTestPage.eventTriggered;
        Assert.assertEquals(11, clicked.size());

    }

    // Ekstra ikinci test olusturduk.Depends on ornegi yaptik burada.


    @Test (dependsOnMethods = "test01")
    public void test02() {

        List<WebElement> clicked = herokuTestPage.eventTriggered;
        Assert.assertEquals(11, clicked.size());

    }
}