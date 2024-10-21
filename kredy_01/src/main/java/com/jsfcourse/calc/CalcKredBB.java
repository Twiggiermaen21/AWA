package com.jsfcourse.calc;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class CalcKredBB {
	private String kwota;
	private String miesiecy;
	private String oprocentowanie;
	private Double result;
	private Double koszt;
	private Double calkowitykoszt;
 
	@Inject
	FacesContext ctx;
	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getMiesiecy() {
		return miesiecy;
	}

	public void setMiesiecy(String miesiecy) {
		this.miesiecy = miesiecy;
	}

	public String getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(String oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	

	public Double getKoszt() {
		return koszt;
	}

	public void setKoszt(Double koszt) {
		this.koszt = koszt;
	}

	public Double getCalkowitykoszt() {
		return calkowitykoszt;
	}

	public void setCalkowitykoszt(Double calkowitykoszt) {
		this.calkowitykoszt = calkowitykoszt;
	}

	public boolean doTheMath() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double miesiecy = Double.parseDouble(this.miesiecy);
			double oprocentowanie = Double.parseDouble(this.oprocentowanie);

			 
			result =(double)Math.round((kwota * ((oprocentowanie / 100) / 12) * Math.pow((1 + ((oprocentowanie / 100) / 12)), miesiecy)) / (Math.pow((1 + ((oprocentowanie / 100) / 12)), miesiecy) - 1)*100)/100.0;
			calkowitykoszt = (double)Math.round(result * miesiecy*100)/100.0;
			koszt  =(double)Math.round((calkowitykoszt - kwota)*100)/100.0;
			
		
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nie podano parametrów lub nie są one liczbami", null));
			return false;
		}
	}

	
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}

	public String calc_AJAX() {
		if (doTheMath()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Miesieczna rata: " + result, null));
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Koszt kredytu: " + koszt, null));
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Całkowita zapłata: " + calkowitykoszt, null));

		
			
		}
		return null;
	}

}
