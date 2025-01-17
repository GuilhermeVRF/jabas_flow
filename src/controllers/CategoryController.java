package controllers;

import java.util.List;

import models.Category;
import requests.CategoryRequest;
import services.CategoryService;
import utils.Response;

public class CategoryController {
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public Response<List<Category>> get(){
		return this.categoryService.get();
	}
	
	public Response<Category> store(CategoryRequest categoryRequest){
		try {
			categoryRequest.validate();
		}catch(IllegalArgumentException exception) {
			return new Response<Category>("error", exception.getMessage());
		}
		
		return this.categoryService.store(categoryRequest.toModel());
	}
}
