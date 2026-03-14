package service;

import model.User;

import java.util.List;

public class UserManager implements IManager<User> {

    public void register(User user) {

    }

    public boolean login(User user) {
        return false;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public List getAll() {
        return List.of();
    }
}
