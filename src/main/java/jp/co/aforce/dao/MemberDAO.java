package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Member;

public class MemberDAO extends DAO {
	//会員番号の重複チェック
		public int check(String USER_NAME, String PASSWORD, String NAME, String BIRTHDAY, String MAIL,
				String TEL, String POSTAL_CODE, String ADDRESS1, String ADDRESS2, String ADDRESS3) throws Exception {

			Connection con = getConnection();
			

			PreparedStatement st = con.prepareStatement(
					"SELECT COUNT(*) FROM Member WHERE USER_NAME = ? AND PASSWORD = ? AND NAME = ? AND BIRTHDAY = ? AND MAIL = ? AND TEL = ? AND POSTAL_CODE = ? AND ADDRESS1 = ? AND ADDRESS2 = ? AND ADDRESS3 = ?");

			
			st.setString(1, USER_NAME);
			st.setString(2, PASSWORD);
			st.setString(3, NAME);
			st.setString(4, BIRTHDAY);
			st.setString(5, MAIL);
			st.setString(6, TEL);
			st.setString(7, POSTAL_CODE);
			st.setString(8, ADDRESS1);
			st.setString(9, ADDRESS2);
			st.setString(10, ADDRESS3);
			ResultSet rs = st.executeQuery();
			
			int count = 0;
			
			while(rs.next()) {
				count = rs.getInt("count(*)");
			}
		
			st.close();
			con.close();

			return count;
		}
		
		public int checkpass(String PASSWORD) throws Exception {

			Connection con = getConnection();
			

			PreparedStatement st = con.prepareStatement(
					"SELECT COUNT(*) FROM Member WHERE PASSWORD = ?");

			
			
			st.setString(1, PASSWORD);
			ResultSet rs = st.executeQuery();
			
			int count = 0;
			
			while(rs.next()) {
				count = rs.getInt("count(*)");
			}
		
			st.close();
			con.close();

			return count;
		}

		//登録機能
		public int insert(Member m) throws Exception {
			//データベースの接続
			Connection con = getConnection();
			//実行SQL
			PreparedStatement st = con.prepareStatement(
					"INSERT INTO Member VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			//値のセット

			st.setString(1, m.getUSER_NAME());
			st.setString(2, m.getPASSWORD());
			st.setString(3, m.getNAME());
			st.setString(4, m.getBIRTHDAY());
			st.setString(5, m.getMAIL());
			st.setString(6, m.getTEL());
			st.setString(7, m.getPOSTAL_CODE());
			st.setString(8, m.getADDRESS1());
			st.setString(9, m.getADDRESS2());
			st.setString(10,m.getADDRESS3());
			st.setInt(11,m.getID());
			int line = st.executeUpdate();

			st.close();
			con.close();

			return line;

		}
		
		//会員番号の検索機能
			public List<Member> search(String USER_NAME) throws Exception {

				//データベースの接続
				Connection con = getConnection();
				//SQLの実行
				PreparedStatement st = con.prepareStatement("SELECT * FROM Member WHERE USER_NAME = ?");
				//インスタンス化
				Member m = new Member();
				List<Member> list = new ArrayList<>();
				st.setString(1, USER_NAME);
				ResultSet rs = 	st.executeQuery();
				//値のセット
				while(rs.next()) {
				m.setUSER_NAME(rs.getString("memberId"));
				m.setPASSWORD(rs.getString("PASSWORD"));
				m.setNAME(rs.getString("NAME"));
				m.setBIRTHDAY(rs.getString("BIRTHDAY"));
				m.setMAIL(rs.getString("MAIL"));
				m.setTEL(rs.getString("TEL"));
				m.setADDRESS1(rs.getString("ADDRESS1"));
				m.setADDRESS2(rs.getString("ADDRESS2"));
				m.setADDRESS3(rs.getString("ADDRESS3"));
				list.add(m);
				}
				//SQLの終了
				st.close();
				con.close();
				//値をセットしたlistを返す
				return list;
			}

//		//削除機能
//		public void delete(Info info) throws Exception {
	//
//			try {
//				Connection con = getConnection();
	//
			//PreparedStatement st = con.prepareStatement("DELETE FROM MenberInfo WHERE MemberId = ?");
//				st.setString(1, info.getMemberId());
//				st.setString(1, info.getMemberId());
//				st.setString(2, info.getLastName());
//				st.setString(3, info.getFirstName());
//				st.setString(4, info.getSex());
//				st.setInt(5, info.getBirthYear());
//				st.setInt(6, info.getBirthMonth());
//				st.setInt(7, info.getBirthDay());
//				st.setString(8, info.getJob());
//				st.setString(9, info.getPhoneNumber());
//				st.setString(10, info.getMailAddress());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	//
//		//更新機能
	//
//		public String update(Info info) throws Exception {
//			String success = "";
//			try {
//				Connection con = getConnection();
	//
//				PreparedStatement st = con.prepareStatement(
//						"UPDATE FROM MemberInfo SET LastName = ?,FirstName = ?, sex = ?, BirthYear = ?, BirthMonth = ?, BirthDay = ?, Job = ?, PhoneNumber = ?, MailAddress = ?  WHERE memberId = ?");
	//
//				st.setString(1, info.getMemberId());
//				st.setString(2, info.getLastName());
//				st.setString(3, info.getFirstName());
//				st.setString(4, info.getSex());
//				st.setInt(5, info.getBirthYear());
//				st.setInt(6, info.getBirthMonth());
//				st.setInt(7, info.getBirthDay());
//				st.setString(8, info.getJob());
//				st.setString(9, info.getPhoneNumber());
//				st.setString(10, info.getMailAddress());
	//
//				st.close();
//				con.close();
	//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return success;

//		}
}
