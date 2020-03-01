package model.entities;

public class Invoice {
    /* classe trata do faturamento, chamando os 
     * pagamento e as taxas de serviço*/
	
	private Double basicPayment;
	private Double tax;
	
	public Invoice() {
		
	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	/*metodo responsavel para mostrar total
	 *  paga pelo servico.*/
	
	public Double getTotalPayment() {
		return getBasicPayment() + getTax();
	}
	
}
