package com.farid.Divar.Library.Requests;

import org.springframework.beans.BeanUtils;

public abstract class BaseRequest<T> {

    public T toEntity(Class<T> clazz) {
        try {
            T entity = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(this, entity);
            
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create entity", e);
        }
    }
}
