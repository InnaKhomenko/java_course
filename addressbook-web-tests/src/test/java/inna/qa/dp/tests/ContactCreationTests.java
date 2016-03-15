package inna.qa.dp.tests;

import inna.qa.dp.appmanager.ContactHelper;
import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.getContactHelper().goToContactsPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().addNewContact();
        app.getContactHelper().addInfoContact(new ContactData("test1", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", null));
        app.getContactHelper().inputContact();
        app.getContactHelper().goToContactsPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before, after - 1);
    }


}
