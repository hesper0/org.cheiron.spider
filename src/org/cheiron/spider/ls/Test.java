package org.cheiron.spider.ls;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		LogSqlite logSqlite = LogSqlite.getInstance();
		for (int i = 0; i < 1000; i++) {
			LogMsg logMsg = new LogMsg(new Date(), LogType.ERROR, "msg" + i);
//			long ts = System.currentTimeMillis();
			logSqlite.message(logMsg);
//			System.out.println(System.currentTimeMillis() - ts);
		}
		System.out.println("OK");
	}
}
