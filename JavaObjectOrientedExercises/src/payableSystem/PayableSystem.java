package payableSystem;

import java.util.ArrayList;

public class PayableSystem {
	
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	static ArrayList<Payable> payables = new ArrayList<Payable>();
	
	private static int currentMonth = 6;
	
	public static void main(String[] args) {

		Date birthDateSalariedEmployee1 = new Date(4, 14, 1989);
		Date hireDateSalariedEmployee1 = new Date(6, 15, 2009);
		Payable salariedEmployee = new SalariedEmployee("Jubilee", "Sayin", "2009-0053-SSS-1", 14415.00, birthDateSalariedEmployee1, hireDateSalariedEmployee1);

		Date birthDateHourlyEmployee1 = new Date(6, 11, 1995);
		Date hireDateHourlyEmployee1 = new Date(3, 24, 2010);
		Payable hourlyEmployee = new HourlyEmployee("Pearly", "Sayin","2010-0134-SSS-1", birthDateHourlyEmployee1, hireDateHourlyEmployee1, 60.00, 248);
		
		Date birthDateCommissionEmployee1 = new Date(6, 26, 1998);
		Date hireDateCommissionEmployee1 = new Date(8, 15, 2012);
		Payable commisionEmployee = new CommissionEmployee("Jefferson", "Sayin", "2012-00256", birthDateCommissionEmployee1, hireDateCommissionEmployee1, 10000, .10); 

		Date birthDateBaseSalariedCommissionEmployee1 = new Date(8, 21, 1992);
		Date hireDateBaseSalariedCommissionEmployee1 = new Date(8, 22, 2014);
		Payable baseSalariedCommissionEmployee1 = new BasePlusCommissionEmployee("Leslie Anne","Sayin","2014-00369", birthDateBaseSalariedCommissionEmployee1, hireDateBaseSalariedCommissionEmployee1, 10000, .10, 14415);
		
		Date birthDatePieceWorker1 = new Date(8, 5, 1991);
		Date hireDatePieceWorker1 = new Date(6, 24, 2013);
		Employee pieceWorker = new PieceWorker("Nikki Nicholas", "Romero","2013-0274-SSS-2", birthDatePieceWorker1, hireDatePieceWorker1, 20.00, 248);
		
		Payable paperSupply = new Invoice("#0001", "Paper Supplies", 100, 128);
		Payable tables = new Invoice("#0002", "Tables", 5, 1300);
		
		
		payables.add(salariedEmployee);
		payables.add(hourlyEmployee);
		payables.add(commisionEmployee);
		payables.add(baseSalariedCommissionEmployee1);
		payables.add(pieceWorker);
		payables.add(paperSupply);
		payables.add(tables);
		
		addBasePlusCommissionEmployeeBonus();
		addBonus();
		
		
	}
	
	private static void addBasePlusCommissionEmployeeBonus() {
		for (Employee employee : employees) {
			System.out.println(employee);
			
			if(employee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee basePlusCommissionEmployee = (BasePlusCommissionEmployee) employee;
				basePlusCommissionEmployee.setBaseSalary(basePlusCommissionEmployee.getBaseSalary() * 1.10);
				System.out.printf("new base salary with 10%% increase is: $%,.2f\n", basePlusCommissionEmployee.getBaseSalary() );
			}
			System.out.println("Earnings " + employee.earnings() + "\n");
		}
	}
	
	private static void addBonus() {
		
		for (Employee employee : employees) {
			employee.toString();
			
			if(employee instanceof SalariedEmployee) {
				SalariedEmployee salaryBaseEmployee = (SalariedEmployee) employee;
				if( salaryBaseEmployee.getBirthMonth() == currentMonth) {
					System.out.println("New salary with bonus : " + (salaryBaseEmployee.earnings() + 100));
				}
			}
			else if(employee instanceof HourlyEmployee) {
				HourlyEmployee hourBaseEmployee = (HourlyEmployee) employee;
				if( hourBaseEmployee.getBirthMonth() == currentMonth) {
					System.out.println("New salary with bonus : " + (hourBaseEmployee.earnings() + 100));
				}
			}
			else if(employee instanceof CommissionEmployee) {
				CommissionEmployee commissionBaseEmployee = (CommissionEmployee) employee;
				if( commissionBaseEmployee.getBirthMonth() == currentMonth) {
					System.out.println("New salary with bonus : " + (commissionBaseEmployee.earnings() + 100));
				}
			}
			else if(employee instanceof BasePlusCommissionEmployee) {
				BasePlusCommissionEmployee basePlusCommissionEmployee = (BasePlusCommissionEmployee) employee;
				if( basePlusCommissionEmployee.getBirthMonth() == currentMonth) {
					System.out.println("New salary with bonus : " + (basePlusCommissionEmployee.earnings() + 100));
				}
			}
		}
	
	}
}

