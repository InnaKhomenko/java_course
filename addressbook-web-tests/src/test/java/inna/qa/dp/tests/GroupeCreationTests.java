package inna.qa.dp.tests;

import inna.qa.dp.model.GroupData;
import inna.qa.dp.model.Groups;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupeCreationTests extends TestBase {

    @Test
    public void testGroupeCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withtName("test3");
        app.group().create(group);
        app.goTo().groupPage();
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
