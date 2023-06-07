package com.learn.domain.commons.persistence;

public interface Workspace<T> {
	T getById(String idValue) throws WorkspaceException;
	void makePersistence(T entity) throws WorkspaceException;
	void persistAll() throws WorkspaceException;
}
