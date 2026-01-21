package br.com.mylena.dao;

import br.com.mylena.domain.Client;
import br.com.mylena.domain.Product;

import java.util.Collection;
import java.util.List;

public class ProductDAO implements IProductDAO {

    @Override
    public Boolean register(Product product) {
        return null;
    }

    @Override
    public void delete(Long code) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Client search(Long code) {
        return null;
    }

    @Override
    public Collection<Product> searchAll() {
        return List.of();
    }
}
