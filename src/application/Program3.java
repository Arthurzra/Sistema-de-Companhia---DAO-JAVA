package application;

import java.util.List;
import java.util.Scanner;

import model.dao.CompanyDao;
import model.dao.DaoFactory;
import model.entities.Company;

public class Program3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
			
		
		CompanyDao companyDao = DaoFactory.createCompanyDao();
		
		
		System.out.println("=== TEST 1: findById =======");
		Company comp = companyDao.findById(1);
		System.out.println(comp);

		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Company> list = companyDao.findAll();
		for (Company c : list) {
			System.out.println(c);
		}

		System.out.println("\n=== TEST 3: insert =======");
		Company newCompany = new Company(null, "FACECAR", "127126172");
		companyDao.insert(newCompany);
		System.out.println("Inserted! New id: " + newCompany.getId());

		System.out.println("\n=== TEST 4: update =======");
		Company comp2 = companyDao.findById(1);
		comp2.setName("META");
		companyDao.update(comp2);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		companyDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();

	}

}
