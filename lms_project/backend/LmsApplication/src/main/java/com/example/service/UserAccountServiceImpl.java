//package com.example.service;
//
//import com.example.entity.UserAccount;
//import com.example.repository.UserAccountRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserAccountServiceImpl implements UserAccountService {
//
//    private final UserAccountRepository repository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UserAccountServiceImpl(UserAccountRepository repository,
//                                  PasswordEncoder passwordEncoder) {
//        this.repository = repository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public UserAccount createUser(String username, String password,
//                                  String displayName, String role) {
//        UserAccount account = new UserAccount();
//        account.setUsername(username);
//        account.setPassword(passwordEncoder.encode(password));
//        account.setDisplayName(displayName);
//        account.setRole(role);
//        return repository.save(account);
//    }
//
//    @Override
//    public UserAccount updatePassword(Long id, String newPassword) {
//        UserAccount account = getUserById(id);
//        account.setPassword(passwordEncoder.encode(newPassword));
//        return repository.save(account);
//    }
//
//    @Override
//    public UserAccount updateUsername(Long id, String newUsername) {
//        UserAccount account = getUserById(id);
//        account.setUsername(newUsername);
//        return repository.save(account);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public List<UserAccount> getAllUsers() {
//        return repository.findAll();
//    }
//
//    @Override
//    public List<UserAccount> getUsersByRole(String role) {
//        return repository.findByRole(role);
//    }
//
//    @Override
//    public UserAccount getUserById(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
//    @Override
//    public boolean usernameExists(String username) {
//        return repository.existsByUsername(username);
//    }
//}

package com.example.service;

import com.example.entity.UserAccount;
import com.example.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount createUser(String username,
                                  String password,
                                  String displayName,
                                  String role) {

        UserAccount account = new UserAccount();

        account.setUsername(username);

        // plain password for now
        account.setPassword(password);

        account.setDisplayName(displayName);

        account.setRole(role);

        return repository.save(account);
    }

    @Override
    public UserAccount updatePassword(Long id,
                                      String newPassword) {

        UserAccount account = getUserById(id);

        // plain password for now
        account.setPassword(newPassword);

        return repository.save(account);
    }

    @Override
    public UserAccount updateUsername(Long id,
                                      String newUsername) {

        UserAccount account = getUserById(id);

        account.setUsername(newUsername);

        return repository.save(account);
    }

    @Override
    public void deleteUser(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<UserAccount> getAllUsers() {

        return repository.findAll();
    }

    @Override
    public List<UserAccount> getUsersByRole(String role) {

        return repository.findByRole(role);
    }

    @Override
    public UserAccount getUserById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    @Override
    public boolean usernameExists(String username) {

        return repository.existsByUsername(username);
    }
}