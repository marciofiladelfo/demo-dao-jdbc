package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao obj = DaoFactory.createSellerDao();
		
		System.out.println("**** TEST 1: seller findById ****");
		Seller seller = obj.findById(3);
		System.out.println(seller);
		
		System.out.println("\n**** TEST 2: seller findByDepartment ****");
		Department department = new Department(2, null);
		List<Seller> list = obj.findByDepartment(department);
		for(Seller element : list) {
			System.out.println(element);
		}
		
		System.out.println("\n**** TEST 3: seller findAll ****");
		list = obj.findAll();
		for(Seller element : list) {
			System.out.println(element);
		}
		
		System.out.println("\n**** TEST 4: seller insert ****");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		obj.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n**** TEST 5: seller update ****");
		seller = obj.findById(1);
		seller.setName("Marcio Filadelfo");
		obj.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n**** TEST 6: seller delete ****");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		obj.deleteById(id);
		System.out.println("Delete completed");
		sc.close();
	}

}
