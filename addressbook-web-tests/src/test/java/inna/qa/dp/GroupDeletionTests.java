package inna.qa.dp;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    @Test
    public void TestsGroupDeletion() {

        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }


}
