package utils;

import exception.InvalidInputException;

public class Validator {
    public static void validateUsername(String username) throws InvalidInputException {
        if (username == null || username.length() < 8 || username.length() > 16) {
            throw new InvalidInputException("Tai khoan phai tu 8 den 16 ky tu");
        }
    }

    public static void validatePassword(String password) throws InvalidInputException {
        if (password == null || password.length() < 8 || password.length() > 16) {
            throw new InvalidInputException("Mat khau phai tu 8 den 16 ky tu");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws InvalidInputException {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new InvalidInputException("So dien thoai phai co 10 chu so");
        }
    }

    public static void validateEmail(String email) throws InvalidInputException {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new InvalidInputException("Email khong hop le");
        }
    }

    public static void validateAge(int age) throws InvalidInputException {
        if (age < 18) {
            throw new InvalidInputException("Tuoi phai lon hon 18!");
        }
    }
}