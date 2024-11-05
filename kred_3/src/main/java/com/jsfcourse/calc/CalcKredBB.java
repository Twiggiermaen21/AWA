package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.ResourceBundle;

//import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CalcKredBB implements Serializable {
	private Double kwota;
	private Double miesiecy;
	private Double oprocentowanie;
	private Double result;
	private Double koszt;
	private Double calkowitykoszt;
 
	
	

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalc}")
	private ResourceBundle txtCalc;

	@Inject
	FacesContext ctx;
	
	// Resource loaded "manually"
	// (here after initialization in @PostConstruct method)
	// (locale explicitly given - here based on the view )
	
	//@PostConstruct	
	//public void postConstruct() {
	// loading resource (notice the full "file" name)
	//	txtCalc = ResourceBundle.getBundle("resources.textCalc", ctx.getViewRoot().getLocale());
	//	txtCalcErr = ResourceBundle.getBundle("resources.textCalcErr", ctx.getViewRoot().getLocale());
	//}
	
	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Double getMiesiecy() {
		return miesiecy;
	}

	public void setMiesiecy(Double miesiecy) {
		this.miesiecy = miesiecy;
	}

	public Double getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(Double oprocentowanie) {
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


	public String calc() {
	
				
				
				try {
						
				 
				result =(double)Math.round((this.kwota * ((this.oprocentowanie / 100) / 12) * Math.pow((1 + ((this.oprocentowanie / 100) / 12)), this.miesiecy)) / (Math.pow((1 + ((this.oprocentowanie / 100) / 12)), this.miesiecy) - 1)*100)/100.0;
				calkowitykoszt = (double)Math.round(result * this.miesiecy*100)/100.0;
				koszt  =(double)Math.round((calkowitykoszt - this.kwota)*100)/100.0;
				
				
			} catch (Exception e) {
				return null;
				
			}
				ctx.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));
				ctx.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, txtCalc.getString("result") + ": " + result, null));
				ctx.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, txtCalc.getString("koszt") + ": " + koszt, null));
				ctx.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, txtCalc.getString("ckoszt") + ": " + calkowitykoszt, null));

		
			return null;

	}
	
	public String showresult() {
		
	//	try {	
	//		result =(double)Math.round((this.kwota * ((this.oprocentowanie / 100) / 12) * Math.pow((1 + ((this.oprocentowanie / 100) / 12)), this.miesiecy)) / (Math.pow((1 + ((this.oprocentowanie / 100) / 12)), this.miesiecy) - 1)*100)/100.0;
	//		calkowitykoszt = (double)Math.round(result * this.miesiecy*100)/100.0;
	//		koszt  =(double)Math.round((calkowitykoszt - this.kwota)*100)/100.0;
	//	} catch (Exception e) {
		//	return null;	
	//	}
		calc();
			return "showresult";
		
	}
	

}
