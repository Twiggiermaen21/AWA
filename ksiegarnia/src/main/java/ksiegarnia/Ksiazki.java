package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the ksiazki database table.
 * 
 */
@Entity
@NamedQuery(name="Ksiazki.findAll", query="SELECT k FROM Ksiazki k")
public class Ksiazki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKsiazki;

	private double cena;

	private int ilosc_stron;

	private int ilosc_sztuk;

	@Lob
	@Column(name="img_url")
	private String imgUrl;

	private String opis;

	private String tytul;

	//bi-directional many-to-one association to KsiazkiHasAutorKsiazki
	@OneToMany(mappedBy="ksiazki")
	private List<KsiazkiHasAutorKsiazki> ksiazkiHasAutorKsiazkis;

	//bi-directional many-to-one association to ZamowieniaHasKsiazki
	@OneToMany(mappedBy="ksiazki")
	private List<ZamowieniaHasKsiazki> zamowieniaHasKsiazkis;

	public Ksiazki() {
	}

	public int getIdKsiazki() {
		return this.idKsiazki;
	}

	public void setIdKsiazki(int idKsiazki) {
		this.idKsiazki = idKsiazki;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getIlosc_stron() {
		return this.ilosc_stron;
	}

	public void setIlosc_stron(int ilosc_stron) {
		this.ilosc_stron = ilosc_stron;
	}

	public int getIlosc_sztuk() {
		return this.ilosc_sztuk;
	}

	public void setIlosc_sztuk(int ilosc_sztuk) {
		this.ilosc_sztuk = ilosc_sztuk;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getTytul() {
		return this.tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public List<KsiazkiHasAutorKsiazki> getKsiazkiHasAutorKsiazkis() {
		return this.ksiazkiHasAutorKsiazkis;
	}

	public void setKsiazkiHasAutorKsiazkis(List<KsiazkiHasAutorKsiazki> ksiazkiHasAutorKsiazkis) {
		this.ksiazkiHasAutorKsiazkis = ksiazkiHasAutorKsiazkis;
	}

	public KsiazkiHasAutorKsiazki addKsiazkiHasAutorKsiazki(KsiazkiHasAutorKsiazki ksiazkiHasAutorKsiazki) {
		getKsiazkiHasAutorKsiazkis().add(ksiazkiHasAutorKsiazki);
		ksiazkiHasAutorKsiazki.setKsiazki(this);

		return ksiazkiHasAutorKsiazki;
	}

	public KsiazkiHasAutorKsiazki removeKsiazkiHasAutorKsiazki(KsiazkiHasAutorKsiazki ksiazkiHasAutorKsiazki) {
		getKsiazkiHasAutorKsiazkis().remove(ksiazkiHasAutorKsiazki);
		ksiazkiHasAutorKsiazki.setKsiazki(null);

		return ksiazkiHasAutorKsiazki;
	}

	public List<ZamowieniaHasKsiazki> getZamowieniaHasKsiazkis() {
		return this.zamowieniaHasKsiazkis;
	}

	public void setZamowieniaHasKsiazkis(List<ZamowieniaHasKsiazki> zamowieniaHasKsiazkis) {
		this.zamowieniaHasKsiazkis = zamowieniaHasKsiazkis;
	}

	public ZamowieniaHasKsiazki addZamowieniaHasKsiazki(ZamowieniaHasKsiazki zamowieniaHasKsiazki) {
		getZamowieniaHasKsiazkis().add(zamowieniaHasKsiazki);
		zamowieniaHasKsiazki.setKsiazki(this);

		return zamowieniaHasKsiazki;
	}

	public ZamowieniaHasKsiazki removeZamowieniaHasKsiazki(ZamowieniaHasKsiazki zamowieniaHasKsiazki) {
		getZamowieniaHasKsiazkis().remove(zamowieniaHasKsiazki);
		zamowieniaHasKsiazki.setKsiazki(null);

		return zamowieniaHasKsiazki;
	}

}