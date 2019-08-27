package com.myproject.models;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Value
@Builder(toBuilder = true)
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Status status;
}
