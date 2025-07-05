package com.farid.Divar.Library.Services;

import com.farid.Divar.Library.Requests.BaseRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<TEntity, TRequest extends BaseRequest<TEntity>>
        implements IBaseService<TEntity, TRequest> {

    protected final JpaRepository<TEntity, Integer> repository;
    private final Class<TEntity> entityClass;

    protected BaseService(JpaRepository<TEntity, Integer> repository, Class<TEntity> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
    }

    @Override
    public List<TEntity> index() {
        return repository.findAll();
    }

    @Override
    public TEntity show(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TEntity create(TRequest request) {
        return repository.save(request.toEntity(entityClass));
    }

    @Override
    public TEntity update(Integer id, TRequest request) {
        TEntity entity = show(id);
        TEntity updatedData = request.toEntity(entityClass);
        BeanUtils.copyProperties(updatedData, entity, "id");

        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        TEntity entity = show(id);
        repository.delete(entity);
    }
}
