package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Item;

public class ItemDAO extends DAO {
	//重複チェック
	public int check(String ITEM_NAME, String ENGLISH, String DERIVATION, int PRICE, String DATASHEET, String CATEGORY,
			String IMG) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"SELECT COUNT(*) FROM Item WHERE ITEM_NAME = ? AND ENGLISH = ? AND DERIVATION = ? AND PRICE = ? AND DATASHEET = ? AND CATEGORY = ? AND IMG = ?");

		st.setString(1, ITEM_NAME);
		st.setString(2, ENGLISH);
		st.setString(3, DERIVATION);
		st.setInt(4, PRICE);
		st.setString(5, DATASHEET);
		st.setString(6, CATEGORY);
		st.setString(7, IMG);
		ResultSet rs = st.executeQuery();

		int count = 0;

		while (rs.next()) {
			count = rs.getInt("count(*)");
		}

		st.close();
		con.close();

		return count;
	}
	

	//登録機能
	public int insert(Item i) throws Exception {
		//データベースの接続
				Connection con = getConnection();
		
		//自動コミットモードオフ
		//con.setAutoCommit(false);
		
		//実行SQL
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO Item VALUES(?,?,?,?,?,?,?,?,?)");
		//値のセット(サーブレットでsetで値を入れているためgetで値を取得)
		st.setString(1, i.getITEM_NAME());
		st.setString(2, i.getENGLISH());
		st.setString(3, i.getDERIVATION());
		st.setInt(4, i.getPRICE());
		st.setString(5, i.getDATASHEET());
		st.setString(6, i.getCATEGORY());
		st.setString(7, i.getIMG());
		st.setInt(8, i.getNO());
		st.setInt(9, i.getQuantity());
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}
	
	//商品更新・削除のための検索機能
		public List<Item> deletesearch(String keyword) throws Exception {

			//データベースの接続
			Connection con = getConnection();
			//SQLの実行
			PreparedStatement st = con.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME = ?");
			
			 st.setString(1, keyword);

			List<Item> list = new ArrayList<>();
			ResultSet rs = st.executeQuery();
			//値のセット
			while (rs.next()) {
				Item i = new Item();
				i.setITEM_NAME(rs.getString("ITEM_NAME"));
				i.setENGLISH(rs.getString("ENGLISH"));
				i.setDERIVATION(rs.getString("DERIVATION"));
				i.setPRICE(rs.getInt("PRICE"));
				i.setDATASHEET(rs.getString("DATASHEET"));
				i.setCATEGORY(rs.getString("CATEGORY"));
				i.setIMG(rs.getString("IMG"));
				i.setNO(rs.getInt("NO"));
				list.add(i);
			}
			//SQLの終了
			st.close();
			con.close();
			//値をセットしたlistを返す
			return list;
		}
	
	//商品の削除
	public int delete(String ITEM_NAME) throws Exception {
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con.prepareStatement("DELETE FROM Item WHERE ITEM_NAME = ?");
		
		st.setString(1,  ITEM_NAME);
		int line = st.executeUpdate();
		st.close();
		con.close();

		return line;

		
	}

	//商品の一覧表示
	public List<Item> getAllItems() throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con.prepareStatement("SELECT * FROM Item");
		//インスタンス化

		List<Item> list = new ArrayList<>();
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}

	//商品検索機能(全体)
	public List<Item> search(String keyword) throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ?");
		//インスタンス化

		List<Item> list = new ArrayList<>();
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}

	//カートに追加
	public List<Item> getItemById(int itemId) throws Exception {
		List<Item> list = new ArrayList<>();
		
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con.prepareStatement("SELECT * FROM Item WHERE NO = ?");
		
		st.setInt(1, itemId);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			i.setQuantity(rs.getInt("Quantity"));
			list.add(i);
		}
		rs.close();
	    st.close();
	    con.close();
		return list;

	}

	//商品検索機能(心臓)
	public List<Item> searchHeart(String keyword) throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ? AND CATEGORY = '心臓' ");
		//インスタンス化

		List<Item> list = new ArrayList<>();
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}

	//商品検索機能(腎臓)
	public List<Item> searchKidney(String keyword) throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con
				.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ? AND CATEGORY = '腎臓'");
		//インスタンス化

		List<Item> list = new ArrayList<>();
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}

	//商品検索機能(筋肉)
	public List<Item> searchMuscle(String keyword) throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con
				.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ? AND CATEGORY = '筋肉'");
		//インスタンス化
		List<Item> list = new ArrayList<>();
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}

	//商品検索機能(皮膚)
		public List<Item> searchSkin(String keyword) throws Exception {

			//データベースの接続
			Connection con = getConnection();
			//SQLの実行
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ? AND CATEGORY = '皮膚'");
			//インスタンス化

			List<Item> list = new ArrayList<>();
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();
			//値のセット
			while (rs.next()) {
				Item i = new Item();
				i.setITEM_NAME(rs.getString("ITEM_NAME"));
				i.setENGLISH(rs.getString("ENGLISH"));
				i.setDERIVATION(rs.getString("DERIVATION"));
				i.setPRICE(rs.getInt("PRICE"));
				i.setDATASHEET(rs.getString("DATASHEET"));
				i.setCATEGORY(rs.getString("CATEGORY"));
				i.setIMG(rs.getString("IMG"));
				i.setNO(rs.getInt("NO"));
				list.add(i);
			}
			//SQLの終了
			st.close();
			con.close();
			//値をセットしたlistを返す
			return list;
		}
	

	//商品検索機能(血管)
	public List<Item> searchBlood(String keyword) throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con
				.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ? AND CATEGORY = '血管'");
		//インスタンス化

		List<Item> list = new ArrayList<>();
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}
	
	//商品検索機能(肝臓)
	public List<Item> searchLiver(String keyword) throws Exception {

		//データベースの接続
		Connection con = getConnection();
		//SQLの実行
		PreparedStatement st = con
				.prepareStatement("SELECT * FROM Item WHERE ITEM_NAME like ? AND CATEGORY = '肝臓'");
		//インスタンス化

		List<Item> list = new ArrayList<>();
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//値のセット
		while (rs.next()) {
			Item i = new Item();
			i.setITEM_NAME(rs.getString("ITEM_NAME"));
			i.setENGLISH(rs.getString("ENGLISH"));
			i.setDERIVATION(rs.getString("DERIVATION"));
			i.setPRICE(rs.getInt("PRICE"));
			i.setDATASHEET(rs.getString("DATASHEET"));
			i.setCATEGORY(rs.getString("CATEGORY"));
			i.setIMG(rs.getString("IMG"));
			i.setNO(rs.getInt("NO"));
			list.add(i);
		}
		//SQLの終了
		st.close();
		con.close();
		//値をセットしたlistを返す
		return list;
	}

}
