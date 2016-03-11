package inna.qa.dp.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testsContactDeletion() {
        app.getContactHelper().goToContactsPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactModification();
        app.getContactHelper().deleteSelectedContact();
    }

}

