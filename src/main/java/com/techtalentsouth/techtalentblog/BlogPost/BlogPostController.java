package com.techtalentsouth.techtalentblog.BlogPost;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BlogPostController {
    

    @Autowired
    private BlogPostRepository blogpostrepository;


    private List<BlogPost> posts = new ArrayList<>();


    @GetMapping(value = "/")
    public String index(BlogPost blogpost, Model model){
        model.addAttribute("posts", posts);
        return "blogpost/index";
    }

    @GetMapping(value = "/blogpost/new")
    public String newBlog(BlogPost blogpost, Model model){
        return "blogpost/new";

    }

    @PostMapping(value = "/blogposts")
    public String addNewBlogPost(BlogPost blogpost, Model model){
        blogpostrepository.save(new BlogPost(blogpost.getTitle(), blogpost.getAuthor(), blogpost.getBlogEntry()));
        posts.add(blogpost);
        model.addAttribute("title", blogpost.getTitle());
        model.addAttribute("author", blogpost.getAuthor());
        model.addAttribute("blogEntry", blogpost.getBlogEntry());

        return "blogpost/result";
    }
}
