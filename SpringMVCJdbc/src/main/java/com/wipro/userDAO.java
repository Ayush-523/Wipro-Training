package com.wipro;

import java.util.List;

public interface userDAO {

    void saveUser(UserModel user);

    List<UserModel> getUsers();

    UserModel getUserById(int id);

    void updateUser(UserModel user);

    void deleteUser(int id);
}