package com.gamingroom.gameauth.auth;

import java.security.Principal;
import java.util.Set;

public class GameUser implements Principal {
    private final String name;
    private final int id;
    private final Set<String> roles;

    // Constructor with id and roles
    public GameUser(String name, int id, Set<String> roles) {
        this.name = name;
        this.id = id;
        this.roles = roles;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
