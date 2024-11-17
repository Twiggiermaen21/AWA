package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the ksiazki_has_autor_ksiazki database table.
 * 
 */
@Entity
@Table(name="ksiazki_has_autor_ksiazki")
@NamedQuery(name="KsiazkiHasAutorKsiazki.findAll", query="SELECT k FROM KsiazkiHasAutorKsiazki k")
public class KsiazkiHasAutorKsiazki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKsiazki_has_Autor;

	//bi-directional many-to-one association to AutorKsiazki
	@ManyToOne
	@JoinColumn(name="Autor_Ksiazki_idAutor_Ksiazki")
	private AutorKsiazki autorKsiazki;

	//bi-directional many-to-one association to Ksiazki
	@ManyToOne
	private Ksiazki ksiazki;

	public KsiazkiHasAutorKsiazki() {
	}

	public int getIdKsiazki_has_Autor() {
		return this.idKsiazki_has_Autor;
	}

	public void setIdKsiazki_has_Autor(int idKsiazki_has_Autor) {
		this.idKsiazki_has_Autor = idKsiazki_has_Autor;
	}

	public AutorKsiazki getAutorKsiazki() {
		return this.autorKsiazki;
	}

	public void setAutorKsiazki(AutorKsiazki autorKsiazki) {
		this.autorKsiazki = autorKsiazki;
	}

	public Ksiazki getKsiazki() {
		return this.ksiazki;
	}

	public void setKsiazki(Ksiazki ksiazki) {
		this.ksiazki = ksiazki;
	}

}