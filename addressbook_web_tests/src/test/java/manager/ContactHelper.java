package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void getContactWithAGroup(ContactData contact, GroupData group) {
        openContactPage();
        var oldContacts = manager.hbm().getContactList();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
        var newContacts = manager.hbm().getContactList();
        newContacts.removeAll(oldContacts);
        selectContact(newContacts.get(0));
        selectGroupAtHomePage(group);
    }


    private void selectGroupAtHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
        click(By.name("add"));
    }

    public void removeAllContacts() {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        selectAllContacts();
        removeSelectedContact();
    }

    private void selectAllContacts() {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    private void addToGroup() {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        click(By.name("add"));
    }

    private void selectGroupForContact(GroupData group) {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());

    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    private void selectGroup(GroupData group) {
      new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }


    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContactEdit(contact);
        fillContactForm(modifiedContact);
        submitContactEdit();
        returnToHomePage();
    }

    private void selectContactEdit(ContactData contact) {
        click(By.cssSelector(String.format("a[href^='edit.php?id=%s']", contact.id())));
    }

    public void submitContactEdit() {
        click(By.name("update"));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("mobile"), contact.phone());
        type(By.name("address"), contact.address());
    }

    private void openHomePage() {
        if (!manager.isElementPresent((By.name("new")))) {
            click(By.linkText("home"));
        }
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCountContact() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        click(By.name("delete"));
    }

    private void openContactPage() {
        if (!manager.isElementPresent((By.name("nickname")))) {
            click(By.linkText("add new"));
        }
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.name("entry"));
        for (var td : tds) {
            var tdFirstName = td.findElement(By.cssSelector("td:nth-child(3)")).getText();
            var tdLastName = td.findElement(By.cssSelector("td:nth-child(2)")).getText();
            var tdPhone = td.findElement(By.cssSelector("td:nth-child(6)")).getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withContactId(id).withFirstName(tdFirstName).withLastName(tdLastName).withPhone(tdPhone));
        }
        return contacts;
    }

    public void createContactInGroup(ContactData contact, GroupData group) {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        selectContact(contact);
        selectGroupForContact(group);
        addToGroup();
    }

    private void selectContactGroup(GroupData group) {
        WebDriverWait wait = new WebDriverWait(manager.driver, Duration.ofSeconds(10));
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void removeSelectedContactFromGroup() {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        click(By.xpath("//input[@name=\'remove\']"));
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        manager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        openHomePage();
        selectContactGroup(group);
        selectContact(contact);
        removeSelectedContactFromGroup();
        returnToHomePage();
    }
}