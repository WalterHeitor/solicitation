package com.softWalter.solicitation.domain.usecases;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.usecases.model.PageModel;
import com.softWalter.solicitation.domain.usecases.model.PageRequestModel;

import java.util.List;

public interface UseCaseUserService {

    User saveUser(User user);
    User updateUser(User user);
    User getById(Long id);
    List<User> listUsers();
    PageModel<User> listAllOnLaziMode(PageRequestModel pageRequestModel);
    User login(String email, String password);
    int updateRole(User user);
}
