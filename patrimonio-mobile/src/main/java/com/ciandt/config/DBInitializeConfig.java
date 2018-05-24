package com.ciandt.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitializeConfig {

	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void initialize(){
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.execute("DROP TABLE IF EXISTS Item");
			statement.execute("DROP TABLE IF EXISTS Item");
			statement.executeUpdate(
					"CREATE TABLE Item(" +
					"id INTEGER Primary key, " +
					"etiqueta varchar(30) not null," +
					"descricao varchar(30) not null," +
					"dataaquisicao DATE not null) "
					);
			statement.executeUpdate(
					"INSERT INTO Item " +
					"(etiqueta, descricao, dataaquisicao) " +
					"VALUES " + "('NT0123', 'Notebook i7', '2018-02-24')"
					);
			statement.close();
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

