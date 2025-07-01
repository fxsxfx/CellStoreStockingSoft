package mx.com.cursodia.java21.semana3;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import beans.Celular;

public class CRUDHibernate
{
	public static void main(String args[])
	{
		CRUDHibernate hib = new CRUDHibernate();
		hib.leerCelulares();
	}
	
	public void leerCelulares()
	{
		Session session = null;
		
		try {
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query<Celular> consulta = session.createQuery("from Celular", Celular.class);
			List<Celular> lista = consulta.getResultList();
			
			for(Celular C:lista)
			{
				System.out.println(C.getCve_cel()+"\t\t"+C.getNom_cel()+"\t\t"+C.getMarca().getCve_marca()+"\t\t"+C.getRam_cel()+"\t\t"+C.getRom_cel()+"\t\t"+C.getImei()+"\t\t"+C.getInv_cel()+"\t\t"+C.getPre_cel());
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(session != null) session.close();
		}
	}

}
