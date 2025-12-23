package tests;

import common.Common;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {


    @Test
    void testPhones() {
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.home(), contact.mobile(), contact.work())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contact().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testEmail() {
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var emails = app.contact().getEmails();
        Assertions.assertEquals(expected, emails);
    }

    @Test
    void testAddress() {
        if (app.hbm().getContactCount() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstName(Common.randomString(10))
                    .withLastName(Common.randomString(10))
                    .withAddress(Common.randomString(10))
                    .withEmail(Common.randomString(10))
                    .withEmail2(Common.randomString(10))
                    .withEmail3(Common.randomString(10)));

        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var address = app.contact().getAddress(contact);
        var expected = contact.address();
        Assertions.assertEquals(expected, address);
    }
}