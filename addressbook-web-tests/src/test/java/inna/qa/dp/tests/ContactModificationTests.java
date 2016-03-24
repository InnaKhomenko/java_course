package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {

        app.getContactHelper().goToContactsPage();

        if (! app.getContactHelper().isThereAContact()){
        app.getContactHelper().createContact(new ContactData("test1", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", "test1"));
        app.getContactHelper().goToContactsPage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"test11may", "inna23 ", "inna", "mio", "ddd", null, "ukraine", "www", "323434545454545","56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", null);
        app.getContactHelper().addInfoContact(contact);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
