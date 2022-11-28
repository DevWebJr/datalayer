package com.carlib.datalayer;

import com.carlib.datalayer.model.Category;
import com.carlib.datalayer.model.Comment;
import com.carlib.datalayer.model.Product;
import com.carlib.datalayer.service.CategoryService;
import com.carlib.datalayer.service.CommentService;
import com.carlib.datalayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootApplication
public class DatalayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DatalayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));

		Optional<Product> optionalProduct = productService.getProductById(1);
		Product productId1 = optionalProduct.get();
		System.out.println(productId1.getName());

		Optional<Category> optionalCategory = categoryService.getCategoryById(2);
		Category categoryId2 = optionalCategory.get();
		System.out.println(categoryId2.getName());

		Optional<Comment> optionalComment = commentService.getCommentById(2);
		Comment commentId2 =optionalComment.get();
		System.out.println(commentId2.getContent());
	}
}
