package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().goTo();
            if (app.group().list().size() == 0) {
                app.contact().create(new ContactData().withAddress("ukraine").withCompany("test3")
                        .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                        .withHome("4455").withLastname("khomenko").withMobile("56565656565656")
                        //.withName("zp")
                        .withFax("56565656565656").withWork("323434545454545"));
                app.contact().goTo();
            }
        }
    }

    @Test
    public void testContactModification() {
        app.contact().goTo();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withAddress("ukraine").withCompany("test3")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("4455").withLastname("khomenko").withMobile("56565656565656")
                //.withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().selectModificated(contact);
        app.contact().modifyContact(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
