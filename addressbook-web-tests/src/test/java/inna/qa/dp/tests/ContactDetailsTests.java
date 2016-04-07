package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {
    @Test
    public void testContactDetails() {
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        app.contact().mergePhones(contactInfoFromEditForm);
        app.contact().mergeEmails(contactInfoFromEditForm);
        ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsForm(contact);

        assertThat(mergeContent(contactInfoFromEditForm), equalTo(cleaned(contactInfoFromDetailsPage.getAllContent())));
    }

    private String mergeContent(ContactData contact) {
        return Arrays.asList(contact.getFirstname(),contact.getMiddlename(), contact.getLastname(), contact.getCompany(),
                contact.getAddress(), contact.getAllPhones(), contact.getAllEmails()).
                stream().map(ContactEmailTests::cleaned).
                collect(Collectors.joining());
    }

    public static String cleaned(String contact) {
        return contact.replaceAll("\\s+", "").replaceAll("\n", " ");
    }
}
