package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.domain.BasePersistable;

import java.util.List;

public interface Dao<T extends BasePersistable> {

	public boolean save(T entity);
	public boolean delete(T entity);
	public List<T> findAll();
	public T findById(int id);

}
