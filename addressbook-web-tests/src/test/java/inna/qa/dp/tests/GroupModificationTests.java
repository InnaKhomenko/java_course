package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroupe(new GroupData("test1", null, null));
        }
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().feelGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
