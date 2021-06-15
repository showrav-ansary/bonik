package com.showrav.bonik.tx;

import java.sql.SQLException;

@FunctionalInterface
public interface CallableTransactional<T> {
	T doInTransaction() throws SQLException;
}
