package mx.com.cursodia.java21.semana3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VistaTabbed extends JFrame
{
	vistaCelulares vCel = new vistaCelulares();
	
	
	
	JPanel panelAccesorios;
	boolean vistaLanzada = false;
	
	
	public void crearGUI() 
	{
		this.setTitle("Tabbed Demo");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel celulares = panelCelulares();
		JPanel accesorios = vistaAccesorios();
		JPanel proveedores = new JPanel();
		JPanel marcas = new JPanel();
		JPanel exportar = new JPanel();
		
		
		JTabbedPane tabbedpane = new JTabbedPane(); 
		tabbedpane.setBounds(200, 200, 890, 630);
		
		tabbedpane.add("Celulares", celulares);
		tabbedpane.add("Accesorios", accesorios);
		tabbedpane.add("Proveedores", proveedores);
		tabbedpane.add("Marcas", marcas);
		tabbedpane.add("Exportar", exportar);
		
		this.add(tabbedpane, BorderLayout.CENTER);

	}
	
	JTextField txtCve_acc;
	JTextField txtNom_acc;
	JTextField txtCve_marca_acc;
	JTextField txtInv_acc;
	JTextField txtPre_acc;
	
	JButton btnMostrar_acc;
	JButton btnAdd_acc;
	JButton btnBuscar_acc;
	JButton btnEliminar_acc;
	JButton btnActualizar_acc;
	
	JTable tabla_acc;

	public JPanel vistaAccesorios()
	{
		setBounds(100, 100, 829, 579);
		panelAccesorios = new JPanel();
		panelAccesorios.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelAccesorios.setLayout(null);
		
		btnMostrar_acc = new JButton("Mostrar");
		btnMostrar_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMostrar_acc.setBounds(187, 101, 137, 34);
		panelAccesorios.add(btnMostrar_acc);
		
		btnAdd_acc = new JButton("Agregar");
		btnAdd_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd_acc.setBounds(39, 101, 137, 34);
		panelAccesorios.add(btnAdd_acc);
		
		btnBuscar_acc = new JButton("Buscar");
		btnBuscar_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar_acc.setBounds(335, 101, 137, 34);
		panelAccesorios.add(btnBuscar_acc);
		
		btnEliminar_acc = new JButton("Eliminar");
		btnEliminar_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar_acc.setBounds(631, 101, 137, 34);
		panelAccesorios.add(btnEliminar_acc);
		
		btnActualizar_acc = new JButton("Actualizar");
		btnActualizar_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar_acc.setBounds(483, 101, 137, 34);
		panelAccesorios.add(btnActualizar_acc);
		
		JLabel lblNom_acc = new JLabel("Nombre:");
		lblNom_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom_acc.setBounds(208, 30, 78, 16);
		panelAccesorios.add(lblNom_acc);
		
		JLabel lblCve_acc = new JLabel("Clave:");
		lblCve_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_acc.setBounds(39, 30, 78, 16);
		panelAccesorios.add(lblCve_acc);
		
		txtCve_acc = new JTextField();
		txtCve_acc.setBounds(86, 28, 104, 20);
		panelAccesorios.add(txtCve_acc);
		txtCve_acc.setColumns(10);
		
		txtNom_acc = new JTextField();
		txtNom_acc.setBounds(281, 29, 445, 20);
		panelAccesorios.add(txtNom_acc);
		txtNom_acc.setColumns(10);
		
		JLabel lblCve_marca = new JLabel("Clave de marca:");
		lblCve_marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_marca.setBounds(39, 60, 137, 16);
		panelAccesorios.add(lblCve_marca);
		
		txtCve_marca_acc = new JTextField();
		txtCve_marca_acc.setColumns(10);
		txtCve_marca_acc.setBounds(158, 59, 104, 20);
		panelAccesorios.add(txtCve_marca_acc);
		
		JLabel lblInv_acc = new JLabel("En stock:");
		lblInv_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInv_acc.setBounds(291, 57, 78, 16);
		panelAccesorios.add(lblInv_acc);
		
		txtInv_acc = new JTextField();
		txtInv_acc.setColumns(10);
		txtInv_acc.setBounds(364, 56, 104, 20);
		panelAccesorios.add(txtInv_acc);
		
		JLabel lblPre_acc = new JLabel("Precio:");
		lblPre_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPre_acc.setBounds(489, 57, 78, 16);
		panelAccesorios.add(lblPre_acc);
		
		txtPre_acc = new JTextField();
		txtPre_acc.setColumns(10);
		txtPre_acc.setBounds(547, 56, 104, 20);
		panelAccesorios.add(txtPre_acc);

		Object[][] datos = {
				{"", "", "", "", ""},
		};
		String[] Encabezados = {"Clave", "Nombre", "Marca", "Stock","Precio" };
		DefaultTableModel modelo = new DefaultTableModel(datos, Encabezados);
		
		tabla_acc = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla_acc);
		scrollPane.setBounds(64, 161, 677, 357);
		
		panelAccesorios.add(scrollPane);
		
		return panelAccesorios;
	}
	
	
	JPanel panelCel;
	JButton btnMostrar = new JButton("Mostrar");
	JButton btnAgregar = new JButton("Agregar");
	JButton btnBuscar;
	JButton btnActualizar;
	JButton btnEliminar;
	JTable tabla;
	
	JTextField txtCve_cel;
	JTextField txtNom_cel;
	JTextField txtCve_marca;
	JComboBox  cbbRam_cel;
	JComboBox  cbbRom_cel;
	JTextField txtIMEI;
	JTextField txtInv_cel;
	JTextField txtPre_cel;
	
	public JPanel panelCelulares()
	{
		setBounds(100, 100, 829, 579);
		panelCel = new JPanel();
		panelCel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCel.setLayout(null);
		
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMostrar.setBounds(187, 161, 137, 34);
		panelCel.add(btnMostrar);
		
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAgregar.setBounds(39, 161, 137, 34);
		panelCel.add(btnAgregar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(335, 161, 137, 34);
		panelCel.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(631, 161, 137, 34);
		panelCel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar.setBounds(483, 161, 137, 34);
		panelCel.add(btnActualizar);
		
		JLabel lblNom_acc = new JLabel("Nombre:");
		lblNom_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom_acc.setBounds(208, 30, 78, 16);
		panelCel.add(lblNom_acc);
		
		JLabel lblCve_cel = new JLabel("Clave:");
		lblCve_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_cel.setBounds(39, 30, 78, 16);
		panelCel.add(lblCve_cel);
		
		txtCve_cel = new JTextField();
		txtCve_cel.setBounds(86, 28, 104, 20);
		panelCel.add(txtCve_cel);
		txtCve_cel.setColumns(10);
		
		txtNom_cel = new JTextField();
		txtNom_cel.setBounds(281, 29, 445, 20);
		panelCel.add(txtNom_cel);
		txtNom_cel.setColumns(10);
		
		JLabel lblCve_marca = new JLabel("Clave de marca:");
		lblCve_marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_marca.setBounds(39, 60, 137, 16);
		panelCel.add(lblCve_marca);
		
		txtCve_marca = new JTextField();
		txtCve_marca.setColumns(10);
		txtCve_marca.setBounds(158, 59, 104, 20);
		panelCel.add(txtCve_marca);
		
		JLabel lblRam_cel = new JLabel("RAM:");
		lblRam_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRam_cel.setBounds(281, 61, 43, 16);
		panelCel.add(lblRam_cel);
		
		cbbRam_cel = new JComboBox();
		cbbRam_cel.setModel(new DefaultComboBoxModel(new String[] {"4", "8", "12", "16"}));
		cbbRam_cel.setBounds(328, 59, 70, 20);
		panelCel.add(cbbRam_cel);
		
		cbbRom_cel = new JComboBox();
		cbbRom_cel.setModel(new DefaultComboBoxModel(new String[] {"32", "64", "128", "256", "512"}));
		cbbRom_cel.setBounds(471, 59, 70, 20);
		panelCel.add(cbbRom_cel);
		
		JLabel lblRom_cel_1 = new JLabel("ROM:");
		lblRom_cel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRom_cel_1.setBounds(424, 61, 43, 16);
		panelCel.add(lblRom_cel_1);
		
		JLabel lblIMEI = new JLabel("IMEI:");
		lblIMEI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIMEI.setBounds(39, 89, 78, 16);
		panelCel.add(lblIMEI);
		
		txtIMEI = new JTextField();
		txtIMEI.setColumns(10);
		txtIMEI.setBounds(86, 88, 445, 20);
		panelCel.add(txtIMEI);
		
		JLabel lblInv_cel = new JLabel("En stock:");
		lblInv_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInv_cel.setBounds(39, 121, 78, 16);
		panelCel.add(lblInv_cel);
		
		txtInv_cel = new JTextField();
		txtInv_cel.setColumns(10);
		txtInv_cel.setBounds(112, 120, 104, 20);
		panelCel.add(txtInv_cel);
		
		JLabel lblPre_cel = new JLabel("Precio:");
		lblPre_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPre_cel.setBounds(237, 121, 78, 16);
		panelCel.add(lblPre_cel);
		
		txtPre_cel = new JTextField();
		txtPre_cel.setColumns(10);
		txtPre_cel.setBounds(295, 120, 104, 20);
		panelCel.add(txtPre_cel);
		
		Object[][] datos = {
				{"", "", "", "", "", "", "", ""},
		};
		String[] Encabezados = {"Clave", "Nombre", "Marca", "RAM", "ROM", "IMEI", "Stock","Precio" };
		DefaultTableModel modelo = new DefaultTableModel(datos, Encabezados);
		
		tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(64, 207, 677, 311);
		
		panelCel.add(scrollPane);
		
		return panelCel;
	}

	
	
	
}
