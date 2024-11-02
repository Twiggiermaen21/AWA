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
	private String kwota;
	private String miesiecy;
	private String oprocentowanie;
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


	public String calc() {
		double kwota =0;
		double miesiecy=0;
		double oprocentowanie =0;
	
				 try {
					 kwota = Double.parseDouble(this.kwota);
					 if(kwota<=0 || kwota >1000000) {
							ctx.addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("kwota"), null));
				        	return null;

					 }
			        } catch(NumberFormatException e) {
			        	ctx.addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("kwotaliczba"), null));
			        	return null;
			        	

			        }
				 try {
						miesiecy = Double.parseDouble(this.miesiecy);
						 if(miesiecy<=0 || miesiecy >100) {
								ctx.addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("miesiecy"), null));
					        	return null;

						 }
			        } catch(NumberFormatException e) {
			        	ctx.addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("miesiecyliczba"), null));
			        	return null;

			        }
				 try {
						 oprocentowanie = Double.parseDouble(this.oprocentowanie);
						 if(oprocentowanie<=0.1 || oprocentowanie >100) {
								ctx.addMessage(null,
										new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("oprocentowanie"), null));
					        	return null;

						 }
			        } catch(NumberFormatException e) {
			        	ctx.addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("oprocentowanieliczba"), null));
			        	return null;
			        }
				 
				
				
				
				try {
						
				 
				result =(double)Math.round((kwota * ((oprocentowanie / 100) / 12) * Math.pow((1 + ((oprocentowanie / 100) / 12)), miesiecy)) / (Math.pow((1 + ((oprocentowanie / 100) / 12)), miesiecy) - 1)*100)/100.0;
				calkowitykoszt = (double)Math.round(result * miesiecy*100)/100.0;
				koszt  =(double)Math.round((calkowitykoszt - kwota)*100)/100.0;
				
				
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

}
