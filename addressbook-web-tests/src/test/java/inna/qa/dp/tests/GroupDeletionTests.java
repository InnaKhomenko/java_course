package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void TestsGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroupe(new GroupData("test1", null, null));
        }
        app.getGroupHelper().returnToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().gotoGroupPage();
    }


}
