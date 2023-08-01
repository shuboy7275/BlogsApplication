package com.ait.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.binding.PostForm;
import com.ait.entityclasses.Blogs;
import com.ait.repository.BlogRepository;
import com.ait.service.BlogService;

@Controller
public class CreatePostController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private BlogRepository blogRepo;
	
	@GetMapping("/postindex")
	public String IndexPage() {
		return "index1";
	}

	@GetMapping("/postpage")
	public String createPostPage(@ModelAttribute("post") PostForm post) {
		return "createpost";
	}

	@PostMapping("/userPost")
	public String userPostPage(@ModelAttribute("post") PostForm post, Model model) {

		 String userPost = blogService.userPost(post);
		 
		 model.addAttribute("success", userPost);
		 
		 model.addAttribute("post", new PostForm());

		
		return "createpost";
	}
	
	@GetMapping("/update")
	public String upDate(@RequestParam("blogId") Integer blogId, Model model) {
		// get employee from the service

		 Optional<Blogs> findById = blogRepo.findById(blogId);

		if (findById.isPresent()) {
			Blogs form = findById.get();

			// set employee as a model attribute to pre-populate the form
			
			model.addAttribute("post", form);
			model.addAttribute("hidden",form.getBlogId());

		}
		return "createpost";
	}

	

	/*
	 * @GetMapping("/leavecomment") public String leaveCommentPage() { return
	 * "leavecomment"; }
	 */

	@GetMapping("/userRetrieval")
	public String retrievalPage( PostForm form,Model model) {
		
        List<Blogs> list = blogService.getPosts(form);
		
		model.addAttribute("getPosts", list);
		
        return "retrievingposts";
	}
	
	@GetMapping("/comments")
	public String commentsPage() {
		
		return "retrievecomments";
	}
	
	
}
