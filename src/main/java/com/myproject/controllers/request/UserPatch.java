package com.myproject.controllers.request;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Builder
@Value
public class UserPatch {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
