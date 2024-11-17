package ksiegarnia;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the wiadomosci database table.
 * 
 */
@Entity
@NamedQuery(name="Wiadomosci.findAll", query="SELECT w FROM Wiadomosci w")
public class Wiadomosci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idWiadomosci;

	private String email;

	private String name;

	@Lob
	private String text;

	public Wiadomosci() {
	}

	public int getIdWiadomosci() {
		return this.idWiadomosci;
	}

	public void setIdWiadomosci(int idWiadomosci) {
		this.idWiadomosci = idWiadomosci;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}