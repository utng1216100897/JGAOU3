package jgao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jgao.model.Die;

public class DieDAOImpl implements DieDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public DieDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "postgres", "1234");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createDie(Die die) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO die (age,service,enter_date,"
														+ "die_date,result) values (?,?,?,?,?);");
			preparedStatement.setLong(1,die.getAge() );
			preparedStatement.setString(2,die.getService());
			preparedStatement.setString(3,die.getEnter_date());
			preparedStatement.setString(4,die.getDie_date());
			preparedStatement.setString(5,die.getResult());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Die readDie(Long id) {
		Die die = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT id,age,service,enter_date,die_date,result FROM die WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					die = new Die(resultSet.getLong(1), resultSet.getLong(2), resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5),
											resultSet.getString(6));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return die;
	}

	@Override
	public List<Die> readAllDies() {
		List<Die> dies = new ArrayList<Die>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT id,age,service,enter_date,die_date,result FROM die");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Die die = new Die(resultSet.getLong(1), resultSet.getLong(2), resultSet.getString(3),
							resultSet.getString(4),
							resultSet.getString(5),
							resultSet.getString(6));
					dies.add(die);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return dies;
	}

	@Override
	public void updateDie(Die die) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE die SET age=?,service=?,enter_date=?,die_date=?,result=? "
										+ " WHERE id=?;");
				preparedStatement.setLong(1,die.getAge() );
				preparedStatement.setString(2,die.getService());
				preparedStatement.setString(3,die.getEnter_date());
				preparedStatement.setString(4,die.getDie_date());
				preparedStatement.setString(5,die.getResult());
				preparedStatement.setLong(6,die.getId());
				
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteDie(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM die WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

}
