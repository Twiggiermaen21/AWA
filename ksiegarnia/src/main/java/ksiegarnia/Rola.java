package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRola;

	private byte aktywnosc;

	private String nazwaRoli;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ostatnieUzycie;

	//bi-directional many-to-one association to UzytkownikHasRola
	@OneToMany(mappedBy="rola")
	private List<UzytkownikHasRola> uzytkownikHasRolas;

	public Rola() {
	}

	public int getIdRola() {
		return this.idRola;
	}

	public void setIdRola(int idRola) {
		this.idRola = idRola;
	}

	public byte getAktywnosc() {
		return this.aktywnosc;
	}

	public void setAktywnosc(byte aktywnosc) {
		this.aktywnosc = aktywnosc;
	}

	public String getNazwaRoli() {
		return this.nazwaRoli;
	}

	public void setNazwaRoli(String nazwaRoli) {
		this.nazwaRoli = nazwaRoli;
	}

	public Date getOstatnieUzycie() {
		return this.ostatnieUzycie;
	}

	public void setOstatnieUzycie(Date ostatnieUzycie) {
		this.ostatnieUzycie = ostatnieUzycie;
	}

	public List<UzytkownikHasRola> getUzytkownikHasRolas() {
		return this.uzytkownikHasRolas;
	}

	public void setUzytkownikHasRolas(List<UzytkownikHasRola> uzytkownikHasRolas) {
		this.uzytkownikHasRolas = uzytkownikHasRolas;
	}

	public UzytkownikHasRola addUzytkownikHasRola(UzytkownikHasRola uzytkownikHasRola) {
		getUzytkownikHasRolas().add(uzytkownikHasRola);
		uzytkownikHasRola.setRola(this);

		return uzytkownikHasRola;
	}

	public UzytkownikHasRola removeUzytkownikHasRola(UzytkownikHasRola uzytkownikHasRola) {
		getUzytkownikHasRolas().remove(uzytkownikHasRola);
		uzytkownikHasRola.setRola(null);

		return uzytkownikHasRola;
	}

}