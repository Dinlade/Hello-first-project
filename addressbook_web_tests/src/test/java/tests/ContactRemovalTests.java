package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    void removeContact() {
        if (app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("firstname", "lastname", "89172351266"));
        }
        app.contact().removeContact();
    }

    @Test
    void CanRemoveAllContacts() {
        if (app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("firstname", "lastname", "89172351266"));
        }
        app.contact().removeAllContacts();
        Assertions.assertEquals(0, app.contact().getCount());
    }
}

