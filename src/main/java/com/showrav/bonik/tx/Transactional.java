package com.showrav.bonik.tx;

import java.sql.SQLException;

@FunctionalInterface
public interface Transactional {
	void doInTransaction() throws SQLException;
}
