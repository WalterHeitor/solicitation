package com.softWalter.solicitation.domain.security;

import com.softWalter.solicitation.domain.usecases.util.HashUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return HashUtil.getSecurityHash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String hash = HashUtil.getSecurityHash(rawPassword.toString());
        return hash.equals(encodedPassword);
    }
}
