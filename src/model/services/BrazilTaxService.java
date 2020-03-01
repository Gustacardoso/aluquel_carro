package model.services;

public class BrazilTaxService implements TaxService {
	
	public double tax(double amount) {
		//metodo que delega as taxas 
		if(amount <= 100) { 
			/*se o valor for menor que 100 sera 
			 * acrementado  uma taxa de 20%
			 */
		 return amount * 0.2;
		}
		 else {
			 return amount * 0.15;
		     }
		}
	}


