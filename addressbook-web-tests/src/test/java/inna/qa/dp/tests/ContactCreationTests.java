package inna.qa.dp.tests;

import inna.qa.dp.appmanager.SessionHelper;
import inna.qa.dp.model.groupInfoContact;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {

        app.addNewContact();
        app.addInfoContact(new groupInfoContact("test10may", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine", "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr", "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty"));
        app.inputContact();
        app.logout();
    }


}
