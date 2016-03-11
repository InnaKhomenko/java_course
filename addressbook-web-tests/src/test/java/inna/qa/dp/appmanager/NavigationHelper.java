package inna.qa.dp.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Inna on 06.03.2016.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
       // wd.findElement(By.linkText("groups")).click();
        //Click("groups");
        Click(By.linkText("groups"));
        }
}
