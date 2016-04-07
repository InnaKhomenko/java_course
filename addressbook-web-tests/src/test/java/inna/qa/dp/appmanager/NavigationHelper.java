package inna.qa.dp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
            Click(By.linkText("groups"));
        }

    public  void  gotoHomePage(){
        if (isElementPresent(By.id("maintable")))
        {
            return;
        }
        Click(By.linkText("home"));
    }

}
