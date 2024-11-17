package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the zamowienia_has_ksiazki database table.
 * 
 */
@Entity
@Table(name="zamowienia_has_ksiazki")
@NamedQuery(name="ZamowieniaHasKsiazki.findAll", query="SELECT z FROM ZamowieniaHasKsiazki z")
public class ZamowieniaHasKsiazki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZamowienia_has_ksiazki;

	private int ilosc_ksiazek;

	//bi-directional many-to-one association to Ksiazki
	@ManyToOne
	private Ksiazki ksiazki;

	//bi-directional many-to-one association to Zamowienia
	@ManyToOne
	@JoinColumn(name="zamowienia_idzamówienia")
	private Zamowienia zamowienia;

	public ZamowieniaHasKsiazki() {
	}

	public int getIdZamowienia_has_ksiazki() {
		return this.idZamowienia_has_ksiazki;
	}

	public void setIdZamowienia_has_ksiazki(int idZamowienia_has_ksiazki) {
		this.idZamowienia_has_ksiazki = idZamowienia_has_ksiazki;
	}

	public int getIlosc_ksiazek() {
		return this.ilosc_ksiazek;
	}

	public void setIlosc_ksiazek(int ilosc_ksiazek) {
		this.ilosc_ksiazek = ilosc_ksiazek;
	}

	public Ksiazki getKsiazki() {
		return this.ksiazki;
	}

	public void setKsiazki(Ksiazki ksiazki) {
		this.ksiazki = ksiazki;
	}

	public Zamowienia getZamowienia() {
		return this.zamowienia;
	}

	public void setZamowienia(Zamowienia zamowienia) {
		this.zamowienia = zamowienia;
	}

}