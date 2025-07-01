package beans;

public class Accesorio
{
	int cve_art;
	String nom_acc;
	int cvemarca_acc;
	int inv_acc;
	float pre_acc;
	
	public Accesorio(int cve_art, String nom_acc, int cvemarca_acc, int inv_acc, float pre_acc) {
		super();
		this.cve_art = cve_art;
		this.nom_acc = nom_acc;
		this.cvemarca_acc = cvemarca_acc;
		this.inv_acc = inv_acc;
		this.pre_acc = pre_acc;
	}
	
	public int getCve_art()
	{
		return cve_art;
	}

	public String getNom_acc()
	{
		return nom_acc;
	}

	public void setNom_acc(String nom_acc)
	{
		this.nom_acc = nom_acc;
	}

	public int getCvemarca_acc()
	{
		return cvemarca_acc;
	}

	public void setCvemarca_acc(int cvemarca_acc)
	{
		this.cvemarca_acc = cvemarca_acc;
	}

	public int getInv_acc()
	{
		return inv_acc;
	}

	public void setInv_acc(int inv_acc)
	{
		this.inv_acc = inv_acc;
	}

	public float getPre_acc()
	{
		return pre_acc;
	}

	public void setPre_acc(float pre_acc)
	{
		this.pre_acc = pre_acc;
	}

	
}
