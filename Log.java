package com.gail.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Title Log.java
 * @Author Gail_Hu
 * @Copyright Unis-Soft
 * @Date 2019-1-18
 * @Description Log日志输出工具类。
 * @Version V1.1
 */
public class Log {
	static {
		new Log();
	}
	public Log() {//Log2018-10-29
		try {
			File fileRoot = new File("log");
			if (!fileRoot.exists()) {
				fileRoot.mkdir();
			}
			bWriter = new BufferedWriter(new FileWriter(new File("log/Log"+DateFormater.getToday("yyyy-MM-dd")+".log"),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Log(String fileName) {
		try {
			bWriter = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static BufferedWriter bWriter;
	public static String ERROR = "*****************ERROR*****************";
	public static String WARNING = "----------------WARNING----------------";
	public static void writeLog(String info) {
		try {
			bWriter.write(info);
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeLineLog(String info) {
		try {
			bWriter.write(info);
			bWriter.newLine();
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void newLine() {
		try {
			bWriter.newLine();
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void close() {
		try {
			if (bWriter!=null) {
				bWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
