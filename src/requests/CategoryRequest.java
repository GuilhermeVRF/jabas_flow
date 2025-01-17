package requests;

import models.Category;

public class CategoryRequest implements FormRequest<Category>{
	private String name;
	
	public CategoryRequest(String name) {
		this.name = name;
	}
	
	@Override
	public void validate() {
		if (name == null || name.isBlank()) throw new IllegalArgumentException("O campo nome é obrigatório!");
	}

	@Override
	public Category toModel() {
		// TODO Auto-generated method stub
		return new Category(name);
	}

}
