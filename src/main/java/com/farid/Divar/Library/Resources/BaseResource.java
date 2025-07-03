package com.farid.Divar.Library.Resources;

public abstract class BaseResource<T> {
  public abstract void toResource(T entity);

  public static <E, R extends BaseResource<E>> R from(E entity, Class<R> resourceClass) {
    try {
      R resource = resourceClass.getDeclaredConstructor().newInstance();
      resource.toResource(entity);

      return resource;
    } catch (Exception e) {
      throw new RuntimeException("Failed to create resource from entity", e);
    }
  }
}
