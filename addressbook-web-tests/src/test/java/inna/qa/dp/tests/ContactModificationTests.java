package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().goTo();
        if (app.group().list().size() == 0){
            app.contact().create(new ContactData("test1", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545",
                    "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545",
                    "rrttttyty", "test1"));
            app.contact().goTo();
        }
    }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().editContact(index);
        ContactData contact = new ContactData(before.get(index).getId(),"test11may", "inna23 ", "inna", "mio", "ddd", null,
                "ukraine", "www", "323434545454545","56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr",
                "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", null);
        app.contact().modifyContact(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
