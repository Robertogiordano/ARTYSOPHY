/*package manager;

import bbdd.ConsultasBBDD;
import dao.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class TestCommandInvoker {
    User user=new User("Roberto","Giordano", "rgiordano","rgiordano@al.uloyola.es","qwertyuiop");
    CommandInvoker commandInvoker=CommandInvoker.getInstance(user);
    @Test
    public void registerTest() throws SQLException {
        int numElemBefore= 0;

        commandInvoker.executeCommand(CommandsType.REGISTER);
        Assert.assertEquals(commandInvoker.getUser(),user);
    }

    @Test
    public void logoutTest(){
        commandInvoker.executeCommand(CommandsType.LOGOUT);
        Assert.assertEquals(commandInvoker.getUser(),null);
        commandInvoker.releaseInstance();
    }

    @Test
    public void loginTest() {
        commandInvoker=CommandInvoker.getInstance(user);
        commandInvoker.executeCommand(CommandsType.LOGIN);
        Assert.assertEquals(commandInvoker.getUser(),user);
    }

    @Test
    public void getAllArtists(){
        System.out.println(commandInvoker.executeCommand(CommandsType.ARTISTS));
    }
}*/
