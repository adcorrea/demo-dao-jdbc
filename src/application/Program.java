package application;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
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
			
			System.out.println("=== TEST 4 seller insert");
			Seller test = new Seller(null, "Junior", "junior@gmail.com", sdf.parse("24/08/1986"), 12000.0, department);
			sellerDao.insert(test);
			System.out.println(test);
			System.out.println();
			
			System.out.println("=== TEST 5 seller update");
			Seller testUpdate = new Seller(10, "Junior", "junior@gmail.com", sdf.parse("23/08/1986"), 12000.0, department);
			sellerDao.update(testUpdate);
			System.out.println();
			
			System.out.println("=== TEST 6 seller delete");			
			sellerDao.deleteById(12);
			System.out.println();
		}
		catch(DbException e){
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeConnection();
		}

		

	}

}
