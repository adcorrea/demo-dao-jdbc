package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		try {
	
			System.out.println("=== TEST 01 Department findById");
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();		
			Department department = departmentDao.findById(2);
			System.out.println(department);
			
			System.out.println("=== TEST 02 Department findAll");
			List<Department> listDepartment = departmentDao.findAll();
			listDepartment.forEach(System.out::println);
			System.out.println();
			
			System.out.println("=== TEST 03 Department insert");
			department = new Department(null,"Others");
			departmentDao.insert(department);
			System.out.println(department);
			System.out.println();
			
			System.out.println("=== TEST 04 Department UPDATE");
			department = new Department(5,"Others2");
			departmentDao.update(department);
			System.out.println();
			
			System.out.println("=== TEST 05 Department DELETE");
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter an id to delete: ");
			int id = sc.nextInt();
			departmentDao.deleteById(id);
			System.out.println();
			
			sc.close();
			
			
		}
		catch(DbException e){
			e.printStackTrace();
		}
		finally {
			DB.closeConnection();
		}

	}

}
