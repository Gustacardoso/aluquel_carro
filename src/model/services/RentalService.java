package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
    /*nesta classe iremos fazar a delegação
	 dos valores combrando  por horas e dia do aluqueis*/
	private Double pricePerday;
	private Double pricePerHour;
	
	public TaxService taxService;

	public RentalService(Double pricePerday, Double pricePerHour, TaxService taxService) {
		this.pricePerday = pricePerday;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	
	public Double getPricePerday() {
		return pricePerday;
	}


	public void setPricePerday(Double pricePerday) {
		this.pricePerday = pricePerday;
	}


	public Double getPricePerHour() {
		return pricePerHour;
	}


	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}


	public TaxService getTaxService() {
		return taxService;
	}


	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
     
	/*metodo de calcula das horas do aluquel, junto com a tax
	de serviço*/

	public void processInvoice(CarRental carRental){
		//temos que calcular usando  os milesgundos
		long t1 = carRental.getStart().getTime();
	    long t2 = carRental.getFinish().getTime();
	    double hours = (double)(t1 - t2) / 100 / 60 / 60;
	    
	    double basicPayment;
	    if(hours <= 12.0) {
	    	//multiplicando  o preco por hora, e usando um metodo para aredonda as hora.
	    	//se passar uns minutos ira cobrar a hora inteira
	    	basicPayment = pricePerHour * Math.ceil(hours);
	    }else {
	    	//dividimor por 24 para saber quando dias ficou alugado
	    	// ja que passou de 12 horas
	    	basicPayment = pricePerday * Math.ceil(hours / 24 ); 
	    }
	    
	    double tax = taxService.tax(basicPayment);
	    
	    carRental.setInvoice(new Invoice(basicPayment, tax));
	} 
		
}
	
	
	

