package beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //Anotacion para decirle al framework (Hibernate) que esto es una tabla en la base de datos (Entidad)
@Table(name = "celulares")



public class Celular
{
	@Id @GeneratedValue
	private int cve_cel;
	private String nom_cel;
	private int cvemarca_cel;
	@ManyToOne
	@JoinColumn(name = "cvemarca_cel", insertable = false, updatable = false)
	private Marca marca;

	private String ram_cel;
	private String rom_cel;
	private String imei;
	private int inv_cel;
	float pre_cel;
	
	
	public Celular(int cve_cel, String nom_cel, int cvemarca_cel, String ram_cel, String rom_cel, String imei,
			int inv_cel, float pre_cel) {
		super();
		this.cve_cel = cve_cel;
		this.nom_cel = nom_cel;
//		this.cvemarca_cel = cvemarca_cel;
		this.ram_cel = ram_cel;
		this.rom_cel = rom_cel;
		this.imei = imei;
		this.inv_cel = inv_cel;
		this.pre_cel = pre_cel;
	}
	
	public Celular()
	{
		
	}
	
	public Marca getMarca()
	{
		return marca;
	}
	
	public String getNom_cel()
	{
		return nom_cel;
	}
	public void setNom_cel(String nom_cel)
	{
		this.nom_cel = nom_cel;
	}
	public int getCvemarca_cel()
	{
		return cvemarca_cel;
	}
	public void setCvemarca_cel(int cvemarca_cel)
	{
		this.cvemarca_cel = cvemarca_cel;
	}
	public String getRam_cel()
	{
		return ram_cel;
	}
	public void setRam_cel(String ram_cel)
	{
		this.ram_cel = ram_cel;
	}
	public String getRom_cel()
	{
		return rom_cel;
	}
	public void setRom_cel(String rom_cel)
	{
		this.rom_cel = rom_cel;
	}
	public String getImei()
	{
		return imei;
	}
	public void setImei(String imei)
	{
		this.imei = imei;
	}
	public int getInv_cel()
	{
		return inv_cel;
	}
	public void setInv_cel(int inv_cel)
	{
		this.inv_cel = inv_cel;
	}
	public float getPre_cel()
	{
		return pre_cel;
	}
	public void setPre_cel(float pre_cel)
	{
		this.pre_cel = pre_cel;
	}
	public int getCve_cel()
	{
		return cve_cel;
	}

}