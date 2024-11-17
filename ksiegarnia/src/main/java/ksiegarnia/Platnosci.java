package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the platnosci database table.
 * 
 */
@Entity
@NamedQuery(name="Platnosci.findAll", query="SELECT p FROM Platnosci p")
public class Platnosci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlatnosci;

	@Temporal(TemporalType.DATE)
	private Date data_Platnosci;

	private int idUzytkownik;

	private String kodPlatnosci;

	private double kwota;

	private String rodzaj_płatnosci;

	//bi-directional many-to-one association to Zamowienia
	@OneToMany(mappedBy="platnosci")
	private List<Zamowienia> zamowienias;

	public Platnosci() {
	}

	public int getIdPlatnosci() {
		return this.idPlatnosci;
	}

	public void setIdPlatnosci(int idPlatnosci) {
		this.idPlatnosci = idPlatnosci;
	}

	public Date getData_Platnosci() {
		return this.data_Platnosci;
	}

	public void setData_Platnosci(Date data_Platnosci) {
		this.data_Platnosci = data_Platnosci;
	}

	public int getIdUzytkownik() {
		return this.idUzytkownik;
	}

	public void setIdUzytkownik(int idUzytkownik) {
		this.idUzytkownik = idUzytkownik;
	}

	public String getKodPlatnosci() {
		return this.kodPlatnosci;
	}

	public void setKodPlatnosci(String kodPlatnosci) {
		this.kodPlatnosci = kodPlatnosci;
	}

	public double getKwota() {
		return this.kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public String getRodzaj_płatnosci() {
		return this.rodzaj_płatnosci;
	}

	public void setRodzaj_płatnosci(String rodzaj_płatnosci) {
		this.rodzaj_płatnosci = rodzaj_płatnosci;
	}

	public List<Zamowienia> getZamowienias() {
		return this.zamowienias;
	}

	public void setZamowienias(List<Zamowienia> zamowienias) {
		this.zamowienias = zamowienias;
	}

	public Zamowienia addZamowienia(Zamowienia zamowienia) {
		getZamowienias().add(zamowienia);
		zamowienia.setPlatnosci(this);

		return zamowienia;
	}

	public Zamowienia removeZamowienia(Zamowienia zamowienia) {
		getZamowienias().remove(zamowienia);
		zamowienia.setPlatnosci(null);

		return zamowienia;
	}

}