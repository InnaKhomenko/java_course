package inna.qa.dp.appmanager;

import inna.qa.dp.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void goTo() {
        Click(By.linkText("home"));
    }

    public void modifyContact(ContactData contact) {
        addInfo(contact);
        updateContact();
        goTo();
    }

    public void addInfo(ContactData contactData) {
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

    public void addNew() {
        Click(By.linkText("add new"));
    }

    public void delete() {
        wd.switchTo().alert().accept();
    }

    public void submit() {
        Click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void editContact(int index) {
        wd.findElements(By.xpath(".//*[@id='maintable']/tbody//img[@src='icons/pencil.png']")).get(index).click();
    }

    public void updateContact() {
        Click(By.name("update"));
    }

    public void create(ContactData contactData) {
        addNew();
        addInfo(contactData);
        inputContact();
        goTo();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            ContactData contact = new ContactData(id,firstname,null,lastname, null, null, null,null,null,null,null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
