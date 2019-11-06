package com.mishalavrov.testtaskforum.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
