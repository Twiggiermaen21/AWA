package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the autor_ksiazki database table.
 * 
 */
@Entity
@Table(name="autor_ksiazki")
@NamedQuery(name="AutorKsiazki.findAll", query="SELECT a FROM AutorKsiazki a")
public class AutorKsiazki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAutor_Ksiazki;

	@Temporal(TemporalType.DATE)
	private Date data_urodzenia;

	private String imie;

	private String kraj_pochodzenia;

	private String nazwisko;

	//bi-directional many-to-one association to KsiazkiHasAutorKsiazki
	@OneToMany(mappedBy="autorKsiazki")
	private List<KsiazkiHasAutorKsiazki> ksiazkiHasAutorKsiazkis;

	public AutorKsiazki() {
	}

	public int getIdAutor_Ksiazki() {
		return this.idAutor_Ksiazki;
	}

	public void setIdAutor_Ksiazki(int idAutor_Ksiazki) {
		this.idAutor_Ksiazki = idAutor_Ksiazki;
	}

	public Date getData_urodzenia() {
		return this.data_urodzenia;
	}

	public void setData_urodzenia(Date data_urodzenia) {
		this.data_urodzenia = data_urodzenia;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getKraj_pochodzenia() {
		return this.kraj_pochodzenia;
	}

	public void setKraj_pochodzenia(String kraj_pochodzenia) {
		this.kraj_pochodzenia = kraj_pochodzenia;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public List<KsiazkiHasAutorKsiazki> getKsiazkiHasAutorKsiazkis() {
		return this.ksiazkiHasAutorKsiazkis;
	}

	public void setKsiazkiHasAutorKsiazkis(List<KsiazkiHasAutorKsiazki> ksiazkiHasAutorKsiazkis) {
		this.ksiazkiHasAutorKsiazkis = ksiazkiHasAutorKsiazkis;
	}

	public KsiazkiHasAutorKsiazki addKsiazkiHasAutorKsiazki(KsiazkiHasAutorKsiazki ksiazkiHasAutorKsiazki) {
		getKsiazkiHasAutorKsiazkis().add(ksiazkiHasAutorKsiazki);
		ksiazkiHasAutorKsiazki.setAutorKsiazki(this);

		return ksiazkiHasAutorKsiazki;
	}

	public KsiazkiHasAutorKsiazki removeKsiazkiHasAutorKsiazki(KsiazkiHasAutorKsiazki ksiazkiHasAutorKsiazki) {
		getKsiazkiHasAutorKsiazkis().remove(ksiazkiHasAutorKsiazki);
		ksiazkiHasAutorKsiazki.setAutorKsiazki(null);

		return ksiazkiHasAutorKsiazki;
	}

}