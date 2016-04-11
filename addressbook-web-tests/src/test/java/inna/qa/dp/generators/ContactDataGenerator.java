package inna.qa.dp.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import inna.qa.dp.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c2", description = "Contact count")
    public int count;

    @Parameter(names = "-f2", description = "Target file")
    public String file;

    public static void main(String args[]) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                    contact.getAddress(),
                    contact.getCompany(),
                    contact.getEmail1(),
                    contact.getEmail2(),
                    contact.getEmail3(),
                    contact.getFax(),
                    contact.getFirstname(),
                    contact.getHome(),
                    contact.getLastname(),
                    contact.getMobile(),
                    contact.getName(),
                    contact.getFax(),
                    contact.getWork()
            ));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        File photo = new File("src/test/resources/zacat.jpg");
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withAddress(String.format("ukraine %s", i))
                    .withCompany(String.format("test3 %s", i))
                    .withEmail1(String.format("%sinna@gmail.com", i)).withEmail2(String.format("%s333@mail.ru", i))
                    .withEmail3(String.format("%srtttrtr@yopmail.com", i))
                    .withFax(String.format("trrtrtrt %s", i)).withFirstname(String.format("inna23 %s", i))
                    .withPhoto(photo)
                    .withHome(String.format("44225 %s", i)).withLastname(String.format("khomenko %s", i))
                    .withMobile(String.format("56565656565656 %s", i)).withName(String.format("zp %s", i))
                    .withFax(String.format("56565656565656 %s", i)).withWork(String.format("323434545454545 %s", i)));
        }
        return contacts;
    }
}
