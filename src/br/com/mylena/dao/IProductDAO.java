package br.com.mylena.dao;

import br.com.mylena.domain.Client;
import br.com.mylena.domain.Product;

import java.util.Collection;

public interface IProductDAO {
    public Boolean register(Product product);
    public void delete(Long code);
    public void update(Product product);
    public Client search(Long code);
    public Collection<Product> searchAll();
}
