package bbdd;

import dao.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class CRUDUserBBDDTest {

    User user=new User("Laura","Ferrer Haba", "lauferhaba","lferhaba@al.uloyola.es","asdfghjkl");
    User upUser=new User("Laura","Ferrer Haba", "lauferhaba","lferhaba@al.uloyola.es","zxcvbnm");

    @Test
            public void createUserTest(){
        CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
        userBBDD.create(user);
        userBBDD.closeConnection();
    }

    @Test
    public void readUserTest() throws SQLException {
        CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
        Assert.assertEquals(userBBDD.read(user.getUsername(),user.getPassword()),user);
        userBBDD.closeConnection();
    }

    @Test
    public void updateUserTest() throws SQLException {

        CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
        userBBDD.update(upUser,"username='"+upUser.getUsername()+"'");
        userBBDD.closeConnection();
    }

    @Test
    public void readAllUsersTest() throws SQLException {
        CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
        System.out.println(userBBDD.readAll());
        userBBDD.closeConnection();
    }

    @Test
    public void deleteUserTest() throws SQLException {
        CRUDUserBBDD userBBDD=CRUDUserBBDD.getInstance();
        userBBDD.delete(upUser);
        userBBDD.closeConnection();
    }


}
