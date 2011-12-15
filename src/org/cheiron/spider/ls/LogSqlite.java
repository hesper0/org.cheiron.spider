package org.cheiron.spider.ls;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class LogSqlite {
	private LogSqlite(String cfgPath) {
		super();
		threadPool = Executors.newCachedThreadPool();
	}

	private static String s = "";
	private static LogSqlite logSqlite = null;
	private ExecutorService threadPool;

	public final static LogSqlite getInstance() {
		return getInstance(null);
	}

	public final static LogSqlite getInstance(String cfgPath) {
		synchronized (s) {
			if (logSqlite == null)
				logSqlite = new LogSqlite(cfgPath);
		}
		return logSqlite;
	}

	protected void message(LogMsg logMsg) {
		threadPool.submit(new LogRunnable(logMsg));
	}
}
