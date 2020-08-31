package dao.UserDaoImpl;

import User.User;
import dao.UserDao;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User user1(User user) {
        Connection conn = null;
        PreparedStatement pstat = null;ResultSet ress = null;
        User user1 = new User();
        String sql = "select * from user where username = ? and password = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,user.getName());
            pstat.setString(2,user.getPassword());
            ress = pstat.executeQuery();

            while (ress.next())
            {

                user1.setName(ress.getString("username"));
                user1.setPassword(ress.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user1;
    }
}
