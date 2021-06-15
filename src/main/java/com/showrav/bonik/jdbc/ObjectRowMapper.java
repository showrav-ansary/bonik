package com.showrav.bonik.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ObjectRowMapper<E> {
	E mapRowToObject(ResultSet resultSet) throws SQLException;
}
