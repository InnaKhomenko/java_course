package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().goTo();
        if (app.group().list().size() == 0) {
            app.contact().create(new ContactData().withAddress("ukraine").withAddress2("www").withCompany("test3")
                    .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                    .withHome("rrttttyty").withHomepage("ddd").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                    .withFax("56565656565656").withWork("323434545454545"));
            app.contact().goTo();
        }
    }

    @Test
    public void testContactModification() {

        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withAddress("ukraine").withAddress2("www").withCompany("test3")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("rrttttyty").withHomepage("ddd").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().selectModificated(contact);
        app.contact().modifyContact(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
