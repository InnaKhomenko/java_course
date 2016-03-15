package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void TestsGroupDeletion() {

        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupeCount();
        if (! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroupe(new GroupData("test1", null, null));
        }
        app.getGroupHelper().returnToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().gotoGroupPage();
        int after = app.getGroupHelper().getGroupeCount();
        Assert.assertEquals(after, before - 1);
    }


}
