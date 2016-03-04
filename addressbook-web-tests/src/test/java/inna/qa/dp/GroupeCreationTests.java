package inna.qa.dp;

import org.testng.annotations.Test;


public class GroupeCreationTests extends TestBase{

    @Test
    public void testGroupeCreation() {

        gotoGroupPage();
        initGroupCreation();
        feelGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
