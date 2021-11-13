package de.zyfy.zypapi.dataStoring;

import java.sql.*;

public class MySQL {
	Connection connection;

	final String host;
	final int port;
	final String database;
	final String user;
	final String password;

	public MySQL(String host, int port, String database, String user, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.user = user;
		this.password = password;
	}

	public void connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", user, password);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	public void close() {
		try {
			if (connection != null) connection.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	public void update(String query) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	public ResultSet query(String query) {
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return resultSet;
	}
}
