package com.softWalter.solicitation.template.user;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.enums.Role;

public class UserMockFacktory {


    public static User createNewUser() {
        return new User(
                null,
                "walter",
                "walter@gmail.com",
                "123",
                Role.END_USER,
                null,
                null
        );
    }
}
