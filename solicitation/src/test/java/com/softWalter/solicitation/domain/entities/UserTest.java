package com.softWalter.solicitation.domain.entities;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.FieldPredicate;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testPojos() {
        //given
        final Class<User> user = User.class;
        //when
     Assertions.assertPojoMethodsFor(user)
             .testing(Method.SETTER)
             .areWellImplemented();

    }
}