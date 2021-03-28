package io.pivotal.microservices.services.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import io.pivotal.microservices.posts.Post;

@Service
public class WebPostService {
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected Logger logger = Logger.getLogger(WebPostService.class.getName());

    protected String serviceUrl;

    public WebPostService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    // public Post findByAuthor(String author) {
    // logger.info("posts find by author");
    // System.out.println("posts find by author");
    // try {
    // return restTemplate.getForObject(serviceUrl + "/post/{author}", Post.class,
    // author);
    // } catch (Exception e) {
    // return null;
    // }
    // }

    public List<Post> findByAuthor(String author) {
        Post[] posts = null;

        try {
            posts = restTemplate.getForObject(serviceUrl + "/posts/{author}", Post[].class, author);
        } catch (HttpClientErrorException e) { // 404
            // Nothing found
        }

        if (posts == null || posts.length == 0)
            return null;
        else
            return Arrays.asList(posts);
    }

    public List<Post> findAll() {
        Post[] posts = null;

        try {
            posts = restTemplate.getForObject(serviceUrl + "/posts", Post[].class);
        } catch (HttpClientErrorException e) { // 404
            // Nothing found
        }

        if (posts == null || posts.length == 0)
            return null;
        else
            return Arrays.asList(posts);
    }

    // public List<Account> byOwnerContains(String name) {
    // logger.info("byOwnerContains() invoked: for " + name);
    // Account[] accounts = null;

    // try {
    // accounts = restTemplate.getForObject(serviceUrl + "/accounts/owner/{name}",
    // Account[].class, name);
    // } catch (HttpClientErrorException e) { // 404
    // // Nothing found
    // }

    // if (accounts == null || accounts.length == 0)
    // return null;
    // else
    // return Arrays.asList(accounts);
    // }

    // public Account getByNumber(String accountNumber) {
    // Account account = restTemplate.getForObject(serviceUrl +
    // "/accounts/{number}", Account.class, accountNumber);

    // if (account == null)
    // throw new AccountNotFoundException(accountNumber);
    // else
    // return account;
    // }
}
