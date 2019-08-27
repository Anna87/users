package com.myproject.services;

import com.myproject.controllers.request.UserCreateRequest;
import com.myproject.controllers.request.UserPatch;
import com.myproject.exceptions.NotFoundException;
import com.myproject.models.Status;
import com.myproject.models.User;
import com.myproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User create(final UserCreateRequest userCreateRequest) {
        return userRepository.save(User.builder()
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .status(Status.ACTIVE)
                .build());
    }

    public void update(final String id, final UserPatch userPatch) {
        final User user = findExistingUserById(id);
        final User updatedUser = user.toBuilder()
                .lastName(userPatch.getLastName())
                .firstName(userPatch.getFirstName())
                .build();

        userRepository.save(updatedUser);
    }

    public void delete(final String id) {
        //TODO findById, change status obsolete
        final User user = findExistingUserById(id);

        userRepository.save(user.toBuilder()
                .status(Status.OBSOLETE).build()
        );
    }

    public User findExistingUserById(final String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
