package com.myproject.controllers;

import com.myproject.controllers.request.UserCreateRequest;
import com.myproject.controllers.request.UserPatch;
import com.myproject.controllers.responce.UserDetails;
import com.myproject.converters.UserDetailsConverter;
import com.myproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserDetailsConverter userDetailsConverter;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDetails> getAll() {
        return userDetailsConverter.convertList(userService.getAll());
    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.OK)
    public UserDetails create(@Valid @RequestBody final UserCreateRequest userCreateRequest) {
        return userDetailsConverter.convert(userService.create(userCreateRequest));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{id}/edit")
    public void update(@NotBlank @PathVariable("id") final String id, @Valid @RequestBody final UserPatch userPatch) {
        userService.update(id, userPatch);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public UserDetails getById(@NotBlank @PathVariable("id") final String id) {
        return userDetailsConverter.convert(userService.findExistingUserById(id));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}/delete")
    public void delete(@NotBlank @PathVariable("id") final String id) {
        userService.delete(id);
    }
}
