package com.mishalavrov.testtaskforum.controller;

import com.mishalavrov.testtaskforum.domain.Comment;
import com.mishalavrov.testtaskforum.domain.Subject;
import com.mishalavrov.testtaskforum.domain.Topic;
import com.mishalavrov.testtaskforum.domain.User;
import com.mishalavrov.testtaskforum.dto.CommentDTO;
import com.mishalavrov.testtaskforum.dto.SubjectDTO;
import com.mishalavrov.testtaskforum.dto.TopicDTO;
import com.mishalavrov.testtaskforum.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String mainPage(){
        return "login";
    }

    @GetMapping("/subject")
    public String subjectPage(Model model){
        model.addAttribute("subjects", mainService.getSubjects());
        return "subject";
    }

    @PostMapping("/subject")
    public String addNewSubject(
            @AuthenticationPrincipal User user,
            @Valid SubjectDTO subjectDTO,
            BindingResult result,
            Model model
    ){
        if(!result.hasErrors()){
            mainService.saveSubject(subjectDTO, user);
        }
        model.addAttribute("subjects", mainService.getSubjects());
        return "subject";
    }

    @GetMapping("/topic")
    public String topicPage(
            @RequestParam Long subject_id,
            Model model
    ){
        model.addAttribute("subject", mainService.getSubjectById(subject_id).get());
        model.addAttribute("topics", mainService.getTopicsBySubject(mainService.getSubjectById(subject_id).get()));
        return "topic";
    }

    @PostMapping("/topic")
    public String addNewTopic(
            @AuthenticationPrincipal User user,
            @RequestParam Long id,
            @Valid TopicDTO topicDTO,
            BindingResult result,
            Model model
    ){
        if(!result.hasErrors()){
            mainService.saveTopic(topicDTO, id, user);
        }
        model.addAttribute("subject", mainService.getSubjectById(id).get());
        model.addAttribute("topics", mainService.getTopicsBySubject(mainService.getSubjectById(id).get()));
        return "/topic";
    }

    @GetMapping("/comment")
    public String commentPage(
            @RequestParam Long topic_id,
            Model model
    ){
        model.addAttribute("topic", mainService.getTopicById(topic_id).get());
        model.addAttribute("comments", mainService.getCommentsByTopic(mainService.getTopicById(topic_id).get()));
        return "/comment";
    }

    @PostMapping("/comment")
    public String addNewComment(
            @AuthenticationPrincipal User user,
            @RequestParam Long id,
            @Valid CommentDTO commentDTO,
            BindingResult result,
            Model model
    ){
        if(!result.hasErrors()){
            mainService.saveComment(commentDTO, id, user);
        }
        model.addAttribute("topic", mainService.getTopicById(id).get());
        model.addAttribute("comments", mainService.getCommentsByTopic(mainService.getTopicById(id).get()));
        return "/comment";
    }

    @PostMapping("/logout")
    public String logoutPage(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
