package model;

public class Contact {
    private String phone;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDate;
    private String email;

    public Contact(String phone, String group, String fullName, String gender,
                   String address, String birthDate, String email) {
        this.phone = phone;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getPhone() { return phone; }
    public String getGroup() { return group; }
    public String getFullName() { return fullName; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getBirthDate() { return birthDate; }
    public String getEmail() { return email; }

    public void setPhone(String phone) { this.phone = phone; }
    public void setGroup(String group) { this.group = group; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setEmail(String email) { this.email = email; }

    // chuyen doi sang dinh dang CSV
    public String toCsvLine() {
        return phone + "," + group + "," + fullName + "," + gender + ","
                + address + "," + birthDate + "," + email;
    }

    @Override
    public String toString() {
        return "SDT: " + phone + " | Nhom: " + group + " | Ho ten: " + fullName
                + " | Gioi tinh: " + gender + " | Dia chi: " + address;
    }
}