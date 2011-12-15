package org.cheiron.spider.ls;

class LogRunnable implements Runnable {
	private LogMsg logMsg;

	public LogRunnable(LogMsg logMsg) {
		this.logMsg = logMsg;
	}

	@Override
	public void run() {
		LogDb.getInstance().executeUpdate(logMsg.makeSql());
	}

}
