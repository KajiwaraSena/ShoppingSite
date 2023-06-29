package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Login;

public class LoginDAO extends DAO {

	public Login search(String name, String password) throws Exception {
		Login login = null;

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM customer_tb WHERE name= ? and password= ?");
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			login = new Login();
			login.setId(rs.getString("id"));
			login.setName(rs.getString("name"));
			login.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return login;

	}
}