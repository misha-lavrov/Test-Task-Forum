package com.mishalavrov.testtaskforum.dto;

import com.mishalavrov.testtaskforum.domain.Topic;
import com.mishalavrov.testtaskforum.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CommentDTO {
    private Long id;
    @NotBlank(message = "The comment can't be empty!")
    private String value;
    private User author;
    private Topic topic;

    public String getAuthorname(){
        return author.getUsername();
    }

    public String getTopicname(){
        return topic.getName();
    }

}
