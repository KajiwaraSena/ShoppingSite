package jp.co.aforce.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ShoppingDao;

public class Shopping {
	
	public ArrayList<ItemBean> getItem() {
        ArrayList<ItemBean> bean_list = new ArrayList<>();
        ShoppingDao dao = null;
        ResultSet rs;

        try {
            // DAOクラスをインスタンス化
            dao = new ShoppingDao();
            // 現在の商品一覧を検索
            rs = dao.selectItem();

            // 検索結果を1レコードずつ処理
            while (rs.next()) {
                // 商品IDを設定
                String product_id = rs.getString("product_id");
                // 商品名を設定
                String name = rs.getString("name");
                // 商品価格を設定
                int price = rs.getInt("price");
                // 商品数を設定
                int quantity = rs.getInt("quantity");

                // 商品一覧を格納するBeanクラスをインスタンス化
                ItemBean item_bean = new ItemBean(product_id, name, price, quantity);
                System.out.println("itembean: " + item_bean);
                // Beanクラスをリストに追加
                bean_list.add(item_bean);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            // 処理終了時に各接続を解除
            if (dao != null) {
                dao.close();
            }
        }
        return bean_list;
    }
	
	public ItemBean getItem(String product_id) {
        ItemBean item_bean = null;
        ShoppingDao dao = null;
        ResultSet rs;

        try {
            // DAOクラスをインスタンス化
            dao = new ShoppingDao();
            // 現在の商品一覧を検索
            rs = dao.selectItem(product_id);

            // 検索結果を処理
            while (rs.next()) {
                // 商品名を設定
                String name = rs.getString("name");
                // 商品価格を設定
                int price = rs.getInt("price");
                // 商品数を設定
                int quantity = rs.getInt("quantity");
                item_bean = new ItemBean(product_id, name, price, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 処理終了時に各接続を解除
            if (dao != null) {
                dao.close();
            }
        }
        return item_bean;
    }


}
