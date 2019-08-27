package com.myproject.services;

import com.myproject.controllers.request.UserPatch;
import com.myproject.models.User;
import com.myproject.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;


public class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);

    private final UserService userService = new UserService(userRepository);

    @Test
    public void shouldUpdate(){
        //given
        final String id = "id";
        final UserPatch userPatch = UserPatch.builder()
                .firstName("q")
                .lastName("f")
                .build();
        Mockito.when(userRepository.findById(id))
                .thenReturn(Optional.of(User.builder().build()));

        //when
        userService.update(id,userPatch);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        //then
        verify(userRepository).save(userArgumentCaptor.capture());
        User userResult = userArgumentCaptor.getValue();
        Assert.assertEquals(userPatch.getFirstName(),userResult.getFirstName());

    }
}