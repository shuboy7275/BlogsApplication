package in.shubham.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shubham.binding.LoginForm;
import in.shubham.binding.PostForm;
import in.shubham.binding.RegisterForm;
import in.shubham.entityclasses.Blogs;
import in.shubham.entityclasses.UserDetails;
import in.shubham.repository.BlogRepository;
import in.shubham.repository.UserRepository;
import in.shubham.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private HttpSession session;

	@Autowired
	private BlogRepository blogRepo;

	@Override
	public boolean saveUserDetails(RegisterForm form) {

		UserDetails findByemail = userRepo.findByemail(form.getEmail());

		if (findByemail != null) {

			return false;
		}

		UserDetails user = new UserDetails();

		BeanUtils.copyProperties(form, user);

		userRepo.save(user);

		return true;
	}

	@Override
	public boolean userLogin(LoginForm login) {

		UserDetails entity = userRepo.findByemailAndPassword(login.getEmail(), login.getPassword());

		if (entity == null) {

			return false;
		}

		session.setAttribute("userId", entity.getUserId());
		return true;
	}

	@Override
	public String userPost(PostForm post) {

		Integer userId = (Integer) session.getAttribute("userId");

		Optional<UserDetails> user = userRepo.findById(userId);
		UserDetails userDetails = user.get();

		if (post.getBlogId() != null) {

			Optional<Blogs> findById = blogRepo.findById(post.getBlogId());

			Blogs blogs = findById.get();

			blogs.setTitle(post.getTitle());
			blogs.setContent(post.getContent());
			blogs.setDescription(post.getDescription());
			blogs.setUserDetails(userDetails);

			blogRepo.save(blogs);
			return "Record is Updated successfully";
		}

		Blogs blog = new Blogs();

		BeanUtils.copyProperties(post, blog);

		blog.setUserDetails(userDetails);

		blogRepo.save(blog);

		return "Record saved successfully";

	}

	@Override
	public List<Blogs> getPosts(PostForm form) {

		Integer userId = (Integer) session.getAttribute("userId");

		Optional<UserDetails> findById = userRepo.findById(userId);

		if (findById.isPresent()) {

			UserDetails detailsEntity = findById.get();

			List<Blogs> blogDetails = detailsEntity.getBlogDetails();

			return blogDetails;

		}
		return null;
	}

	@Override
	public List<Blogs> getIndexPosts(PostForm form) {

		List<Blogs> all = blogRepo.findAll();

		return all;

	}

}
