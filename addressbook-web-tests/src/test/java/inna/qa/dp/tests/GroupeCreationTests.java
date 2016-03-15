package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase {

    @Test
    public void testGroupeCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupeCount();
        app.getGroupHelper().createGroupe(new GroupData("test1", null, null));
        app.getNavigationHelper().gotoGroupPage();
        int after = app.getGroupHelper().getGroupeCount();
        Assert.assertEquals(after, before + 1);

    }

}
