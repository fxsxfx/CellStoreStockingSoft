package beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")

public class Marca
{

	@Id @GeneratedValue
	private int cve_marca;
	private String nom_marca;
	private int cveprov_marca;
	
	public Marca(int cve_marca, String nom_marca, int cveprov_marca) {
		super();
		this.cve_marca = cve_marca;
		this.nom_marca = nom_marca;
		this.cveprov_marca = cveprov_marca;
	}
	
	public Marca()
	{
		
	}
	
	public String getNom_marca()
	{
		return nom_marca;
	}
	public void setNom_marca(String nom_marca)
	{
		this.nom_marca = nom_marca;
	}
	public int getCveprov_marca()
	{
		return cveprov_marca;
	}
	public void setCveprov_marca(int cveprov_marca)
	{
		this.cveprov_marca = cveprov_marca;
	}
	public int getCve_marca()
	{
		return cve_marca;
	}
	
	
}
