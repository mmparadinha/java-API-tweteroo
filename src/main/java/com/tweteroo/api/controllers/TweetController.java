package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @GetMapping
  public Page<Tweet> listLatestTweets(@RequestParam int page) {
    return service.findLatestTweets(page);
  }

  @PostMapping
  public String createTweet(@RequestBody @Valid TweetDTO req) {
    service.create(new Tweet(req));
    return "OK";
  }

  @GetMapping("/{username}")
  public List<Tweet> listUserTweets(@PathVariable String username) {
    return service.findUserTweets(username);
  }
}
