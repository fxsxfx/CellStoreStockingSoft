package mx.com.cursodia.java21.semana3;

public class Launcher
{

	public static void main(String[] args)
	{
		VistaTabbed vt = new VistaTabbed();
		vistaCelulares vcel = new vistaCelulares();
		
		Modelo mod = new Modelo();
		ControladorCelulares con = new ControladorCelulares(vt, vcel, mod);
		
		con.lanzarVista();
	}

}
