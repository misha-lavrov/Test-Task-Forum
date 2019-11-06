package com.mishalavrov.testtaskforum.repos;

import com.mishalavrov.testtaskforum.domain.Subject;
import com.mishalavrov.testtaskforum.domain.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Long> {
    Iterable<Topic> findBySubject(Subject subject);
}
