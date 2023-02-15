package com.softWalter.solicitation.domain.usecases;

import com.softWalter.solicitation.domain.entities.User;

import java.util.List;

public interface UseCaseUserService {

    User saveUser(User user);
    User updateUser(User user);
    User getById(Long id);
    List<User> listUsers();
    User login(String email, String password);
}
