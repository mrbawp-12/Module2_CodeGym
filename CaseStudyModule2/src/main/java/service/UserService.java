package service;

import model.User;
import utils.*;
import exception.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class UserService {
    //doc user tu file
    private List<User> readUsersFromFile() throws IOException {
        List<User> users = new ArrayList<>();
        java.io.File file = new java.io.File(File.userFile);
        if (!file.exists()) {
            return users;
        }

        List<String> lines = Files.readAllLines(Paths.get(File.userFile));

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 7) {
                users.add(new User(data[0], data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6])));
            }
        }
        return users;
    }

    //ghi user vao file
    private void writeUsersToFile(List<User> users) throws IOException {
        List<String> lines = new ArrayList<>();
        for (User u : users) {
            lines.add(String.format("%s,%s,%s,%s,%s,%s,%d",
                    u.getUsername(), u.getPassword(), u.getPhoneNumber(),
                    u.getAddress(), u.getEmail(), u.getFullName(), u.getAge()));
        }
        Files.write(Paths.get(File.userFile), lines);
    }

    //dang ky
    public void register(User user) throws InvalidInputException, IOException {
        Validator.validateUsername(user.getUsername());
        Validator.validatePassword(user.getPassword());
        Validator.validatePhoneNumber(user.getPhoneNumber());
        Validator.validateEmail(user.getEmail());
        Validator.validateAge(user.getAge());

        List<User> users = readUsersFromFile();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                throw new InvalidInputException("Tai khoan da ton tai");
            }
        }
        users.add(user);
        writeUsersToFile(users);
    }

    //dang nhap
    public User login(String username, String password) throws NotFoundException, IOException {
        for (User u : readUsersFromFile()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        throw new NotFoundException("Tai khoan hoac mat khau khong dung");
    }
}