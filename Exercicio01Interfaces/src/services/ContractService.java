package services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		double baseInstallment = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate due = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(baseInstallment, i);
			double fee = onlinePaymentService.paymentFee(baseInstallment + interest);
			double installmentValue = baseInstallment + interest + fee;
			
			contract.getInstallments().add(new Installment(due, installmentValue));
		}
		
	}
	
}
