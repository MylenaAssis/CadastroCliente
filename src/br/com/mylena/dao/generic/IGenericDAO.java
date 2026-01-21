package br.com.mylena.dao.generic;

import br.com.mylena.domain.Client;
import br.com.mylena.domain.Persisted;
import br.com.mylena.domain.Product;

import java.util.Collection;

//PATTERN FACADE
public interface IGenericDAO<T extends Persisted> {
    //<T extends Persisted> funciona como um filtro para que os tipos possíveis sejam apenas os que implementam
    // Persisted

    public Boolean register(T entity);

    public void delete(Long value);

    public void update(T newEntity);

    public T search(Long value);

    public Collection<T> searchAll();
}

