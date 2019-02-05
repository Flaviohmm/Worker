package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String nameDepartment = scanner.nextLine();
		System.out.println("Enter worker data:  ");
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Level: ");
		String level = scanner.nextLine();
		System.out.print("Base Salary: ");
		double baseSalary = scanner.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(nameDepartment));

		System.out.print("How many contratcs to this worker? ");
		int contract = scanner.nextInt();

		for (int i = 1; i <= contract; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = simDateFormat.parse(scanner.next());
			System.out.print("Value per hour: ");
			double valuePerHours = scanner.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = scanner.nextInt();
			HourContract hourContract = new HourContract(date, valuePerHours, hours);
			worker.addContract(hourContract);
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = scanner.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + name);
		System.out.println("Department: " + nameDepartment);
		System.out.println("Income for " + monthAndYear + ": "+String.format("%.2f", worker.income(year, month)));

		scanner.close();
	}

}
