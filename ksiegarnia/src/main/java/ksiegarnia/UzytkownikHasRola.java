package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the uzytkownik_has_rola database table.
 * 
 */
@Entity
@Table(name="uzytkownik_has_rola")
@NamedQuery(name="UzytkownikHasRola.findAll", query="SELECT u FROM UzytkownikHasRola u")
public class UzytkownikHasRola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUzytkownik_has_Rola;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_nadania;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_zabrania;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	private Rola rola;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	private Uzytkownik uzytkownik;

	public UzytkownikHasRola() {
	}

	public int getIdUzytkownik_has_Rola() {
		return this.idUzytkownik_has_Rola;
	}

	public void setIdUzytkownik_has_Rola(int idUzytkownik_has_Rola) {
		this.idUzytkownik_has_Rola = idUzytkownik_has_Rola;
	}

	public Date getData_nadania() {
		return this.data_nadania;
	}

	public void setData_nadania(Date data_nadania) {
		this.data_nadania = data_nadania;
	}

	public Date getData_zabrania() {
		return this.data_zabrania;
	}

	public void setData_zabrania(Date data_zabrania) {
		this.data_zabrania = data_zabrania;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

}