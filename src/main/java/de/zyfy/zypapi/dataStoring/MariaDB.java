package de.zyfy.zypapi.dataStoring;

import java.sql.*;

public class MariaDB extends MySQL {
	public MariaDB(String host, int port, String database, String user, String password) {
		super(host, port, database, user, password);
	}

	@Override
	public void connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + database + "?autoReconnect=true", user, password);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}
