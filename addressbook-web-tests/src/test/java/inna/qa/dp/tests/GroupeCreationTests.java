package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase {

    @Test
    public void testGroupeCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroupe(new GroupData("test1", null, null));
        app.getNavigationHelper().gotoGroupPage();
    }

}
