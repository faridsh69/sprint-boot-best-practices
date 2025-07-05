package com.farid.Divar.Library.Services;

import com.farid.Divar.Library.Requests.BaseRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class BaseService<TEntity, ID, TRequest extends BaseRequest<TEntity>> {
    protected final JpaRepository<TEntity, ID> repository;
    private final Class<TEntity> entityClass;

    protected BaseService(JpaRepository<TEntity, ID> repository, Class<TEntity> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
    }

    public List<TEntity> index() {
        return repository.findAll();
    }

    public TEntity show(ID id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public TEntity create(TRequest request) {
        return repository.save(request.toEntity(entityClass));
    }

    public TEntity update(ID id, TRequest request) {
        TEntity entity = show(id);
        TEntity updatedData = request.toEntity(entityClass);
        BeanUtils.copyProperties(updatedData, entity, "id");

        return repository.save(entity);
    }

    public void delete(ID id) {
        TEntity entity = show(id);
        repository.delete(entity);
    }
}
