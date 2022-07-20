package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connect.Connect;
import Model.MessageModel;

public class MessageDAO {
	Connection con=Connect.getConnection();	
	public int insertmessage(MessageModel message) {
		int result=0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into global (sender,message) values(?,?)");
			ps.setString(1, message.getUsername());
			ps.setString(2, message.getMessage());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int Maxid() {
		int ans=0;
		try {
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery("select max(id) as maxid from global");
			while(result.next()) {
				ans=result.getInt("maxid");	
			}
			statement.close();
			//conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	public List<MessageModel>ConsoleResult(int id,int max){
		ArrayList<MessageModel> list=new ArrayList<>();
		try {
		PreparedStatement ps=con.prepareStatement("Select * from global where id>? and id<=?");
		ps.setInt(1,id);
		ps.setInt(2, max);
		ResultSet result=ps.executeQuery();
		while(result.next()) {
			list.add(new MessageModel(result.getInt(1),result.getString(2),result.getString(3)));
		}
		//con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
