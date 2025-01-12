package requests;

public interface FormRequest<T> {
	public void validate();
	public T toModel();
}
