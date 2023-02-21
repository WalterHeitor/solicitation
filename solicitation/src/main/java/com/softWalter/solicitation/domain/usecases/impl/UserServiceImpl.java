package com.softWalter.solicitation.domain.usecases.impl;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.repositories.UserRepository;
import com.softWalter.solicitation.domain.usecases.UseCaseUserService;
import com.softWalter.solicitation.domain.usecases.exception.NotFoundException;
import com.softWalter.solicitation.domain.usecases.model.PageModel;
import com.softWalter.solicitation.domain.usecases.model.PageRequestModel;
import com.softWalter.solicitation.domain.usecases.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return optionalUser.orElseThrow(
                () -> new NotFoundException("There are not user with id " + id));
    }

    @Override
    public List<User> listUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public PageModel<User> listAllOnLaziMode(PageRequestModel pageRequestModel) {
        Pageable pageable =
                PageRequest.of(pageRequestModel.getPage(), pageRequestModel.getSize());
        Page<User> userPage = userRepository.findAll(pageable);
        PageModel<User> userPageModel = new PageModel<>(
                userPage.getTotalElements(),
                userPage.getSize(),
                userPage.getTotalPages(),
                userPage.getContent());
        return userPageModel;
    }

    @Override
    public User login(String email, String password) {

        password = HashUtil.getSecurityHash(password);
        Optional<User> optionalUser = userRepository.login(email, password);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public int updateRole(User user) {
        return userRepository.updateRole(user.getId(), user.getRole());
    }

}
