package mx.com.cursodia.java21.semana3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Celular;
import beans.Marca;

public class Modelo
{

	Connection con;
	int ultimaClave;
	
	public DefaultTableModel mostrarCelulares(DefaultTableModel modelo)
	{//Selecciona todos los registro de la BD, los acomoda en una lista para despues ser ordenados en una tabla y mandarlo al controlador.
		
		String query = "SELECT * FROM celulares;";
		
		try (Connection conexion = ConnectionPool.getConnection();
			PreparedStatement pstm = conexion.prepareStatement(query);
			ResultSet rs = pstm.executeQuery())
		{	
			ArrayList<Celular> lista = new ArrayList<Celular>();
						
			while(rs.next())
			{
				lista.add(new Celular(rs.getInt("cve_cel"), rs.getString("nom_cel"), rs.getInt("cvemarca_cel"), rs.getString("ram_cel"), rs.getString("rom_cel"), rs.getString("imei"), rs.getInt("inv_cel"), rs.getFloat("pre_cel")));
				
//				System.out.print(rs.getInt("cve_marca")+"\t\t");
//				System.out.print(rs.getString("nom_marca")+"\t\t");
//				System.out.println(rs.getInt("cveprov_marca")+"\t\t");
			}
			
			Object[][] datos = new Object[lista.size()][8];
			
			for(int i = 0; i < lista.size(); i++)
			{
				datos[i][0] = lista.get(i).getCve_cel();
				datos[i][1] = lista.get(i).getNom_cel();
				datos[i][2] = lista.get(i).getCvemarca_cel();
				datos[i][3] = lista.get(i).getRam_cel();
				datos[i][4] = lista.get(i).getRom_cel();
				datos[i][5] = lista.get(i).getImei();
				datos[i][6] = lista.get(i).getInv_cel();
				datos[i][7] = lista.get(i).getPre_cel();
			}
			String[] Encabezados = {"Clave", "Nombre", "Marca", "RAM", "ROM", "IMEI", "Stock","Precio" };
//			String[] Encabezados = {"Clave", "Nombre", "Proveedor"};
			modelo = new DefaultTableModel(datos, Encabezados);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;
	}
	
	public void agregarCelulares(String cve_cel, String nom_cel, String cvemarca_cel, String ram_cel, String rom_cel, String imei_cel, String inv_cel, String pre_cel) 
	{//Realiza un nuevo registro en la BD a partir de los datos recibidos desde el controlador		
		int cve = Integer.parseInt(cve_cel);
		String nom = nom_cel;
		int cvemarca = Integer.parseInt(cvemarca_cel);
		String ram = ram_cel;
		String rom = rom_cel;
		String imei = imei_cel;
		int inv = Integer.parseInt(inv_cel);
		float pre = Float.parseFloat(pre_cel);
		
		String query = "INSERT INTO celulares (cve_cel, nom_cel, cvemarca_cel, ram_cel, rom_cel, imei, inv_cel, pre_cel)"
				+ "VALUES (?,?,?,?,?,?,?,?);";
		
		
		try (Connection conexion = ConnectionPool.getConnection();
			PreparedStatement pstm = conexion.prepareStatement(query);) 
		{
			pstm.setInt(1, cve);
			pstm.setString(2, nom);
			pstm.setInt(3, cvemarca);
			pstm.setString(4, ram);
			pstm.setString(5, rom);
			pstm.setString(6, imei);
			pstm.setInt(7, inv);
			pstm.setFloat(8, pre);
			
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public DefaultTableModel buscarCelulares(String cve_cel, DefaultTableModel modelo)
	{//Busca un registro en la BD a partir de su ID. Regresa todas las coincidencias.
		if (modelo == null) {//Checa si el modelo recibido del controlador esta vacio
		        modelo = new DefaultTableModel(
		            new Object[][]{}, 
		            new String[]{"Clave", "Nombre", "Marca", "RAM", "ROM", "IMEI", "Stock", "Precio"}
		        );
		    } else {
		        modelo.setRowCount(0); // Limpiar datos existentes
		    }
		
		int cve = Integer.parseInt(cve_cel);
		
		String query = " SELECT * FROM celulares \r\n"
				+ "WHERE cve_cel = ?;";
		
		try (Connection conexion = ConnectionPool.getConnection();
			PreparedStatement pstm = conexion.prepareStatement(query)) {
		            pstm.setInt(1, cve);
		            
		            try (ResultSet rs = pstm.executeQuery()) {
		                if (rs.next()) { // Verificar si hay resultados
		                    Object[] fila = {
		                        rs.getInt("cve_cel"),
		                        rs.getString("nom_cel"),
		                        rs.getInt("cvemarca_cel"),
		                        rs.getString("ram_cel"),
		                        rs.getString("rom_cel"),
		                        rs.getString("imei"),
		                        rs.getInt("inv_cel"),
		                        rs.getFloat("pre_cel")
		                    };
		                    modelo.addRow(fila);
		                } else {
		                    JOptionPane.showMessageDialog(null, "No se encontró el celular con clave: " + cve);
		                }
		            }
		        }
		    catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Clave inválida: " + cve);
		        e.printStackTrace();
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Error de base de datos");
		        e.printStackTrace();
		    } finally {
		        cerrarConexion(); // Asegurar cierre de conexión
		    }
		    
		    return modelo;
		
	}
	
	
	private void cerrarConexion()//Cierra la conexion con la BD
	{
		String query = "SELECT MAX(cve_cel) AS ultima_clave FROM celulares";
		ultimaClave = 0;


		    try (Connection conexion = ConnectionPool.getConnection();
			PreparedStatement pstm = conexion.prepareStatement(query);
			ResultSet rs = pstm.executeQuery()) 
		    {

		        if (rs.next()) {
		            ultimaClave = rs.getInt("ultima_clave");
		        }
		    }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void conectar() //Abre conexion con la BD
	{
		String server = "address";
		String user = "user";//remover despues
		String password = "";
		
		try {
			con = DriverManager.getConnection(server, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(con != null)
		{
			System.out.println("Conexion a la BD establecida");
		}
		
	}
	
	public void actualizarCelulares(String cve_cel, String nom_cel, String cvemarca_cel, String ram_cel, String rom_cel, String imei_cel, String inv_cel, String pre_cel)
	{//Actualiza un registro a partir de su id.
		
		int cve = Integer.parseInt(cve_cel);
		String nom = nom_cel;
		int cvemarca = Integer.parseInt(cvemarca_cel);
		String ram = ram_cel;
		String rom = rom_cel;
		String imei = imei_cel;
		int inv = Integer.parseInt(inv_cel);
		float pre = Float.parseFloat(pre_cel);
		
		String query = "UPDATE celulares SET " +
		                 "nom_cel = ?, " +
		                 "cvemarca_cel = ?, " +
		                 "ram_cel = ?, " +
		                 "rom_cel = ?, " +
		                 "imei = ?, " +
		                 "inv_cel = ?, " +
		                 "pre_cel = ? " +
		                 "WHERE cve_cel = ?";
		
		int filasAfectadas = 0;
		
		try (Connection conexion = ConnectionPool.getConnection();
			PreparedStatement pstm = conexion.prepareStatement(query))
		{
			pstm.setString(1, nom);
			pstm.setInt(2, cvemarca);
			pstm.setString(3, ram);
			pstm.setString(4, rom);
			pstm.setString(5, imei);
			pstm.setInt(6, inv);
			pstm.setFloat(7, pre);
			pstm.setInt(8, cve);
			
			 filasAfectadas = pstm.executeUpdate();
		        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(filasAfectadas > 0) JOptionPane.showMessageDialog(null, "Actualizado!");
		
	}
	
	public void eliminarCelulares(String cve_cel)//Elimina un registro a partir de su ID
	{
		int cve = Integer.parseInt(cve_cel);
		
		String query = "DELETE FROM celulares WHERE cve_cel = ?";
		
		try (Connection conexion = ConnectionPool.getConnection();
			PreparedStatement pstm = conexion.prepareStatement(query))
		{
			pstm.setInt(1, cve);
			
			int respuesta = JOptionPane.showConfirmDialog(
					    null, 
					    "¿Deseas eliminar este registro?", 
					    "Confirmar Eliminación", 
					    JOptionPane.YES_NO_CANCEL_OPTION
					);
			
			if(respuesta == JOptionPane.YES_OPTION) 
			{
				pstm.executeUpdate();
				JOptionPane.showMessageDialog(null, "Actualizado!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
