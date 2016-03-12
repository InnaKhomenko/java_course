package inna.qa.dp.appmanager;

import inna.qa.dp.model.groupInfoContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void selectContact() {
        Click(By.xpath("//input[@id='MassCB']"));
    }

    public void goToContactsPage() {
        Click(By.linkText("home"));
    }

    public void addInfoContact(groupInfoContact groupInfoContact) {
        type(By.name("firstname"),groupInfoContact.getFirstname());
        type(By.name("middlename"),groupInfoContact.getName());
        type(By.name("lastname"),groupInfoContact.getLastname());
        type(By.name("nickname"),groupInfoContact.getNickname());
        type(By.name("title"),groupInfoContact.getTitle());
        type(By.name("company"),groupInfoContact.getCompany());
        type(By.name("address"),groupInfoContact.getAddress());
        type(By.name("home"),groupInfoContact.getHome());
        type(By.name("mobile"),groupInfoContact.getMobile());
        type(By.name("work"),groupInfoContact.getWork());
        type(By.name("fax"),groupInfoContact.getFax());
        type(By.name("email2"),groupInfoContact.getEmail2());
        type(By.name("email3"),groupInfoContact.getEmail3());
        type(By.name("homepage"),groupInfoContact.getHomepage());
        type(By.name("address2"),groupInfoContact.getAddress2());
        type(By.name("phone2"),groupInfoContact.getPhone2());
        type(By.name("notes"),groupInfoContact.getNotes());;
    }

    public void inputContact() {
        Click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void addNewContact() {
        Click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {
        wd.switchTo().alert().accept();
    }

    public void submitContactModification() {
        Click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void editContact() {
        Click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void updateContact() {
        Click(By.name("update"));
    }
}
