package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import model.ContactData;

@Entity
@Table (name = "addressbook")
public class ContactRecord {
    @Id
    public int id;
    public String firstname ;
    public String lastname;
    public  String address;

    @Column(name = "mobile")
    public String phone;

    public ContactRecord(int id, String firstname, String lastname, String phone, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
    }
}