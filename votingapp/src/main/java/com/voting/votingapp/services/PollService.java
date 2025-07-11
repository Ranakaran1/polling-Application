package com.voting.votingapp.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.voting.votingapp.model.OptionVote;
import com.voting.votingapp.model.Poll;
import com.voting.votingapp.repositories.PollRepository;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public Poll createPoll(Poll poll) {
       return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        // get the poll from DB
        Poll poll = pollRepository.findById(pollId).orElseThrow(()->
            new RuntimeException("Poll not Found") );

        // get all options;
        List<OptionVote> options = poll.getOptions();

        // check index is valid or not
        if(pollId<0 || pollId >= options.size()){
            throw new IllegalArgumentException("Invalid Option Index");
        }

        OptionVote selectedOption = options.get(optionIndex);
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        pollRepository.save(poll);



    }


}
