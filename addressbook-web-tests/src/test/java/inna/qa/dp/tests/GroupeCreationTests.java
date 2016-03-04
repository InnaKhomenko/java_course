package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase {

    @Test
    public void testGroupeCreation() {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.feelGroupForm(new GroupData("test1", "test2", "test3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
