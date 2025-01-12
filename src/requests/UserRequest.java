package requests;

import java.util.regex.Pattern;

import models.User;

public class UserRequest implements FormRequest {
    private String name;
    private String email;
    private String password;
    private String repeatPassword;

    // Construtor
    public UserRequest(String name, String email, String password, String repeatPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    @Override
    public void validate() {
        // Validações gerais
        if (name == null || name.isBlank()) throw new IllegalArgumentException("O campo nome é obrigatório!");
        if (email == null || email.isBlank())throw new IllegalArgumentException("O campo e-mail é obrigatório!");
        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) throw new IllegalArgumentException("Formato especificado de e-mail inválido!");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("O campo senha é obrigatório!");
        if (repeatPassword == null || repeatPassword.isBlank()) throw new IllegalArgumentException("O campo repetir senha é obrigatório!");
        if (!password.equals(repeatPassword)) throw new IllegalArgumentException("As senhas não coincidem!");
    }

    public User toUser() {
        return new User(name, email, password, null); 
    }
}

