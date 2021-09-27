package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	private Connection conn;

	public Account(Connection conn) {
		this.conn = conn;
	}

	public boolean login(String email, String password) throws SQLException {
		String sql = "select count(*) as count from userdata where email=? and password=?";

		PreparedStatement st = conn.prepareStatement(sql);

		st.setString(1, email);
		st.setString(2, password);

		ResultSet rs = st.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt("count");
		}

		rs.close();

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean exists(String email) throws SQLException {
		String sql = "select count(*) as count from userdata where email=?";

		PreparedStatement st = conn.prepareStatement(sql);

		
		st.setString(1, email);

		ResultSet rs = st.executeQuery();

		int count = 0;

		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		rs.close();

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void create(String email, String password) throws SQLException {
		String sql = "insert into userdata values(?,?)";

		PreparedStatement st = conn.prepareStatement(sql);

		st.setString(1, email);
		st.setString(2, password);

		st.executeUpdate();
		st.close();
	}
}
