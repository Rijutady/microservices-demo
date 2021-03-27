package io.pivotal.microservices.posts;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {
    protected Logger logger = Logger.getLogger(PostsController.class.getName());
    protected PostRepository postRepository;

    @Autowired
    public PostsController(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @RequestMapping("/posts/{author}")
    public List<Post> byNumber(@PathVariable("author") String author) {

        logger.info("posts-service byNumber() invoked: " + author);
        List<Post> posts = postRepository.findByAuthor(author);
        logger.info("posts-service byNumber() found: " + posts);

        return posts;
    }

}
