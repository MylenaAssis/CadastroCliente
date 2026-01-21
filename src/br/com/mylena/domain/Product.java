package br.com.mylena.domain;

import java.util.Objects;

public class Product implements Persisted {
    private Long code;
    private String name;

    public Product(String code, String name) {
        this.name = (name == null || name.isBlank()) ? null : name;
        this.code = (code == null || code.isBlank()) ? null : Long.valueOf(code.trim());
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
