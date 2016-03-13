package inna.qa.dp.tests;

import inna.qa.dp.model.groupInfoContact;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testsContactDeletion() {
        app.getContactHelper().goToContactsPage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().CreateContact(new groupInfoContact("test1", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", "test1"),true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactModification();
        app.getContactHelper().deleteSelectedContact();
    }

}

