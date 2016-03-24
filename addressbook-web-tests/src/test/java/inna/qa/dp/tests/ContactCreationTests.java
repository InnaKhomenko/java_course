package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.getContactHelper().goToContactsPage();
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("test3", "inna23 ", "khomenko", "mio", "ddd", "zp",
                "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr",
                "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty",null);
        app.getContactHelper().addNewContact();
        app.getContactHelper().addInfoContact(contact);
        app.getContactHelper().inputContact();
        app.getContactHelper().goToContactsPage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(before.size(), after.size() - 1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
