package inna.qa.dp;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testsContactDeletion() {
        goToContactsPage();
        selectContact();
        deleteSelectedContact();
    }

}

