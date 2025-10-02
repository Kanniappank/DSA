package org.com.splitwise.Model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private String name;
    private String userId;
    private String email;
    private String phoneNumber;

    public User(@NonNull String email, String name, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}