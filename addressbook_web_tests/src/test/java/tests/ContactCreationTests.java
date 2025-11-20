package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestBase{

   public static List<ContactData> contactProvider() {
       var result = new ArrayList<ContactData>();
       for (var firstname : List.of("", "first name")) {
           for(var lastname : List.of("", "last name")) {
               for(var phone : List.of("", "89172351266")) {
                   result.add(new ContactData(firstname, lastname, phone));
               }
           }
           for (int i = 0; i < 5; i++) {
               result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));
           }
       }
       return result;
    }


    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int contactCount = app.contact().getCount();
        app.contact().createContact(contact);
        int newGroupCount = app.contact().getCount();
        Assertions.assertEquals(contactCount + 1, newGroupCount);
    }
    public static List<ContactData> negativeContactProvider() {

        var result = new ArrayList<ContactData>(List.of(
                new ContactData("first name '", "", "")));
        return result;
    }
    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateGroup(ContactData contact){
        int contactCount = app.contact().getCount();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}