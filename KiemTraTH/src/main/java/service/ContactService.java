package service;

import model.Contact;
import database.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactService {

    private List<Contact> contactList;
    private Scanner sc;

    public ContactService(List<Contact> contactList, Scanner sc) {
        this.contactList = contactList;
        this.sc = sc;
    }

    // hien thi danh sach, 5 muc mot lan, nhan enter de xem tiep
    public void showAll() {
        if (contactList.isEmpty()) {
            System.out.println("Danh ba trong.");
            return;
        }

        int i = 0;
        while (i < contactList.size()) {
            System.out.println("-------------------------------");
            for (int j = 0; j < 5 && i < contactList.size(); j++, i++) {
                Contact c = contactList.get(i);
                System.out.println((i + 1) + ". " + c.toString());
            }

            if (i < contactList.size()) {
                System.out.print("Nhan Enter de xem tiep...");
                sc.nextLine();
            }
        }
        System.out.println("-------------------------------");
    }

    // them moi mot danh ba
    public void addContact() {
        System.out.println("---- THEM MOI DANH BA ----");

        String phone = inputPhone(null);
        if (phone == null) return;

        // kiem tra so dien thoai da ton tai chua
        if (findByPhone(phone) != null) {
            System.out.println("So dien thoai nay da ton tai trong danh ba.");
            return;
        }

        String group = inputRequiredField("Nhom: ");
        String fullName = inputRequiredField("Ho ten: ");
        String gender = inputRequiredField("Gioi tinh: ");
        String address = inputRequiredField("Dia chi: ");
        String birthDate = inputRequiredField("Ngay sinh: ");
        String email = inputEmail();

        Contact c = new Contact(phone, group, fullName, gender, address, birthDate, email);
        contactList.add(c);
        System.out.println("Them moi thanh cong!");
    }

    // cap nhat thong tin danh ba theo so dien thoai
    public void updateContact() {
        System.out.println("---- CAP NHAT DANH BA ----");

        while (true) {
            System.out.print("Nhap so dien thoai can cap nhat (Enter de thoat): ");
            String phone = sc.nextLine().trim();

            if (phone.isEmpty()) return;

            Contact c = findByPhone(phone);
            if (c == null) {
                System.out.println("Khong tim duoc danh ba voi so dien thoai tren.");
                System.out.println("Vui long nhap lai.");
                continue;
            }

            // nhap thong tin moi
            System.out.println("Nhap thong tin moi (Enter de giu nguyen):");

            String group = inputOptionalField("Nhom [" + c.getGroup() + "]: ");
            if (!group.isEmpty()) c.setGroup(group);

            String fullName = inputOptionalField("Ho ten [" + c.getFullName() + "]: ");
            if (!fullName.isEmpty()) c.setFullName(fullName);

            String gender = inputOptionalField("Gioi tinh [" + c.getGender() + "]: ");
            if (!gender.isEmpty()) c.setGender(gender);

            String address = inputOptionalField("Dia chi [" + c.getAddress() + "]: ");
            if (!address.isEmpty()) c.setAddress(address);

            String birthDate = inputOptionalField("Ngay sinh [" + c.getBirthDate() + "]: ");
            if (!birthDate.isEmpty()) c.setBirthDate(birthDate);

            String newEmail = inputOptionalEmail("Email [" + c.getEmail() + "]: ", c.getEmail());
            c.setEmail(newEmail);

            System.out.println("Cap nhat thanh cong!");
            return;
        }
    }

    // xoa danh ba theo so dien thoai
    public void deleteContact() {
        System.out.println("---- XOA DANH BA ----");

        while (true) {
            System.out.print("Nhap so dien thoai can xoa (Enter de thoat): ");
            String phone = sc.nextLine().trim();

            if (phone.isEmpty()) return;

            Contact c = findByPhone(phone);
            if (c == null) {
                System.out.println("Khong tim duoc danh ba voi so dien thoai tren.");
                System.out.println("Vui long nhap lai.");
                continue;
            }

            System.out.println("Thong tin danh ba: " + c.toString());
            System.out.print("Ban co chac muon xoa khong? (Y de xac nhan): ");
            String confirm = sc.nextLine().trim();

            if (confirm.equalsIgnoreCase("Y")) {
                contactList.remove(c);
                System.out.println("Da xoa danh ba thanh cong.");
            } else {
                System.out.println("Da huy xoa, quay ve Menu.");
            }
            return;
        }
    }

    // tim kiem theo so dien thoai hoac ho ten (tim gan dung)
    public void search() {
        System.out.println("---- TIM KIEM DANH BA ----");
        System.out.print("Nhap so dien thoai hoac ho ten can tim: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("Vui long nhap tu khoa tim kiem.");
            return;
        }

        List<Contact> results = new ArrayList<>();
        for (Contact c : contactList) {
            if (c.getPhone().contains(keyword)
                    || c.getFullName().toLowerCase().contains(keyword)) {
                results.add(c);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Khong tim thay danh ba nao phu hop.");
        } else {
            System.out.println("Ket qua tim kiem (" + results.size() + " ket qua):");
            System.out.println("-------------------------------");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i).toString());
            }
            System.out.println("-------------------------------");
        }
    }

    // lay danh sach hien tai
    public List<Contact> getContactList() {
        return contactList;
    }

    // set lai danh sach (dung khi doc tu file)
    public void setContactList(List<Contact> list) {
        this.contactList = list;
    }

    // tim kiem chinh xac theo so dien thoai
    private Contact findByPhone(String phone) {
        for (Contact c : contactList) {
            if (c.getPhone().equals(phone)) return c;
        }
        return null;
    }

    // nhap so dien thoai, co kiem tra dinh dang
    private String inputPhone(String existingPhone) {
        while (true) {
            System.out.print("So dien thoai: ");
            String val = sc.nextLine().trim();

            if (val.isEmpty() && existingPhone != null) return existingPhone;
            if (val.isEmpty()) {
                System.out.println("So dien thoai khong duoc de trong.");
                continue;
            }
            if (!Validator.isValidPhone(val)) {
                System.out.println("So dien thoai khong hop le (chi chua so, 10-11 ky tu).");
                continue;
            }
            return val;
        }
    }

    // nhap truong bat buoc
    private String inputRequiredField(String label) {
        while (true) {
            System.out.print(label);
            String val = sc.nextLine().trim();
            if (Validator.isNotEmpty(val)) return val;
            System.out.println("Truong nay khong duoc de trong.");
        }
    }

    // nhap truong khong bat buoc khi cap nhat
    private String inputOptionalField(String label) {
        System.out.print(label);
        return sc.nextLine().trim();
    }

    // nhap email co kiem tra dinh dang
    private String inputEmail() {
        while (true) {
            System.out.print("Email: ");
            String val = sc.nextLine().trim();
            if (val.isEmpty()) {
                System.out.println("Email khong duoc de trong.");
                continue;
            }
            if (!Validator.isValidEmail(val)) {
                System.out.println("Email khong dung dinh dang.");
                continue;
            }
            return val;
        }
    }

    // nhap email khi cap nhat, neu bo trong thi giu nguyen
    private String inputOptionalEmail(String label, String currentEmail) {
        while (true) {
            System.out.print(label);
            String val = sc.nextLine().trim();
            if (val.isEmpty()) return currentEmail;
            if (!Validator.isValidEmail(val)) {
                System.out.println("Email khong dung dinh dang. Vui long nhap lai.");
                continue;
            }
            return val;
        }
    }
}