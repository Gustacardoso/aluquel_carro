package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new  Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental data (entre com a data do  aluquel))");
		System.out.print("Car model(modelo do  carro)");
	    String carmodel = sc.nextLine();
		System.out.print("Ickup(dd/MM/yyyy HH:mm):(horario de saida do aluquel) ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyy HH:mm):(horario de entrega )");
		Date finish = sdf.parse(sc.nextLine());
		
		//no contrutor carRental  mandamos para ele a hora do inicio do aluquel e a 
		//hora de saida, junto foi o modelo do  carro
		CarRental cr = new CarRental(start, finish, new Vehicle(carmodel));
		
		System.out.print("Enter price per hour:(informe o preço por hora)");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enterprice per day:(informe o preço  por dia)");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
        rentalService.processInvoice(cr);
        
        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total Payment: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));
        
        sc.close();
	}

}
