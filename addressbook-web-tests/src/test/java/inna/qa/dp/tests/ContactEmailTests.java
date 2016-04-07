package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase{
    @Test
    public void testContactPhones(){
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).
                stream().filter((s) -> ! s.equals("")).map(ContactEmailTests::cleaned).
                collect(Collectors.joining("\n"));
    }

    public static String cleaned(String contact) {
        return contact.replaceAll("\\s+", "").replaceAll("\n", " ");
    }
}
