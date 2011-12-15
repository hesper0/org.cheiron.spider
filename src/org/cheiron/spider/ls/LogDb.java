package org.cheiron.spider.ls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LogDb {
	private LogDb() {
		super();
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:C:/mysqlite.db", "aaa", "aaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String d = "d";
	private static LogDb logDb;
	private Connection connection;

	public final void executeUpdate(String sql) {
		try {
			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final static LogDb getInstance() {
		synchronized (d) {
			if (logDb == null)
				logDb = new LogDb();
		}
		return logDb;
	}
}
