package inna.qa.dp.appmanager;

import inna.qa.dp.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        Click(By.linkText("groups"));
    }

    public void submitGroupCreation() {
        Click(By.name("submit"));
    }

    public void feelGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        Click(By.name("new"));
    }

    public void selectGroup() {
        Click(By.name("selected[]"));
    }

    public void deleteSelectedGroups() {
        Click(By.name("delete"));
    }

    public void initGroupModification() {
        Click(By.name("edit"));
    }

    public void submitGroupModification() {
        Click(By.name("update"));
    }

    public void createGroupe(GroupData group) {
        initGroupCreation();
        feelGroupForm(group);
        submitGroupCreation();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}