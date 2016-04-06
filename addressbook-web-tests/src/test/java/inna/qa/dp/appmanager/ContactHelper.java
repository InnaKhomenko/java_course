package inna.qa.dp.appmanager;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import inna.qa.dp.model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

   public void editContact(int index) {
       wd.findElements(By.xpath(".//*[@id='maintable']/tbody//img[@src='icons/pencil.png']")).get(index).click();
   }

    public void selectModificated(ContactData contact) {
        selectContactModificationById(contact.getId());

    }

    public void select(ContactData contact) {
        selectContactById(contact.getId());

    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void selectContactModificationById(int id) {
        wd.findElement(By.xpath(".//a[@href=\"edit.php?id=" + id + "\"]/img")).click();
    }

    public void goTo() {
        Click(By.linkText("home"));
    }

    public void modifyContact(ContactData contact) {
        addInfo(contact);
        updateContact();
        contactCache = null;
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
        contactCache = null;
}

    public void inputContact() {
        Click(By.xpath("//div[@id='content']/form/input[21]"));
        contactCache = null;
    }

    public void addNew() {
        Click(By.linkText("add new"));
        contactCache = null;
    }

    public void delete() {
        wd.switchTo().alert().accept();
        contactCache = null;
    }

    public void submit() {
        Click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void updateContact() {
        Click(By.name("update"));
    }

    public void create(ContactData contactData) {
        addNew();
        addInfo(contactData);
        inputContact();
        contactCache = null;
        goTo();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact){
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHome(home).withMobile(mobile).withWork(work);

    }

    private void initContactModificationById(int id) {
       // WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
      //  WebElement row = checkbox.findElement(By.xpath("./../.."));
       // List<WebElement> cells = row.findElements(By.tagName("td"));
       // cells.get(7).findElement(By.tagName("a")).click();

        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null ) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withHome(phones[0]).withMobile(phones[1]).withWork(phones[2]);
            contactCache.add(contact);
        }
        return contactCache;
    }
}
