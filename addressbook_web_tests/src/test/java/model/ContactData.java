package model;

public record ContactData(String id, String firstname, String lastname, String phone, String photo, String address) {
    public ContactData() {
        this ("", "", "", "", "", "");
    }

    public ContactData withContactId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.phone, this.photo,this.address);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.lastname, this.phone, this.photo,this.address);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.firstname, last_name, this.phone, this.photo,this.address);
    }

    public ContactData withPhone(String phone) {
        return new ContactData(this.id, this.firstname, this.lastname, phone, this.photo,this.address);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, photo, this.address);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.phone, this.photo, address);
    }
}