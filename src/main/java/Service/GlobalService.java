package Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;


import com.google.gson.Gson;

import Database.MessageDAO;
import Model.MessageModel;

public class GlobalService {
	MessageDAO message=new MessageDAO();
public String GetnewMessage(int currentId,int maxid) throws ServletException, IOException{
	 List<MessageModel> list=message.ConsoleResult(currentId, maxid);
	 Gson json=new Gson();
	return json.toJson(list);
}
public int GetMaxid() {
	return message.Maxid();
}
public void InsertMessage(String name,String messages) {
	MessageModel mesaadetails=new MessageModel(name,messages);
	System.out.print(mesaadetails.getUsername()+mesaadetails.getMessage());;
	message.insertmessage(mesaadetails);
}
}
