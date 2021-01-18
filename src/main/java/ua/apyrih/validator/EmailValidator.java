package ua.apyrih.validator;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {

    public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    @Override
    public boolean test(String s) {
        Pattern pattern = Pattern.compile(EMAIL_VALIDATION_REGEX);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
