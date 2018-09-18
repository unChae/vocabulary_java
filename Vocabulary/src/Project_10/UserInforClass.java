package Project_10;

public class UserInforClass {
	DataClass data;
	
	UserInforClass(DataClass data) {
		this.data = data;
	}

	public void setUserInfor(String id) {
		String rstID = "NULL";
		String rstName = "NULL";
		String rstNumber = "NULL";
		Svr.enterServer();
		try {
			String query = "select user_id, user_name, user_number from userinfor where concat(concat(user_id,'@'),user_email) = '"
					+ id + "'";
			Svr.stmt = Svr.con.prepareStatement(query);
			Svr.rs = Svr.stmt.executeQuery();
			while (Svr.rs.next()) {
				rstID = Svr.rs.getString("user_id");
				rstName = Svr.rs.getString("user_name");
				rstNumber = Svr.rs.getString("user_number");
			}
			data.userID = rstID;
			data.userName = rstName;
			data.userNumber = rstNumber;
			
			Svr.con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
