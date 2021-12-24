package application;

import java.sql.SQLException;
import java.util.Date;

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
			
			System.out.println("=== TEST 2 Department findById");
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			Department dep = departmentDao.findById(2);
			System.out.print(dep);
		}
		catch(DbException e){
			e.printStackTrace();
		}
		finally {
			DB.closeConnection();
		}

		

	}

}
