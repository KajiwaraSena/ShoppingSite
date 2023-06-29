package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingDao {
	
	 private Connection con_ = null;
	    private ResultSet rs_ = null;
	    private PreparedStatement ps_ = null;

	    public ShoppingDao() throws SQLException {
	        // JDBCドライバのロード
	        try {
	            // 「com.mysql.jdbc.Driver」クラス名
	            Class.forName("com.mysql.jdbc.Driver");

	            // データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
	            this.con_ = DriverManager.getConnection("jdbc:mysql://training-2023-db.cqf3ld6na4nc.ap-northeast-1.rds.amazonaws.com:3306/kajiwara_shoppingsite",
	                    "admin",
	                    "Aforce2023");
	        } catch (ClassNotFoundException cnfe) {
	            cnfe.printStackTrace();
	        }
	    }
	    
	    public ResultSet selectItem() throws SQLException {
	        // SQL文を生成
	        this.ps_ = this.con_.prepareStatement(
	                "select product_tb.product_id, product_tb.name, product_tb.price, stock.quantity from product_tb inner join stock on product_tb.product_id = stock.product_id"
	        );

	        // SQLを実行
	        this.rs_ = this.ps_.executeQuery();

	        return this.rs_;
	    }
	    
	    public ResultSet selectItem(String product_id) throws SQLException {
	        // SQL文を生成
	        this.ps_ = this.con_.prepareStatement(
	                "select product_tb.name, product_tb.price, stock.quantity from product_tb inner join stock on product_tb.product_id = stock.product_id where product_tb.product_id = ?"
	        );
	        // SQL文に商品IDを設定
	        this.ps_.setString(1, product_id);
	        // SQLを実行
	        this.rs_ = this.ps_.executeQuery();

	        return this.rs_;
	    }
	    
	    public void updateItem(String product_id, int purchased_num) throws SQLException {
	         // SQL文を生成
	        /* TODO:2-⑨update文を追加
	         在庫から購入数を引く
	         */
	        this.ps_ = this.con_.prepareStatement("update stock set quantity = quantity - ? where product_id = ?");

	        // SQL文に数量を設定
	        this.ps_.setInt(1, purchased_num);
	        // SQL文に商品IDを設定
	        this.ps_.setString(2, product_id);
	        // SQLを実行
	        this.ps_.executeUpdate();
	    }
	    
	    public void close() {
	        try {
	            // データベースとの接続を解除する
	            if (this.con_ != null) {
	                this.con_.close();
	            }
	            if (this.ps_ != null) {
	                this.ps_.close();
	            }
	            if (this.rs_ != null) {
	                this.rs_.close();
	            }
	        } catch (SQLException se) {
	            // データベースとの接続解除に失敗した場合
	            se.printStackTrace();
	        }
	    }
}
