package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.contact().goTo();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withAddress("ukraine").withCompany("test3").withEmail1("inna@dd.com")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("4455").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testsBadContactCreation() {
        app.contact().goTo();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withAddress("ukraine'").withCompany("test3").withEmail1("inna@dd.com")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("4455").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
