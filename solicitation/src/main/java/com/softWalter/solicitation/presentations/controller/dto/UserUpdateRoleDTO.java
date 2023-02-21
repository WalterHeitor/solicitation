package com.softWalter.solicitation.presentations.controller.dto;

import com.softWalter.solicitation.domain.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateRoleDTO {
    private Role role;
}
