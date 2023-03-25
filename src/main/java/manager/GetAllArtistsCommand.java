package manager;

import bbdd.ConsultasBBDD;
import dao.Artist;
import manager.Command;
import manager.CommandInvoker;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GetAllArtistsCommand implements Command {
    @Override
    public List<Object> execute(){
        try {
            return Collections.singletonList(ConsultasBBDD.getArtElements("artists"));
        } catch (SQLException e) {
            throw new RuntimeException("Impossible get all artists");
        }
    }
}
