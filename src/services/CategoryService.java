package services;

import java.util.List;

import models.Category;
import repositories.CategoryRepository;
import utils.Response;

public class CategoryService {
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Response<List<Category>> get(){
		return this.categoryRepository.get();
	}
	
	public Response<Category> store(Category category){
		return this.categoryRepository.store(category);
	}
}
