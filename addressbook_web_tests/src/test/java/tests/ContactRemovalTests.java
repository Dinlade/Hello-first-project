package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {




    @Test
    void removeContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("", "Dinar", "Charles", "", "", "", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canRemoveContactFromGroup() {
        var groups = app.hbm().getGroupList();
        if (groups.isEmpty()) {
            app.hbm().createGroup(new GroupData("", "Group", "header", "footer"));
            groups = app.hbm().getGroupList();
        }
        var group = groups.get(0);

        var contactsInGroup = app.hbm().getContactsInGroup(group);
        if (contactsInGroup.isEmpty()) {
            var contact = new ContactData()
                    .withFirstName("Test")
                    .withLastName("Group Group");

            app.contact().createContact(contact);
            app.contact().addContactToGroup(contact, group);

            contactsInGroup = app.hbm().getContactsInGroup(group);
        }

        var contactToRemove = contactsInGroup.get(0);
        var oldContacts = contactsInGroup;

        app.contact().removeContactFromGroup(contactToRemove, group);

        var newContacts = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldContacts.size() - 1, newContacts.size());
    }
}