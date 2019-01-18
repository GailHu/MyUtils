package com.hjf.test;

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
 * 		在原有的版本上删除了空参构造方法，删除了外部使用的静态方法。用户在使用的时候，必须要构造Log类，使用非静态方法输出日志。
 */
public class Log {
	@SuppressWarnings("unused")
	private Log(){}
	public Log(String fileName) {
		try {
			bWriter = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Log(String path, String fileName) {//Log2018-10-29
		try {
			File fileRoot = new File(path);
			if (!fileRoot.exists()) {
				fileRoot.mkdir();
			}
			bWriter = new BufferedWriter(new FileWriter(new File(path,fileName),true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static BufferedWriter bWriter;
	public static String ERROR = "*****************ERROR*****************";
	public static String WARNING = "----------------WARNING----------------";
	/**
	 * 输出日志到文件，输出后不换行。
	 * @param info
	 */
	public void writeLog(String info) {
		try {
			bWriter.write(info);
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 输出日志到文件，输出后换行。
	 * @param info
	 */
	public void writeLineLog(String info) {
		try {
			bWriter.write(info);
			bWriter.newLine();
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 输出空行到日志文件，也可用于换行。
	 */
	public void newLine() {
		try {
			bWriter.newLine();
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 释放资源
	 */
	public void close() {
		try {
			if (bWriter!=null) {
				bWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
