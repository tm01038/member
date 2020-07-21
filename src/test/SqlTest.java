package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.member.lib.common.Connector;

public class SqlTest {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = Connector.open();
		String sql = "insert into employee(emp_no, emp_name, emp_credat, emp_salary, grd_no)";
		sql +=" values(seq_emp_no.nextval,?,sysdate,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		String[] fNames = {"김","정","회","송","신","유","박","서","강","이"};
		String[] lNames = {"원영","인혁","경훈","윤상","동진","동제","상화","현배","영희","수정","미래"};
		Random r = new Random();
		for(int i=0; i<200; i++) {
			String fName = fNames[r.nextInt(fNames.length)];
			String lName = lNames[r.nextInt(lNames.length)];
			String name = fName +lName;
			int grade = r.nextInt(6)+1;
			int salary = (r.nextInt(5)+1)*1000000;
			
			ps.setString(1, name);
			ps.setInt(2, salary);
			ps.setInt(3, grade);
			System.out.println(i+";"+ps.executeUpdate());
		}
		conn.commit();
	}
	
	
}
