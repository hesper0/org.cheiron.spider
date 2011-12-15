package org.cheiron.spider.ls;

import java.text.SimpleDateFormat;
import java.util.Date;

class LogMsg {
	public LogMsg(Date date, LogType type, String msg, String... other) {
		this.date = date;
		this.type = type;
		this.msg = msg;
		this.other = other;
	}

	private Date date;
	private String msg;
	private LogType type;
	private String[] other;

	public String makeSql() {
		StringBuilder sbSql = new StringBuilder("INSERT INTO LOG VALUES(");
		sbSql.append("'").append(new SimpleDateFormat("yyyy-MM-dd").format(date)).append("',");
		sbSql.append("'").append(type.toString()).append("',");
		sbSql.append("'").append(msg).append("')");
		return sbSql.toString();
	}
}
