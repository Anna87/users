package com.myproject.converters;

import com.myproject.controllers.responce.UserDetails;
import com.myproject.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsConverter {

    public UserDetails convert(final User user) {
        return UserDetails.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public List<UserDetails> convertList(final List<User> users) {
        return users.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
