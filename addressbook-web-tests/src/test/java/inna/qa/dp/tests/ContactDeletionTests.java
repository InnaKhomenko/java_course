package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().goTo();
        if (app.group().list().size() == 0) {
            app.contact().create(new ContactData().withAddress("ukraine").withCompany("test3").withEmail1("inna@dd.com")
                    .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                    .withHome("4455").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                    .withFax("56565656565656").withWork("323434545454545"));
            app.contact().goTo();
        }
    }

    @Test
    public void testsContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().select(deletedContact);
        app.contact().submit();
        app.contact().delete();
        app.contact().goTo();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    }
}

