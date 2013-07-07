package com.archer.mailman.constant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Environment {

	public static Properties props;
	public static String SmtpHost;
	public static String SmtpSocketFactoryClass;
	public static String SmtpSocketFactoryPort;
	public static String SmtpAuth;
	public static String SmtpPort;
	public static String UserName;
	public static String PassWord;
	public static String MongoHost;
	public static int MongoPort;
	public static String DBName;
	
	static {
		props = new Properties();
		try {
			props.load(new FileInputStream(
					"src/main/resources/email.properties"));
			props.load(new FileInputStream("src/main/resources/db.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Environment.SmtpHost = props.getProperty("mail.smtp.host");
		Environment.SmtpSocketFactoryClass = props
				.getProperty("mail.smtp.socketFactory.class");
		Environment.SmtpSocketFactoryPort = props
				.getProperty("mail.smtp.socketFactory.port");
		Environment.SmtpAuth = props.getProperty("mail.smtp.auth");
		Environment.SmtpPort = props.getProperty("mail.smtp.port");
		Environment.UserName = props.getProperty("mail.username");
		Environment.PassWord = props.getProperty("mail.password");
		Environment.MongoHost = props.getProperty("mongo.host");
		//Environment.MongoPort = props.getProperty("mongo.port");
		Environment.DBName = props.getProperty("mongo.db");
	}

	public static Properties init() {
		return props;
	}
}
