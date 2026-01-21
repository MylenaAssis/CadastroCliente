package br.com.mylena.dao.generic;

import br.com.mylena.domain.Client;
import br.com.mylena.domain.Persisted;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericDAO<T extends Persisted> implements IGenericDAO<T> {
    //nao precisa ser instanciada porque é uma classe generica

    //criando um banco de clientes e contratos
    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getClassType();

    public abstract Long getCode(T entity);

    public abstract void updateData(T entity, T newEntity);

    //construtor
    public GenericDAO() {
        this.map = new HashMap<>();

        Map<Long, T> internMap = this.map.get(getClassType());
        if (internMap == null) {
            internMap = new HashMap<>();
            this.map.put(getClassType(), internMap);
        }
    }

    @Override
    public Boolean register(T entity) {
        Map<Long, T> internMap = this.map.get(getClassType());

        if (internMap.containsKey(getCode(entity))) {
            return false;
        }

        internMap.put(getCode(entity), entity);
        return true;
    }

    @Override
    public void delete(Long value) {
        Map<Long, T> internMap = this.map.get(getClassType());
        T registeredEntity = internMap.get(value);
        if (registeredEntity != null) {
            this.map.remove(value, registeredEntity);
        }
    }

    @Override
    public void update(T entity) {
        Map<Long, T> internMap = this.map.get(getClassType());
        T registeredEntity = internMap.get(entity);
        if (registeredEntity != null) {
            updateData(entity, registeredEntity);
        }
    }


    @Override
    public T search(Long value) {
        Map<Long, T> internMap = this.map.get(getClassType());
        return internMap.get(value);
    }

    @Override
    public Collection<T> searchAll() {
        Map<Long, T> internMap = this.map.get(getClassType());
        return internMap.values();
    }
}
