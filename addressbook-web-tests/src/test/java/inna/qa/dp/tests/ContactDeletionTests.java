package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().goTo();
        if (app.group().list().size() == 0) {
            app.contact().create(new ContactData().withAddress("ukraine").withAddress2("www").withCompany("test3")
                    .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                    .withHome("rrttttyty").withHomepage("ddd").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                    .withFax("56565656565656").withWork("323434545454545"));
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
        Assert.assertEquals(before, after);
    }
}

