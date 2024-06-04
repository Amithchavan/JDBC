package jdbc_crud;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbccrud {

	private static final String url="jdbc:mysql://localhost:3306/university";
	private static final String username="root";
	private static final String password="root";
	private static final String insert_query="insert into student04 value(?,?,?);";
	private static final String read_query="select * from student04";
	private static final String update_query="update student04 set marks=0 where id=?";
	private static final String delete_query ="delete from student04 where id=?";
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
				Connection con=DriverManager.getConnection(url,username,password);
				
				System.out.println("select an option");
				System.out.println("1 for insert");
				System.out.println("2 for select");
				System.out.println("3 for update");
				System.out.println("4 for delete");
				int val=sc.nextInt();
				switch(val) {
				case 1:{insert(con,sc);
				break;}
				case 2:{read(con,sc);
				break;}
				case 3:{update(con,sc);
				break;}
				case 4:{delete(con,sc);
				break;}
				default:System.out.print("invalid");
				
				}
						
				
		}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private static void delete(Connection con, Scanner sc) {
		try {
			PreparedStatement ps=	con.prepareStatement(delete_query);
			System.out.print("enetr id for delete");
			int id=sc.nextInt();
			ps.setInt(1,id);
			ps.execute();
			System.out.print("deleted");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	private static void update(Connection con, Scanner sc) {
	try {
		PreparedStatement ps=	con.prepareStatement(update_query);
		System.out.print("enetr id for update");
		int id=sc.nextInt();
		ps.setInt(1,id);
		ps.execute();
		System.out.print("updated");
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	private static void read(Connection con, Scanner sc) {
	try {
		PreparedStatement ps=	con.prepareStatement(read_query);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("id="+rs.getInt(1)+"name="+rs.getString(2)+"marks="+rs.getInt(3));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	private static void insert(Connection con, Scanner sc) {
		System.out.println("enetr id");
		int val=sc.nextInt();
		System.out.println("enetr name");
	String name=sc.next();
	sc.nextLine();

		System.out.println("enetr marks");
		int marks=sc.nextInt();
		
		try {
			PreparedStatement ps=con.prepareStatement(insert_query);
			ps.setInt(1, val);
			ps.setString(2, name);
			ps.setInt(3, marks);
			ps.execute();
			System.out.print("data inserted succefully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
	}
	

}

