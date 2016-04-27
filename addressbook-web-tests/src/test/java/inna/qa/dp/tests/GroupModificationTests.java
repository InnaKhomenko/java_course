package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import inna.qa.dp.model.Groups;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            if (app.group().list().size() == 0) {
                app.group().create(new GroupData().withtName("test1"));
            }
        }
    }

    @Test
    public void testGroupModification() {
        app.goTo().groupPage();
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().
                withId(modifiedGroup.getId()).withtName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }
}
