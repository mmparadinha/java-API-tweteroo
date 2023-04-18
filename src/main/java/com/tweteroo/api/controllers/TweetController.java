package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
// @CrossOrigin(origins = "http://localhost:8000")
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @GetMapping
  public List<Tweet> listAllTweets() {
    return service.findAllTweets();
  }

  @PostMapping
  public void createTweet(@RequestBody @Valid TweetDTO req) {
    service.create(new Tweet(req));
  }
}
