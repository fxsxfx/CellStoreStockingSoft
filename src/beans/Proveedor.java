package beans;

public class Proveedor
{
	int cve_prov;
	String nom_prov;
	String mail_prov;
	String tel_prov;
	String dir_prov;
	
	public Proveedor(int cve_prov, String nom_prov, String mail_prov, String tel_prov, String dir_prov) {
		super();
		this.cve_prov = cve_prov;
		this.nom_prov = nom_prov;
		this.mail_prov = mail_prov;
		this.tel_prov = tel_prov;
		this.dir_prov = dir_prov;
	}
	
	public String getNom_prov()
	{
		return nom_prov;
	}
	public void setNom_prov(String nom_prov)
	{
		this.nom_prov = nom_prov;
	}
	public String getMail_prov()
	{
		return mail_prov;
	}
	public void setMail_prov(String mail_prov)
	{
		this.mail_prov = mail_prov;
	}
	public String getTel_prov()
	{
		return tel_prov;
	}
	public void setTel_prov(String tel_prov)
	{
		this.tel_prov = tel_prov;
	}
	public String getDir_prov()
	{
		return dir_prov;
	}
	public void setDir_prov(String dir_prov)
	{
		this.dir_prov = dir_prov;
	}
	public int getCve_prov()
	{
		return cve_prov;
	}
	
}
