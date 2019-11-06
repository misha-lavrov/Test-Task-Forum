package com.mishalavrov.testtaskforum.dto;

import com.mishalavrov.testtaskforum.domain.Subject;
import com.mishalavrov.testtaskforum.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class TopicDTO {
    private Long id;
    @NotBlank(message = "The name can't be empty!")
    private String name;
    private User author;
    private Subject subject;

    public String getAuthorname(){
        return author.getUsername();
    }

    public String getSubjectname(){
        return subject.getName();
    }
}
