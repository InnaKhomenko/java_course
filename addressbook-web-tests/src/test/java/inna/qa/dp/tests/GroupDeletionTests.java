package inna.qa.dp.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void TestsGroupDeletion() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}
