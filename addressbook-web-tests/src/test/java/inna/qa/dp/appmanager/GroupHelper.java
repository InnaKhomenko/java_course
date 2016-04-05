package inna.qa.dp.appmanager;

import inna.qa.dp.model.GroupData;
import inna.qa.dp.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void selectGroupByID(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void create(GroupData group) {
        initGroupCreation();
        feelGroupForm(group);
        groupCache = null;
        submitGroupCreation();
    }

    public void modify(GroupData group) {
        selectGroupByID(group.getId());
        initGroupModification();
        feelGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupByID(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
       return wd.findElements(By.name("selected[]")).size();
    }


    public List<GroupData> list() {
        List<GroupData> groups =  new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withtName(name));
        }
        return groups;
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }
        groupCache =  new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withtName(name));
        }
        return new Groups(groupCache);
    }
}