package mx.com.cursodia.java21.semana3;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class vistaCelulares extends JPanel
{
	JPanel panelCel;
	JButton btnMostrar = new JButton("Mostrar");
	JButton btnAgregar = new JButton("Agregar");
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(335, 161, 137, 34);
		panelCel.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(631, 161, 137, 34);
		panelCel.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
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
				{"", "", "", "", "", "", ""},
		};
		String[] Encabezados = {"Clave", "Nombre", "Marca", "RAM", "ROM", "IMEI", "Stock","Precio" };
		DefaultTableModel modelo = new DefaultTableModel(datos, Encabezados);
		
		tabla = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(64, 207, 677, 311);
		
		panelCel.add(scrollPane);
		
		System.out.println("Estado inicial del botón: " + btnMostrar.isEnabled());
		
		return panelCel;
	}
	
}



