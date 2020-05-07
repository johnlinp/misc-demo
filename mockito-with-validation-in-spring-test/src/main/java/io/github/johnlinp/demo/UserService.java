package io.github.johnlinp.demo;

import javax.validation.constraints.Email;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public interface UserService
{
    void createUser (@Email String userEmail);

    void refreshUsers ();
}
