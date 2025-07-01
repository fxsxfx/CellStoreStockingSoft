package mx.com.cursodia.java21.semana3;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Vistaprincipal extends JFrame
{
	private JPanel contentPane;
	JButton btnMostrar;
	JTable tabla;
	boolean vistaLanzada = false;
	
	public static void main(String[] args)
	{
		Vistaprincipal vp = new Vistaprincipal();
		vp.lanzarVista();
	}
	
	public void lanzarVista()
	{
		try 
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					try {
						crearGUI();
						setVisible(true);
						vistaLanzada = true;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	
	public void crearGUI()
	{
		setTitle("Punto Telcel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnMostrar = new JButton("Mostrar Articulos");
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnMostrar.setBounds(281, 364, 189, 40);
		contentPane.add(btnMostrar);
		
		Object[][] datos = {
				{"", "", "", "", "", "", ""},
		};
		String[] Encabezados = {"Clave", "Nombre", "Marca", "Categoria", "Stock", "IMEI", "Precio" };
		DefaultTableModel modelo = new DefaultTableModel(datos, Encabezados);
		
		tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(62, 29, 621, 311);
		
		contentPane.add(scrollPane);
		
	}
}
