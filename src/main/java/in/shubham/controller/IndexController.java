package in.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.shubham.binding.PostForm;
import in.shubham.entityclasses.Blogs;
import in.shubham.service.BlogService;

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
