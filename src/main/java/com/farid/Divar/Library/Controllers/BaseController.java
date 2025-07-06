package com.farid.Divar.Library.Controllers;

import com.farid.Divar.Library.Requests.BaseRequest;
import com.farid.Divar.Library.Resources.ApiResource;
import com.farid.Divar.Library.Services.IBaseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<
        TEntity,
        TRequest extends BaseRequest<TEntity>,
        TResource,
        TService extends IBaseService<TEntity, TRequest>
        > {

    protected final TService service;

    protected BaseController(TService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResource<List<TResource>> index() {
        List<TEntity> entities = getService().index();
        List<TResource> resources = entities.stream()
                .map(this::convertToResource)
                .toList();

        return new ApiResource<>(resources);
    }

    @GetMapping("{id}")
    public ApiResource<TResource> show(@PathVariable Integer id) {
        TEntity entity = getService().show(id);

        return new ApiResource<>(convertToResource(entity));
    }

    @PostMapping
    public ApiResource<TResource> create(@Valid @RequestBody TRequest request) {
        TEntity entity = getService().create(request);

        return new ApiResource<>(convertToResource(entity));
    }

    @PutMapping("{id}")
    public ApiResource<TResource> update(@PathVariable Integer id, @Valid @RequestBody TRequest request) {
        TEntity entity = getService().update(id, request);

        return new ApiResource<>(convertToResource(entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }

    protected abstract TService getService();

    protected abstract TResource convertToResource(TEntity entity);
}
