package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.contact().goTo();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withAddress("ukraine").withAddress2("www").withCompany("test3")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("rrttttyty").withHomepage("ddd").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        Contacts after = app.contact().all();
        assertThat(before.size(), equalTo(after.size() - 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
