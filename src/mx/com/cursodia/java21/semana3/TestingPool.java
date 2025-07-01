package mx.com.cursodia.java21.semana3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestingPool
{
	public static void main(String []args)
	{
		stressTest(10, 5);
		
	}
	
	public static void stressTest(int threadCount, int iterations) {
		    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		    
		    for (int i = 0; i < threadCount; i++) {
		        executor.execute(() -> {
		            for (int j = 0; j < iterations; j++) {
		                try (Connection conn = ConnectionPool.getConnection();
		                     PreparedStatement pstmt = conn.prepareStatement("SELECT ?");
		                ) {
		                    pstmt.setInt(1, j);
		                    pstmt.executeQuery();
		                    System.out.println(Thread.currentThread().getName() + " ejecuto iteracion " + j);
		                } catch (SQLException e) {
		                    System.err.println("Error en hilo: " + e.getMessage());
		                }
		            }
		        });
		    }
		    
		    executor.shutdown();
		    try {
		        executor.awaitTermination(1, TimeUnit.MINUTES);
		    } catch (InterruptedException e) {
		        Thread.currentThread().interrupt();
		    }
		}

}
