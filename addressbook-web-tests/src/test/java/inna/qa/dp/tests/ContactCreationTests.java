package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.contact().goTo();
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData("test3", "inna23 ", "khomenko", "mio", "ddd", "zp",
                "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr",
                "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty",null);
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size() - 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
