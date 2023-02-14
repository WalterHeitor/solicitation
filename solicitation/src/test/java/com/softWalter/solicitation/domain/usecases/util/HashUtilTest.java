package com.softWalter.solicitation.domain.usecases.util;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class HashUtilTest {

    @Test
    void getSecurityHash() {
        String hash = HashUtil.getSecurityHash("123456");
        System.out.println(hash);
        assertThat(hash.length()).isEqualTo(64);
    }
}