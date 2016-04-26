package inna.qa.dp.appmanager;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import inna.qa.dp.model.Groups;
import inna.qa.dp.tests.ContactEmailTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

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
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());
        //attach(By.name("photo"), contactData.getPhoto());
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
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String emil1 = wd.findElement(By.name("email")).getAttribute("value");
        String emil2 = wd.findElement(By.name("email2")).getAttribute("value");
        String emil3 = wd.findElement(By.name("email3")).getAttribute("value");
        String company = wd.findElement(By.name("company")).getAttribute("value");
        String fax = wd.findElement(By.name("fax")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withMiddlename(middlename)
                .withHome(home).withMobile(mobile).withWork(work).withAddress(address).withEmail1(emil1)
                .withEmail2(emil2).withEmail3(emil3).withCompany(company).withFax(fax);
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
    }

    public ContactData infoFromDetailsForm(ContactData contact) {
        initDatailsPageById(contact.getId());
        String allContent = wd.findElement(By.id("content")).getText();
        String content = "";
        List<WebElement> elements = wd.findElements(By.cssSelector("a[target=\"_new\"]"));
        for (WebElement element : elements) {
            String site = element.getText();
            content = allContent.replaceAll(site, "");
            allContent = content;
            content = "";
        }
        content = allContent.replaceAll("\\(\\)","");
        return new ContactData().withId(contact.getId()).withAllContent(content);
    }


    public void mergePhones(ContactData contact) {
        String phone = "";
        if (!contact.getHome().equals("")) {
            phone += String.format("H:%s", contact.getHome());
        }
        if (!contact.getMobile().equals("")) {
            phone += String.format("M:%s", contact.getMobile());
        }
        if (!contact.getWork().equals("")) {
            phone += String.format("W:%s", contact.getWork());
        }

        if (!contact.getFax().equals("")) {
            phone += String.format("F:%s", contact.getFax());
        }
        contact.withAllPhones(phone);
    }


    public void mergeEmails(ContactData contact) {
        String emailString = Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).
                stream().filter((s) -> ! s.equals("")).map(ContactEmailTests::cleaned).
                collect(Collectors.joining("\n"));
        contact.withAllEmails(emailString);
    }

    public void initDatailsPageById(int id) {
        wd.findElement(By.xpath(".//a[@href=\"view.php?id=" + id + "\"]")).click();
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
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String allAddress = element.findElement(By.xpath(".//td[4]")).getText();
            String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones).withAllAddress(allAddress).withAllEmails(allEmails);
            contactCache.add(contact);
        }
        return contactCache;
    }
}
