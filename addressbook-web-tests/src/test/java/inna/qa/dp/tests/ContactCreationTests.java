package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.contact().goTo();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withAddress("ukraine").withAddress2("www").withCompany("test3")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("rrttttyty").withHomepage("ddd").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size() - 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
