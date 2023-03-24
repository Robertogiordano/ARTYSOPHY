package manager.seeSingleElement;

import manager.Command;
import manager.CommandInvoker;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SeeArtistCommand implements Command {
    private final int n;

    public SeeArtistCommand(int n) {
        this.n = n;
    }

    @Override
    public List<Object> execute() {
        return Collections.singletonList(CommandInvoker.getArtists().get(n));
    }
}
