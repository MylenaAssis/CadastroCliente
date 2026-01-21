package br.com.mylena.domain;

import java.util.Objects;

public class Client implements Persisted {
    private String name;
    private Long cpf;
    private Long tel;
    private String address;
    private Integer number;
    private String city;
    private String state;


    public Client(String name, String cpf, String tel, String address, String number, String city, String state) {
        this.name = (name == null || name.isBlank()) ? null : name;
        this.cpf = (cpf == null || cpf.isBlank()) ? null : Long.valueOf(cpf.trim());
        this.tel = (tel == null || tel.isBlank()) ? null : Long.valueOf(tel.trim());
        this.address = (address == null || address.isBlank()) ? null : address;
        this.number = (number == null || number.isBlank()) ? null : Integer.valueOf(number.trim());
        this.city = (city == null || city.isBlank()) ? null : city;
        this.state = (state == null || state.isBlank()) ? null : state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
