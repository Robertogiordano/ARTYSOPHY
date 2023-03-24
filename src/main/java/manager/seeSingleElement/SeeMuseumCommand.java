package manager.seeSingleElement;

import manager.Command;
import manager.CommandInvoker;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SeeMuseumCommand implements Command {

        private final int n;

        public SeeMuseumCommand(int n) {
            this.n = n;
        }

        @Override
        public List<Object> execute() {
            return Collections.singletonList(CommandInvoker.getMuseums().get(n));
        }
    }