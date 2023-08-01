package com.ait.service;

import java.util.List;

import com.ait.binding.LoginForm;
import com.ait.binding.PostForm;
import com.ait.binding.RegisterForm;
import com.ait.entityclasses.Blogs;

public interface BlogService {
	
	public boolean saveUserDetails(RegisterForm form);
	
	public boolean userLogin(LoginForm login);
	
	public String userPost(PostForm post);
	
	List<Blogs> getPosts(PostForm form);
	
	List<Blogs> getIndexPosts(PostForm form);

}
