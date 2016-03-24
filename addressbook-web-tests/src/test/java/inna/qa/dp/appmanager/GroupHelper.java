package inna.qa.dp.appmanager;

import inna.qa.dp.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public int getGroupeCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups =  new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}