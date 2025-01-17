package controllers;

import java.util.List;

import models.Category;
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
}
