package com.voting.votingapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voting.votingapp.model.Poll;
import com.voting.votingapp.services.PollService;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);

    }

}
