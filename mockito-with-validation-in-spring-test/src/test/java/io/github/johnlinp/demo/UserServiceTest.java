package io.github.johnlinp.demo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserServiceTest.TestConfig.class)
public class UserServiceTest
{
    @Configuration
    public static class TestConfig
    {
        @Bean
        public UserService userService ()
        {
            return mock(UserService.class);
        }

        @Bean
        public MethodValidationPostProcessor methodValidationPostProcessor ()
        {
            return new MethodValidationPostProcessor();
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void createUserWithValidEmail ()
    {
        userService.createUser("aaa@example.com");
    }

    @Test
    public void createUserWithInvalidEmail ()
    {
        assertThatThrownBy(() -> userService.createUser("aaa"))
            .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    public void refreshUsersCalled1 ()
    {
        userService.refreshUsers();
        verify(userService).refreshUsers();
    }

    @Test
    public void refreshUsersCalled2 ()
    {
        userService.refreshUsers();
        verify(userService).refreshUsers();
    }
}
