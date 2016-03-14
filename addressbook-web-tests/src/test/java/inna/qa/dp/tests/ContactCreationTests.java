package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {

        app.getContactHelper().addNewContact();
        app.getContactHelper().addInfoContact(new ContactData("test1", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", "test1"),true);
        app.getContactHelper().inputContact();
        app.getContactHelper().goToContactsPage();
    }


}
