package inna.qa.dp.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testsContactDeletion() {
        app.goToContactsPage();
        app.selectContact();
        app.getGroupHelper().deleteSelectedContact();
    }

}

