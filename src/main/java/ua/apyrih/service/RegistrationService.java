package ua.apyrih.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.apyrih.controller.request.RegistrationRequest;
import ua.apyrih.domain.User;
import ua.apyrih.domain.UserRole;
import ua.apyrih.validator.EmailValidator;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        return userService.signUpUser(
                new User(
                    request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
