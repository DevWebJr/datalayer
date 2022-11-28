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
	products.forEach(product -> System.out.print(product.getName()+"\n"));
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.print(category.getName()+"\n"));
		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.print(comment.getContent()+"\n"));
	}
}
