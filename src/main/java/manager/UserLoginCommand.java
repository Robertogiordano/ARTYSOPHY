package manager;

import bbdd.ConsultasBBDD;
import dao.User;

import java.util.Collections;
import java.util.List;

public class UserLoginCommand implements Command {

    private User user;

    public UserLoginCommand(User user) {
        this.user = user;
    }

    @Override
    public List<Object> execute() {
        if(ConsultasBBDD.checkLogin(user)!=null){
            CommandInvoker.setUser(user);
            return Collections.singletonList(user);
        }

        return null;
    }
}
