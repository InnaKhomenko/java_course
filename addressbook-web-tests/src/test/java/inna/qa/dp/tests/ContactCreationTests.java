package inna.qa.dp.tests;

import inna.qa.dp.model.ContactData;
import inna.qa.dp.model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/zacat.jpg");
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[] {new ContactData().withAddress(split[0]).withCompany(split[1]).withEmail1(split[2])
                    .withEmail2(split[3]).withEmail3(split[4]).withFax(split[5]).withFirstname(split[6])
                    .withPhoto(photo).withHome(split[7]).withLastname(split[8]).withMobile(split[9]).withName(split[10])
                    .withFax(split[11]).withWork(split[12])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testsContactCreation(ContactData contact) {
        app.contact().goTo();
        Contacts before = app.contact().all();
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testsBadContactCreation() {
        app.contact().goTo();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withAddress("ukraine'").withCompany("test3").withEmail1("inna@dd.com")
                .withEmail2("333@rr.rtrt").withEmail3("rtttrtr@rrr.rttr").withFax("trrtrtrt").withFirstname("inna23").withGroup("mio")
                .withHome("4455").withLastname("khomenko").withMobile("56565656565656").withName("zp")
                .withFax("56565656565656").withWork("323434545454545");
        app.contact().addNew();
        app.contact().addInfo(contact);
        app.contact().inputContact();
        app.contact().goTo();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

}
