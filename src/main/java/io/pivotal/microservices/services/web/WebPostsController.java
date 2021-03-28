package io.pivotal.microservices.services.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.pivotal.microservices.posts.Post;

@Controller
public class WebPostsController {
    @Autowired
    protected WebPostService webPostService;

    public WebPostsController(WebPostService webPostService) {
        this.webPostService = webPostService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("postContent", "postText");
    }

    // @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
    // public String searchForm(Model model) {
    // model.addAttribute("post", new Post());
    // return "createPost";
    // }

    // @RequestMapping(value = "/posts/submit")
    // public String doSearch(Model model, Post post, BindingResult result) {
    // return "createPost";
    // }

    @RequestMapping("/posts/{author}")
    public String ownerSearch(Model model, @PathVariable("author") String author) {

        List<Post> posts = webPostService.findByAuthor(author);
        model.addAttribute("search", author);
        if (posts != null)
            model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("/posts")
    public String findPost(Model model) {

        List<Post> posts = webPostService.findAll();
        if (posts != null)
            model.addAttribute("posts", posts);
        return "posts";
    }
}
