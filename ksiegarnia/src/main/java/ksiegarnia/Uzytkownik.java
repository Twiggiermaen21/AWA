package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the uzytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="Uzytkownik.findAll", query="SELECT u FROM Uzytkownik u")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUzytkownik;

	private byte aktywny;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_aktualizacji;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data_utworzenia;

	private String email;

	private String haslo;

	private int id_aktualizacji;

	private String imie;

	private String nazwisko;

	//bi-directional many-to-one association to UzytkownikHasRola
	@OneToMany(mappedBy="uzytkownik")
	private List<UzytkownikHasRola> uzytkownikHasRolas;

	//bi-directional many-to-one association to Zamowienia
	@OneToMany(mappedBy="uzytkownik")
	private List<Zamowienia> zamowienias;

	public Uzytkownik() {
	}

	public int getIdUzytkownik() {
		return this.idUzytkownik;
	}

	public void setIdUzytkownik(int idUzytkownik) {
		this.idUzytkownik = idUzytkownik;
	}

	public byte getAktywny() {
		return this.aktywny;
	}

	public void setAktywny(byte aktywny) {
		this.aktywny = aktywny;
	}

	public Date getData_aktualizacji() {
		return this.data_aktualizacji;
	}

	public void setData_aktualizacji(Date data_aktualizacji) {
		this.data_aktualizacji = data_aktualizacji;
	}

	public Date getData_utworzenia() {
		return this.data_utworzenia;
	}

	public void setData_utworzenia(Date data_utworzenia) {
		this.data_utworzenia = data_utworzenia;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public int getId_aktualizacji() {
		return this.id_aktualizacji;
	}

	public void setId_aktualizacji(int id_aktualizacji) {
		this.id_aktualizacji = id_aktualizacji;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public List<UzytkownikHasRola> getUzytkownikHasRolas() {
		return this.uzytkownikHasRolas;
	}

	public void setUzytkownikHasRolas(List<UzytkownikHasRola> uzytkownikHasRolas) {
		this.uzytkownikHasRolas = uzytkownikHasRolas;
	}

	public UzytkownikHasRola addUzytkownikHasRola(UzytkownikHasRola uzytkownikHasRola) {
		getUzytkownikHasRolas().add(uzytkownikHasRola);
		uzytkownikHasRola.setUzytkownik(this);

		return uzytkownikHasRola;
	}

	public UzytkownikHasRola removeUzytkownikHasRola(UzytkownikHasRola uzytkownikHasRola) {
		getUzytkownikHasRolas().remove(uzytkownikHasRola);
		uzytkownikHasRola.setUzytkownik(null);

		return uzytkownikHasRola;
	}

	public List<Zamowienia> getZamowienias() {
		return this.zamowienias;
	}

	public void setZamowienias(List<Zamowienia> zamowienias) {
		this.zamowienias = zamowienias;
	}

	public Zamowienia addZamowienia(Zamowienia zamowienia) {
		getZamowienias().add(zamowienia);
		zamowienia.setUzytkownik(this);

		return zamowienia;
	}

	public Zamowienia removeZamowienia(Zamowienia zamowienia) {
		getZamowienias().remove(zamowienia);
		zamowienia.setUzytkownik(null);

		return zamowienia;
	}

}