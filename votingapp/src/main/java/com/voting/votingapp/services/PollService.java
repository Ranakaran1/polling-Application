package com.voting.votingapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.votingapp.model.Poll;
import com.voting.votingapp.repositories.PollRepository;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public Poll createPoll(Poll poll) {
       return pollRepository.save(poll);
    }


}
