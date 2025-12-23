package model;

public record ContactData(String id,
                          String firstname,
                          String lastname,
                          String photo,
                          String address,
                          String home,
                          String mobile,
                          String work,
                          String email,
                          String email2,
                          String email3) {
    public ContactData() {
        this ("", "", "", "", "", "", "", "", "","" ,"" );
    }

    public ContactData withContactId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.photo,this.address, this.home, this.mobile, this.work,this.email ,this.email2, this.email3);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.lastname, this.photo,this.address, this.home, this.mobile, this.work,this.email ,this.email2, this.email3);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.firstname, last_name, this.photo,this.address, this.home, this.mobile, this.work, this.email ,this.email2, this.email3);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.lastname, photo, this.address, this.home, this.mobile, this.work, this.email ,this.email2, this.email3 );
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, this.home, this.mobile, this.work, this.email ,this.email2, this.email3 );
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, home, this.mobile, this.work, this.email ,this.email2, this.email3);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, this.home, mobile, this.work, this.email ,this.email2, this.email3 );
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, this.home, this.mobile, work, this.email ,this.email2, this.email3);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, this.home, this.mobile, work, email ,this.email2, this.email3);
    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, this.home, this.mobile, work, this.email ,email2, this.email3);
    }
    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.lastname, this.photo, address, this.home, this.mobile, work, this.email ,this.email2, email3);
    }
}