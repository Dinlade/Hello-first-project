package tests;

import common.Common;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactRemovalTests extends TestBase {




    @Test
    void removeContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("", "Dinar","Charles","89172351266", "", ""));
        }
        var oldContacts = app.contact().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.contact().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }
    @Test
    public void CanRemoveContactFromGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "gg", "gg", "gg"));
        }
        var groups = app.hbm().getGroupList();
        var maxId = groups.get(groups.size() - 1).id();
        var group = new GroupData().withId(maxId);
        var contactsInGroup = app.hbm().getContactsInGroup(group);
        if (contactsInGroup.isEmpty()) {
            var contact = new ContactData()
                    .withFirstName(Common.randomString(10))
                    .withAddress(Common.randomString(20))
                    .withLastName(Common.randomString(30))
                    .withPhone(Common.randomString(10));
            app.contact().createContactInGroup(contact, group);
        }
        var oldListOfContacts = app.hbm().getContactsInGroup(group);
        var contactForRemove = oldListOfContacts.get(0);
        app.contact().removeContactFromGroup(contactForRemove, group);
        var newListOfContacts = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldListOfContacts.size() - 1, newListOfContacts.size());
    }
}