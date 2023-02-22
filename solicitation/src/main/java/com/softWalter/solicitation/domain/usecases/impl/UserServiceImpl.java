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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UseCaseUserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User getUser(User user) {
        String hash = HashUtil.getSecurityHash(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    @Override
    public User saveUser(User user) {

        return getUser(user);
    }

    @Override
    public User updateUser(User user) {

        return getUser(user);
    }

    @Override
    public User getById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(
                () -> new NotFoundException("There are not user with id " + id));
    }

    @Override
    public List<User> listUsers() {

        return userRepository.findAll();
    }

    @Override
    public PageModel<User> listAllOnLaziMode(PageRequestModel pageRequestModel) {
        Pageable pageable =
                PageRequest.of(pageRequestModel.getPage(), pageRequestModel.getSize());
        Page<User> userPage = userRepository.findAll(pageable);
        return new PageModel<>(
                userPage.getTotalElements(),
                userPage.getSize(),
                userPage.getTotalPages(),
                userPage.getContent());
    }

    @Override
    public User login(String email, String password) {

        password = HashUtil.getSecurityHash(password);
        Optional<User> optionalUser = userRepository.login(email, password);
        return optionalUser.orElseThrow(() -> new NotFoundException("User not present" + email));
    }

    @Override
    public int updateRole(User user) {
        return userRepository.updateRole(user.getId(), user.getRole());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE " + user.getRole().name()));
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    grantedAuthorities
            );
        } else {
            throw new UsernameNotFoundException("Dosen't exist for username " + username);
        }
    }
}
