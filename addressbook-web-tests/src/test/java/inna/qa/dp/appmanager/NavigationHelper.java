package inna.qa.dp.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Inna on 06.03.2016.
 */
public class NavigationHelper {
    protected GroupHelper groupHelper;
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
        groupHelper.returnToGroupPage();
    }
}
