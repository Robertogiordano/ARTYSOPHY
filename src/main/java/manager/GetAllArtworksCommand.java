package manager;

import bbdd.ConsultasBBDD;
import manager.Command;
import manager.CommandInvoker;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GetAllArtworksCommand implements Command {
    @Override
    public List<Object> execute() {
        try {
            return Collections.singletonList(ConsultasBBDD.getArtElements("artworks"));
        } catch (SQLException e) {
            throw new RuntimeException("Impossible get all artworks");
        }
    }
}