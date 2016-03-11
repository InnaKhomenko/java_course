package inna.qa.dp.appmanager;

import inna.qa.dp.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Inna on 04.03.2016.
 */
public class GroupHelper extends HelperBase {


    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void feelGroupForm(GroupData groupData) {
        type(By.name("group_name"),groupData.getName());
        type(By.name("group_header"),groupData.getHeader());
        type(By.name("group_footer"),groupData.getFooter());
    }

    public void initGroupCreation() {
        Click(By.name("new"));
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }
}