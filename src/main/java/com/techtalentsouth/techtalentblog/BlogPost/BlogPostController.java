package com.techtalentsouth.techtalentblog.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BlogPostController {
    

    @Autowired
    private BlogPostRepository blogpostrepository;

    @GetMapping(value = "/")
    public String index(BlogPost blogpost){
        return "blogpost/index";
    }

    @PostMapping(value = "/")
    public String addNewBlogPost(BlogPost blogpost, Model model){
        blogpostrepository.save(new BlogPost(blogpost.getTitle(), blogpost.getAuthor(), blogpost.getBlogEntry()));
        model.addAttribute("title", blogpost.getTitle());
        model.addAttribute("author", blogpost.getAuthor());
        model.addAttribute("blogEntry", blogpost.getBlogEntry());

        return "blogpost/result";
    }
}
