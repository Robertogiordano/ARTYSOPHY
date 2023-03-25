package manager;

import bbdd.ConsultasBBDD;
import manager.Command;
import manager.CommandInvoker;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SeeMuseumCommand implements Command {

        private final Integer n;

        public SeeMuseumCommand(Integer n) {
            this.n = n;
        }

        @Override
        public List<Object> execute() {
            try {
                return Collections.singletonList(ConsultasBBDD.filterArtElementId("museums",n.toString()));
            } catch (SQLException e) {
                throw new RuntimeException("Impossible get museum by id");
            }
        }
    }