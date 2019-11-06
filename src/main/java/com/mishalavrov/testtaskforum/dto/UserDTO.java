package com.mishalavrov.testtaskforum.dto;

import com.mishalavrov.testtaskforum.domain.Authority;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter @Setter
public class UserDTO {
    private Long id;
    @NotBlank(message = "The name can't be empty!")
    private String username;
    @NotBlank(message = "The password can't be empty!")
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Set<Authority> authorities;
}
