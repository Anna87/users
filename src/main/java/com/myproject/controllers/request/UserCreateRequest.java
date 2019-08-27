package com.myproject.controllers.request;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Builder
public class UserCreateRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

}
