package requests;

import java.io.File;
import java.util.regex.Pattern;

import models.User;

public class UserRequest implements FormRequest {
    private String name;
    private String email;
    private String password;
    private String repeatPassword;
    private File profile;

    // Construtor
    public UserRequest(String name, String email, String password, String repeatPassword, File profile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.profile = profile;
    }

    @Override
    public void validate() {
    	int maxSizeFileInBytes = 2 * 1024 * 1024;
    	
        // Validações gerais
        if (name == null || name.isBlank()) throw new IllegalArgumentException("O campo nome é obrigatório!");
        if (email == null || email.isBlank())throw new IllegalArgumentException("O campo e-mail é obrigatório!");
        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) throw new IllegalArgumentException("Formato especificado de e-mail inválido!");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("O campo senha é obrigatório!");
        if (repeatPassword == null || repeatPassword.isBlank()) throw new IllegalArgumentException("O campo repetir senha é obrigatório!");
        if (!password.equals(repeatPassword)) throw new IllegalArgumentException("As senhas não coincidem!");
        if(this.profile.length() > maxSizeFileInBytes) throw new IllegalArgumentException("O tamanho máximo da imagem de perfil deve ser 2MB!");
    }

    public User toUser() {
        return new User(name, email, password, profile); 
    }
}

