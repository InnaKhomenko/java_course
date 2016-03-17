package inna.qa.dp.appmanager;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void goToContactsPage() {
        Click(By.linkText("home"));
    }

    public void addInfoContact(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getName());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());

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

    public void createContact(ContactData contactData) {
        addNewContact();
        addInfoContact(contactData);
        inputContact();
        goToContactsPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr.odd"));
        for (WebElement element : elements){
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
