package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().goTo();
        if (app.group().list().size() == 0){
            app.contact().create(new ContactData("test1", "inna23 ", "khomenko", "mio", "ddd", "zp", "ukraine",
                    "www", "323434545454545", "56565656565656", "56565656565656", "fdff@rr.rrr", "rtttrtr@rrr.rttr",
                    "333@rr.rtrt", "trrtrtrt", "545454545", "rrttttyty", "test1"));
            app.contact().goTo();
        }
    }

    @Test
    public void testsContactDeletion() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().select(index);
        app.contact().submit();
        app.contact().delete();
        app.contact().goTo();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before,after);
    }
}

