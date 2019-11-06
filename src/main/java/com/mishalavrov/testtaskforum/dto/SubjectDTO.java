package com.mishalavrov.testtaskforum.dto;

import com.mishalavrov.testtaskforum.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class SubjectDTO {
    private Long id;
    @NotBlank(message = "The name can't be empty!")
    private String name;
    private User author;

    public String getAuthorname(){
        return author.getUsername();
    }
}
