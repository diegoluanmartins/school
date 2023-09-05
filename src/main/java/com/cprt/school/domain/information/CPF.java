package com.cprt.school.domain.information;

public class CPF extends ValueObject {

    private static final String REGEX = "^[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}";

    public CPF(String cpf) throws IllegalArgumentException {
        super(cpf, REGEX);
    }

    public CPF() {
        super("", REGEX);
    }

    public void updateCpf(String cpf) throws IllegalArgumentException {
        super.update(cpf);
    }

    public String getCpf(){
        return super.getValue();
    }

}
