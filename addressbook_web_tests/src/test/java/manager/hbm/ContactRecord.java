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
    public String first_name ;
    public String last_name;

    @Column(name = "mobile")
    public String phone;

    public ContactRecord(int id, String first_name, String last_name, String phone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
}