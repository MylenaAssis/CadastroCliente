package br.com.mylena.dao;

import br.com.mylena.dao.generic.GenericDAO;
import br.com.mylena.domain.Client;
import br.com.mylena.domain.Persisted;
import br.com.mylena.domain.Product;

import java.util.Collection;
import java.util.List;

public class ProductDAO extends GenericDAO<Product> implements IProductDAO {

    @Override
    public Boolean register(Product product) {
        return null;
    }

    @Override
    public Class getClassType() {
        return Product.class;
    }

    @Override
    public Long getCode(Product product) {
        return product.getCode();
    }

    @Override
    public void updateData(Product product, Product newProduct) {
        if (newProduct != null) {
            product.setCode(newProduct.getCode());
            product.setName(newProduct.getName());
        }
    }
}
