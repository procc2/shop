package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Category;
import Model.Value;

public class chartDAO {
	public ArrayList<Value> getAll(){
		categoryDAO dao = new categoryDAO();
		try {
			ArrayList<Value> list =new ArrayList<>();
			ProductDAO p_dao = new ProductDAO();
			for(Category c : dao.getListCategory()){
				list.add(new Value(c.getCategoryName(),p_dao.getListProductbyCategory(c.getCategoryID()).size() ));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		for(Value v: new chartDAO().getAll()){
			System.out.println(v.getName() + " "+ v.getValue() );
		}
	}
}
