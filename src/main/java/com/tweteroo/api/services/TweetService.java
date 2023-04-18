package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;

  public Page<Tweet> findLatestTweets(int page) {
    PageRequest paging = PageRequest.of(page, 5, Sort.by("id").descending());
    return tweetRepository.findAll(paging);
  }

  public void create(Tweet data) {
    // String aaa = data.getUsername();
    // System.out.println(aaa);
    // User teste = userRepository.findByUsername(aaa);
    // System.out.println(teste);
    tweetRepository.save(data);
  }

  public List<Tweet> findUserTweets(String username) {
    return tweetRepository.findByUsername(username);
  }
}
