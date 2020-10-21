package com.techtalentsouth.techtalentblog.BlogPost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogPostController {
    
    @GetMapping(value = "/")
    public String index(BlogPost blogpost){
        return "blogpost/index";
    }
}
