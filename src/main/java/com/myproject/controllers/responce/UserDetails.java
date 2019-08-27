package com.myproject.controllers.responce;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDetails {
    private String firstName;
    private String lastName;
}
