package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")//what mapping url would look like
//all will be sent to this contoller
public class SessionController {

    @Autowired
    private SessionRepository sessionRepo;
    // spring will autowire when controller is built it will creeate
    //instance of sessionRepo

    @GetMapping
    public List<Session> list()
    {
        return sessionRepo.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id)
    {
        Session one = sessionRepo.getOne(id);
        return one;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//anotation specifies return response
    //whern created(default is 200)
    public Session create(@RequestBody final Session session){
        return sessionRepo.saveAndFlush(session);

    }
}
