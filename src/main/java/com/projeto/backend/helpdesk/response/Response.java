package com.projeto.backend.helpdesk.response;

import java.util.ArrayList;
import java.util.List;

/* Os metodos do controller retornaram um objeto response para padronizar a comunicação com o angular e o spring */
public class Response<T> {

    private T data; // objeto generico (usuario, ticket...etc)
    private List<String> errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }

        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

} 