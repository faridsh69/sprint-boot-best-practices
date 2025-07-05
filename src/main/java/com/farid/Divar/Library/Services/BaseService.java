package com.farid.Divar.Library.Services;

import com.farid.Divar.Library.Requests.RequestInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BaseService<T, ID, TR extends RequestInterface<T>> {
    protected final JpaRepository<T, ID> repository;

    protected BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> index() {
        return repository.findAll();
    }

    public T show(ID id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public T create(TR request) {
        return repository.save(request.toEntity());
    }

    public T update(ID id, TR request) {
        T entity = show(id);
        T updatedData = request.toEntity();
        BeanUtils.copyProperties(updatedData, entity, "id");

        return repository.save(entity);
    }

    public void delete(ID id) {
        T entity = show(id);
        repository.delete(entity);
    }
}
