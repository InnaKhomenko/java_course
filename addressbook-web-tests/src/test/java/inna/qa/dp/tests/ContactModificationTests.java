package inna.qa.dp.tests;

import inna.qa.dp.model.groupInfoContact;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getContactHelper().goToContactsPage();
        //app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().addInfoContact(new groupInfoContact("test11may", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty"));
       // app.getContactHelper().submitContactModification();
        app.getContactHelper().updateContact();
        app.getContactHelper().goToContactsPage();
    }
}
