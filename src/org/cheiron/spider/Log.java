package org.cheiron.spider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Log {
	private Log() {
		super();
	}

	public static final void error(Class<? extends Object> classes, Object obj) {
		if ((obj instanceof Exception)) {
			Exception exception = (Exception) obj;
			StackTraceElement[] stackTrace = exception.getStackTrace();
			error(classes, exception.getMessage());
			for (int i = 0; i < stackTrace.length; i++)
				error(classes, stackTrace[i].toString());
		} else {
			error(classes, obj.toString());
		}
	}

	public static final void error(Class<? extends Object> classes, String strMessage) {
		Logger log = LoggerFactory.getLogger(classes);
		log.error(strMessage);
	}

	public static final void error(Object obj, Object strMessage) {
		error(obj.getClass(), strMessage);
	}

	public static final void error(Object obj, String strMessage) {
		error(obj.getClass(), strMessage);
	}

	public static final void info(Class<? extends Object> classes, Object obj) {
		if ((obj instanceof Exception)) {
			Exception exception = (Exception) obj;
			StackTraceElement[] stackTrace = exception.getStackTrace();
			error(classes, exception.getMessage());
			for (int i = 0; i < stackTrace.length; i++)
				info(classes, stackTrace[i].toString());
		} else {
			info(classes, obj.toString());
		}
	}

	public static final void info(Class<? extends Object> classes, String strMessage) {
		Logger log = LoggerFactory.getLogger(classes);
		log.info(strMessage);
	}

	public static final void info(Object obj, Object strMessage) {
		info(obj.getClass(), strMessage);
	}

	public static final void info(Object obj, String strMessage) {
		info(obj.getClass(), strMessage);
	}

	public static final void warn(Class<? extends Object> classes, Object obj) {
		if ((obj instanceof Exception)) {
			Exception exception = (Exception) obj;
			StackTraceElement[] stackTrace = exception.getStackTrace();
			error(classes, exception.getMessage());
			for (int i = 0; i < stackTrace.length; i++)
				warn(classes, stackTrace[i].toString());
		} else {
			warn(classes, obj.toString());
		}
	}

	public static final void warn(Class<? extends Object> classes, String strMessage) {
		Logger log = LoggerFactory.getLogger(classes);
		log.warn(strMessage);
	}

	public static final void warn(Object obj, Object strMessage) {
		warn(obj.getClass(), strMessage);
	}

	public static final void warn(Object obj, String strMessage) {
		warn(obj.getClass(), strMessage);
	}

	public static final void debug(Class<? extends Object> classes, Object obj) {
		if ((obj instanceof Exception)) {
			Exception exception = (Exception) obj;
			StackTraceElement[] stackTrace = exception.getStackTrace();
			error(classes, exception.getMessage());
			for (int i = 0; i < stackTrace.length; i++)
				debug(classes, stackTrace[i].toString());
		} else {
			debug(classes, obj.toString());
		}
	}

	public static final void debug(Class<? extends Object> classes, String strMessage) {
		Logger log = LoggerFactory.getLogger(classes);
		log.debug(strMessage);
	}

	public static final void debug(Object obj, Object strMessage) {
		debug(obj.getClass(), strMessage);
	}

	public static final void debug(Object obj, String strMessage) {
		debug(obj.getClass(), strMessage);
	}
}
