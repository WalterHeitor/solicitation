package com.softWalter.solicitation.domain.security;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.repositories.UserRepository;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestSolicitation;
import com.softWalter.solicitation.domain.usecases.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("accessManager")
public class AccessManager {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UseCaseRequestSolicitation useCaseRequestSolicitation;

    public boolean isOwner(Long id) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            RequestSolicitation requestSolicitation = useCaseRequestSolicitation.getById(id);
            return user.getId() == requestSolicitation.getOwner().getId();

        }else {
            throw new NotFoundException("There are not user with email " + email);
        }
    }

    public boolean isRequestOwner(Long id) {

        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getId() == id;

        }else {
            throw new NotFoundException("There are not user with email " + email);
        }
    }
}
