package com.example.springauthorization.repositories;

import com.example.springauthorization.enums.Authorities;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    final private Map<String, String> passwords = Map.of("user1", "password1", "user2", "password2");
    final private Map<String, List<Authorities>> authorities =
            Map.of("user1", List.of(Authorities.READ), "user2", List.of(Authorities.READ, Authorities.DELETE, Authorities.WRITE));
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (passwords.get(user) != null) {
            if (password.equals(passwords.get(user))) {
                return authorities.get(user);
            }
        }
        return Collections.emptyList();
    }

}
