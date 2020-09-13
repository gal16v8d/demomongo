package co.com.gsdd.demo.mongo.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DemoConstants {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	
	public static final String SQL = "SQL";
	public static final String NO_SQL = "NoSQL";
	
	public static final String BASE_PKG = "co.com.gsdd.demo.mongo";
	public static final String CONFIG_PKG = BASE_PKG + ".config";
	public static final String CONTROLLER_PKG = BASE_PKG + ".controllers";
	public static final String REPO_PKG = BASE_PKG + ".repositories";
	public static final String SERVICE_PKG = BASE_PKG + ".services";

}
