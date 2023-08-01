package in.shubham.service;

import java.util.List;

import in.shubham.binding.LoginForm;
import in.shubham.binding.PostForm;
import in.shubham.binding.RegisterForm;
import in.shubham.entityclasses.Blogs;

public interface BlogService {
	
	public boolean saveUserDetails(RegisterForm form);
	
	public boolean userLogin(LoginForm login);
	
	public String userPost(PostForm post);
	
	List<Blogs> getPosts(PostForm form);
	
	List<Blogs> getIndexPosts(PostForm form);

}
