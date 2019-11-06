package com.mishalavrov.testtaskforum.repos;

import com.mishalavrov.testtaskforum.domain.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends CrudRepository<Subject, Long> {
    @Override
    Optional<Subject> findById(Long id);
}
