package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;


public class GroupeCreationTests extends TestBase {

    @Test
    public void testGroupeCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", null, null);
        app.getGroupHelper().createGroupe(group);
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        int max = 0;
        for (GroupData g : after){
            if (g.getId() > max){
                max = g.getId();
            }
        }
        group.setId(max);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
