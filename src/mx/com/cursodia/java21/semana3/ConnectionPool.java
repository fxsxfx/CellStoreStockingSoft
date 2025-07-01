package mx.com.cursodia.java21.semana3;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool
{
	private static final HikariDataSource dataSource;
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(DB_Config.SERVER);
		config.setUsername(DB_Config.USER);
		config.setPassword(DB_Config.PASSWORD);
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(3);
		config.setMaxLifetime(90000);
		config.setConnectionTimeout(60000);
		config.setLeakDetectionThreshold(5000);
		config.setIdleTimeout(60000);
		dataSource = new HikariDataSource(config);
		
		config.addDataSourceProperty("cachePrepStmts", "true"); //habilita cache de pstm
		config.addDataSourceProperty("prepStmtCacheSize", "250"); //establece max de pstm en cache
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			if(dataSource != null)
			{
				dataSource.close();
				System.out.println("Pool cerrado");
			}
		}
				));
	}
	
	public static Connection getConnection() throws SQLException
	{
		logPoolStats();
		return dataSource.getConnection();
	}
	
	private static void logPoolStats()
	{
		System.out.println(
				"[Pool Stats] Activas: " + dataSource.getHikariPoolMXBean().getActiveConnections()
				+ "  |   Inactivas: " + dataSource.getHikariPoolMXBean().getIdleConnections()
				);
	}
	
}
