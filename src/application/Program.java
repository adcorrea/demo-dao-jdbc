package application;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		try {
			
		
			System.out.println("=== TEST 1 seller findById");		
			SellerDao sellerDao = DaoFactory.createSellerDao();
			Seller seller = sellerDao.findById(3);		
			System.out.println(seller);
			System.out.println();
			
			System.out.println("=== TEST 2 seller findByDeparment");
			Department department = new Department(2, null);
			List<Seller> listSellerDao = sellerDao.findByDepartment(department);
			listSellerDao.forEach(System.out::println);
			System.out.println();
			
			System.out.println("=== TEST 3 seller findAll");
			listSellerDao = sellerDao.findAll();
			listSellerDao.forEach(System.out::println);
			System.out.println();
		}
		catch(DbException e){
			e.printStackTrace();
		}
		finally {
			DB.closeConnection();
		}

		

	}

}
