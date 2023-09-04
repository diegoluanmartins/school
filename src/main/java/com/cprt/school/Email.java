package com.cprt.school;

public class Email extends ValueObject {

    private static final String REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}$";

    public Email(String email) throws IllegalArgumentException {
        super(email, REGEX);
    }

    public Email() {
        super("", REGEX);
    }

    public void updateEmail(String email) throws IllegalArgumentException {
        super.update(email);
    }

    public String getEmail(){
        return this.value;
    }

}
