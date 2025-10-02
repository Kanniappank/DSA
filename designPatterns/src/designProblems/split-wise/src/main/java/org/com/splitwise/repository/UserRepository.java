package org.com.splitwise.repository;

import lombok.Getter;
import lombok.Setter;
import org.com.splitwise.Model.User;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserRepository {
    public static Map<String, User> userHashMap = new HashMap<>();
}
