package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.AdminLogin;

public class AdminLoginDAO extends DAO {

	public AdminLogin search(String admin_id, String password) throws Exception {
		AdminLogin Adminlogin = null;

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM admin_tb WHERE admin_id= ? and password= ?");
		st.setString(1, admin_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Adminlogin = new AdminLogin();
			Adminlogin.setAdmin_Id(rs.getString("admin_id"));
			Adminlogin.setName(rs.getString("name"));
			Adminlogin.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return Adminlogin;

	}
}