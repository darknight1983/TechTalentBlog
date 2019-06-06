package com.techtalentsouth.TechTalentBlog.BlogPost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;


//import org.springframework.web.bind.annotation.RestController;





@Controller // You need to figure out the difference between @RestController and @Controller
public class BlogPostController {
   
	@Autowired
	private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<>();
	private BlogPost blogPost;
	
	
//	@GetMapping(value = "/") // You need to add this annotation in order to have the specified template returned
	@RequestMapping(value = "/") // Another way to use an annotation for routing
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts); // Try using the repository to get the blog posts.
		return "blogpost/index";
	}
	
	
	@GetMapping(value="/blogpost/new")
	public String newBlog(BlogPost blogPost) {
		return "blogpost/new";
	}
	
	
	@PostMapping(value="/blogpost/new")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		
		
		// The values from the form are being passed to the function and being used to create a new blogPost
		// object. 
		blogPostRepository.save(blogPost);
		posts.add(blogPost);
		
		// Model comes from the Spring Framework and is used to store the data that is going to be returned to the 
		// user. 
		
		model.addAttribute("id", blogPost.getId());
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}
	
	@GetMapping(value="blogpost/show/{id}")
	public String showBlogs(@PathVariable long id, Model model) {
		
		// Figure out the type of the entity being returned from the findById() method
		
		/**  
		*   Making the call to the repository with the findById() method did not work until
		*   the orElse() method was add. Figure out why is that.
		* 
		*/ 
		
		BlogPost blogPost = blogPostRepository.findById(id).orElse(null);
		model.addAttribute("post", blogPost);
		
		return "blogpost/show";
	}
	
	
	
}
