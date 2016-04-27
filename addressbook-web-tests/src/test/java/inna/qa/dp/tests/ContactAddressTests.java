package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @BeforeMethod(enabled = false)
    public void ensurePreconditions() {
        app.contact().goTo();
        if (app.group().list().size() == 0) {
            app.contact().create(new ContactData().withEmail1("inna@dd.com")
                    .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFirstname("inna23")
                    .withHome("4455").withLastname("khomenko").withMobile("56565656565656").withWork("323434545454545"));
            app.contact().goTo();
        }
    }

    @Test
    public void testContactData() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress()).
                stream().filter((s) -> !s.equals("")).map(ContactAddressTests::cleaned).
                collect(Collectors.joining("\n"));
    }

    public static String cleaned(String address) {
        return address.replaceAll("\\s+","").replaceAll("\n", "");
    }
}
