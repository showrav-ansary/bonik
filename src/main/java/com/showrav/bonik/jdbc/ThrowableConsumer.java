package com.showrav.bonik.jdbc;

import java.sql.SQLException;

public interface ThrowableConsumer<T> {
	void accept(T t) throws SQLException;
}
