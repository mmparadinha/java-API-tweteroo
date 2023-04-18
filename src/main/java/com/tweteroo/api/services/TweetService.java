package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  public List<Tweet> findAllTweets() {
    return repository.findAll();
  }

  public void create(Tweet data) {
    repository.save(data);
  }

  public List<Tweet> findUserTweets(String username) {
    return repository.findByUsername(username);
  }
}
