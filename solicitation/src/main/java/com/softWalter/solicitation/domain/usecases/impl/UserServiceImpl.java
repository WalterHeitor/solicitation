package com.softWalter.solicitation.domain.usecases.impl;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.repositories.UserRepository;
import com.softWalter.solicitation.domain.usecases.UseCaseUserService;
import com.softWalter.solicitation.domain.usecases.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UseCaseUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        String hash = HashUtil.getSecurityHash(user.getPassword());
        user.setPassword(hash);
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User updateUser(User user) {

        String hash = HashUtil.getSecurityHash(user.getPassword());
        user.setPassword(hash);
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public User getById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public List<User> listUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User login(String email, String password) {

        password = HashUtil.getSecurityHash(password);
        Optional<User> optionalUser = userRepository.login(email, password);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

}
