package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the zamowienia database table.
 * 
 */
@Entity
@NamedQuery(name="Zamowienia.findAll", query="SELECT z FROM Zamowienia z")
public class Zamowienia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idzamowienia;

	private String adres;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_zamowienia;

	private String kodZamowienia;

	//bi-directional many-to-one association to Platnosci
	@ManyToOne
	private Platnosci platnosci;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	private Uzytkownik uzytkownik;

	//bi-directional many-to-one association to ZamowieniaHasKsiazki
	@OneToMany(mappedBy="zamowienia")
	private List<ZamowieniaHasKsiazki> zamowieniaHasKsiazkis;

	public Zamowienia() {
	}

	public int getIdzamowienia() {
		return this.idzamowienia;
	}

	public void setIdzamowienia(int idzamowienia) {
		this.idzamowienia = idzamowienia;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Date getData_zamowienia() {
		return this.data_zamowienia;
	}

	public void setData_zamowienia(Date data_zamowienia) {
		this.data_zamowienia = data_zamowienia;
	}

	public String getKodZamowienia() {
		return this.kodZamowienia;
	}

	public void setKodZamowienia(String kodZamowienia) {
		this.kodZamowienia = kodZamowienia;
	}

	public Platnosci getPlatnosci() {
		return this.platnosci;
	}

	public void setPlatnosci(Platnosci platnosci) {
		this.platnosci = platnosci;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public List<ZamowieniaHasKsiazki> getZamowieniaHasKsiazkis() {
		return this.zamowieniaHasKsiazkis;
	}

	public void setZamowieniaHasKsiazkis(List<ZamowieniaHasKsiazki> zamowieniaHasKsiazkis) {
		this.zamowieniaHasKsiazkis = zamowieniaHasKsiazkis;
	}

	public ZamowieniaHasKsiazki addZamowieniaHasKsiazki(ZamowieniaHasKsiazki zamowieniaHasKsiazki) {
		getZamowieniaHasKsiazkis().add(zamowieniaHasKsiazki);
		zamowieniaHasKsiazki.setZamowienia(this);

		return zamowieniaHasKsiazki;
	}

	public ZamowieniaHasKsiazki removeZamowieniaHasKsiazki(ZamowieniaHasKsiazki zamowieniaHasKsiazki) {
		getZamowieniaHasKsiazkis().remove(zamowieniaHasKsiazki);
		zamowieniaHasKsiazki.setZamowienia(null);

		return zamowieniaHasKsiazki;
	}

}