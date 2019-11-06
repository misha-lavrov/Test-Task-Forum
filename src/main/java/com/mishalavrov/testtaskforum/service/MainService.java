package com.mishalavrov.testtaskforum.service;

import com.mishalavrov.testtaskforum.domain.Comment;
import com.mishalavrov.testtaskforum.domain.Subject;
import com.mishalavrov.testtaskforum.domain.Topic;
import com.mishalavrov.testtaskforum.domain.User;
import com.mishalavrov.testtaskforum.dto.CommentDTO;
import com.mishalavrov.testtaskforum.dto.SubjectDTO;
import com.mishalavrov.testtaskforum.dto.TopicDTO;
import com.mishalavrov.testtaskforum.repos.CommentRepo;
import com.mishalavrov.testtaskforum.repos.SubjectRepo;
import com.mishalavrov.testtaskforum.repos.TopicRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService {
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private CommentRepo commentRepo;

    public Iterable<Subject> getSubjects(){
        return subjectRepo.findAll();
    }

    public Optional<Subject> getSubjectById(Long id){
        return subjectRepo.findById(id);
    }

    public Iterable<Topic> getTopicsBySubject(Subject subject){
        return topicRepo.findBySubject(subject);
    }

    public Optional<Topic> getTopicById(Long id){
        return topicRepo.findById(id);
    }

    public Iterable<Comment> getCommentsByTopic(Topic topic){
        return commentRepo.findByTopic(topic);
    }

    public void saveSubject(SubjectDTO subjectDTO, User user){
        subjectDTO.setId(null);
        subjectDTO.setAuthor(user);
        subjectRepo.save(new ModelMapper().map(subjectDTO, Subject.class));
    }

    public void saveTopic(TopicDTO topicDTO, Long subject_id, User user){
        topicDTO.setId(null);
        topicDTO.setAuthor(user);
        topicDTO.setSubject(getSubjectById(subject_id).get());
        topicRepo.save(new ModelMapper().map(topicDTO, Topic.class));
    }

    public void saveComment(CommentDTO commentDTO, Long topic_id, User user){
        commentDTO.setId(null);
        commentDTO.setAuthor(user);
        commentDTO.setTopic(getTopicById(topic_id).get());
        commentRepo.save(new ModelMapper().map(commentDTO, Comment.class));
    }
}
