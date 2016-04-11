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
            writer.write(String.format("%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(),
                    contact.getAddress(),
                    contact.getCompany()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstname(String.format("test %s", i))
                    .withLastname(String.format("lastname %s", i)).withAddress(String.format("Address %s", i))
                    .withCompany(String.format("Company %s", i)));
        }
        return contacts;
    }

}
