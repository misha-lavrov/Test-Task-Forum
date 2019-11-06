package com.mishalavrov.testtaskforum.repos;

import com.mishalavrov.testtaskforum.domain.Comment;
import com.mishalavrov.testtaskforum.domain.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
    Iterable<Comment> findByTopic(Topic topic);
}
