package com.carlib.datalayer;

import com.carlib.datalayer.model.Category;
import com.carlib.datalayer.model.Comment;
import com.carlib.datalayer.model.Product;
import com.carlib.datalayer.service.CategoryService;
import com.carlib.datalayer.service.CommentService;
import com.carlib.datalayer.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	@Transactional
	public void run(String... args) throws Exception{
		//Get all products
		Iterable<Product> products = productService.getProducts();
		//Get all categories
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		//Get all comments
		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));
		//Get one product by id, and display his name
		Optional<Product> optionalProduct = productService.getProductById(1);
		Product productId1 = optionalProduct.get();
		System.out.println(productId1.getName());
		//Get one category by id, and display his name
		Optional<Category> optionalCategory = categoryService.getCategoryById(1);
		Category categoryId1 = optionalCategory.get();
		System.out.println(categoryId1.getName());
		//Get one comment by id, and display his content
		Optional<Comment> optionalComment = commentService.getCommentById(2);
		Comment commentId2 =optionalComment.get();
		System.out.println(commentId2.getContent());
		//Get one product by id, and display his comments
		productId1.getComments().forEach(
				comment -> System.out.println(comment.getContent())
		);
		//Get all categories from one product
		System.out.println("Catégorie(s) du produit \""+productId1.getName()+"\" :");
		productId1.getCategories().forEach(
				category -> System.out.println("- "+category.getName())
		);

//		Category newCategory = new Category();
//		newCategory.setName("Promotion");
//
//		newCategory = categoryService.add(newCategory);
//
//		Iterable<Category> allCategories = categoryService.getCategories();
//		allCategories.forEach(category -> System.out.println(category.getName()));
//
//		Product newProduct = new Product();
//		newProduct.setName("AssurancePromotionnelle");
//		newProduct.setDescription("Les garanties de l'assurance promotionnelle offre un prix en fonction de votre fidélité!");
//		newProduct.setCost(950);
//
//		newCategory.addProduct(newProduct);
//
//		newProduct = productService.add(newProduct);
//		products.forEach(product -> System.out.println(product.getName()));

//		Category newCategory = new Category();
//		newCategory.setName("-25ans");
//
//		Product newProduct = new Product();
//		newProduct.setName("AssuranceAuTiers-25ans");
//		newProduct.setDescription("Assurance au tiers réservée aux conducteurs de -25 ans.");
//		newProduct.setCost(2000);
//
//		newCategory.addProduct(newProduct);
//		categoryService.add(newCategory);

//		Product productAssuranceAuTiers = productService.getProductById(1).get();
//		Comment newComment = new Comment();
//		newComment.setContent("Assurance peu intéressante.");
//		productAssuranceAuTiers.addComment(newComment);

		// Derived Queries
		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
		searchResults.forEach(product -> System.out.println("Résultat de la requête dérivée (Derived Querry) : "+product.getProductId()));

		searchResults = productService.getProductsByCategoryName("Standard");
		searchResults.forEach(product -> System.out.println(product.getName()));

	}
}
