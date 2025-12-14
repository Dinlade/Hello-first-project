package tests;

import common.Common;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class ContactCreationTests extends TestBase{


    public static List<ContactData> contactProvider() throws IOException {
      var result = new ArrayList<ContactData>();
//        for (var firstname : List.of("", "first name")) {
//            for (var lastname : List.of("", "last name")) {
//                for (var phone : List.of("", "phone")) {
//                    result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withPhone(phone));
//                }
//            }
//        }
        var json = "";
        try (var reader = new FileReader("contacts.json");
             var breader = new BufferedReader(reader)
        ) {
            var line = breader.readLine();
            while(line != null) {
                json = json + line;
                line = breader.readLine();
            }
        }
       // var json = Files.readString(Paths.get("contacts.json"));
        ObjectMapper mapper = new ObjectMapper();

        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {});
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withContactId(newContacts.get(newContacts.size()-1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }

    @Test
    void canCreateContact() {
        var contact = new ContactData()
                .withFirstName(Common.randomString(10))
                .withLastName(Common.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contact().createContact(contact);
    }


    @Test
    void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstName(Common.randomString(10))
                .withLastName(Common.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "name", "header", "footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contact().create(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

    @Test
    public void CanAddContactToGroup() {
        if (!app.hbm().getContactList().isEmpty()) {
            app.contact().removeAllContacts();
        }
        app.hbm().getContactList();

        app.contact().createContact(new ContactData()
                .withFirstName(Common.randomString(10))
                .withLastName(Common.randomString(10))
                .withAddress(Common.randomString(10))
                .withPhone(Common.randomString(10)));

        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "name", "header", "footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var contacts = app.hbm().getContactList();
        var oldRelated = app.hbm().getContactsInGroup(group);
        var contact = contacts.get(0);
        app.contact().addContactToGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }
}

