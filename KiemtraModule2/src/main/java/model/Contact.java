package model;

public class Contact {
    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String email;
    private String dateOfBirth;

    public Contact(){
    }

    public Contact(String phone, String group, String name, String gender, String address, String email, String dateOfBirth) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", phone, group, name, gender);
    }

    public String toCsvString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", phone, group, name, gender, address, email, dateOfBirth);
    }
}
