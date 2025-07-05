package com.farid.Divar.Library.Services;

import com.farid.Divar.Library.Requests.BaseRequest;

import java.util.List;

public interface IBaseService<TEntity, TRequest extends BaseRequest<TEntity>> {

    List<TEntity> index();

    TEntity show(Integer id);

    TEntity create(TRequest request);

    TEntity update(Integer id, TRequest request);

    void delete(Integer id);
}
