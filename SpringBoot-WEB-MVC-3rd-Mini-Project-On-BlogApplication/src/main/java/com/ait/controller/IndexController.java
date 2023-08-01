package com.ait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ait.binding.PostForm;
import com.ait.entityclasses.Blogs;
import com.ait.service.BlogService;

@Controller
public class IndexController {
	
	@Autowired
	private BlogService blogService;

	@GetMapping("/")
	public String indexPage(PostForm form, Model model) {
		
		  List<Blogs> indexPosts = blogService.getIndexPosts(form);
			
			model.addAttribute("getPosts", indexPosts);
			
		
		return "index";
	}

}
