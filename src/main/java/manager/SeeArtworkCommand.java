package manager;

import bbdd.ConsultasBBDD;
import manager.Command;
import manager.CommandInvoker;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

class SeeArtworkCommand implements Command {
    private final Integer n;

    public SeeArtworkCommand(Integer n) {
        this.n = n;
    }

    @Override
    public List<Object> execute() {
        try {
            return Collections.singletonList(ConsultasBBDD.filterArtElementId("artworks",n.toString()));
        } catch (SQLException e) {
            throw new RuntimeException("Impossible get artwoks by id");
        }
    }
}