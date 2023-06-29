package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Member;

public class LoginDAO extends DAO {

	public Member search(String USER_NAME, String PASSWORD) throws Exception {
		Member i = null;

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM Member WHERE USER_NAME = ? AND PASSWORD = ?");
		st.setString(1, USER_NAME);
		st.setString(2, PASSWORD);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			i = new Member();
			i.setUSER_NAME(rs.getString("USER_NAME"));
			i.setPASSWORD(rs.getString("PASSWORD"));
			i.setNAME(rs.getString("NAME"));
			i.setBIRTHDAY(rs.getString("BIRTHDAY"));
			i.setMAIL(rs.getString("MAIL"));
			i.setTEL(rs.getString("TEL"));
			i.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
			i.setADDRESS1(rs.getString("ADDRESS1"));
			i.setADDRESS2(rs.getString("ADDRESS2"));
			i.setADDRESS3(rs.getString("ADDRESS3"));
		}

		st.close();
		con.close();
		return i;

	}
}