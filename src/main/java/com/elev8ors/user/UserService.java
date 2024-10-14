package com.elev8ors.user;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long userId);
    void deleteUser(Long userId);
}
