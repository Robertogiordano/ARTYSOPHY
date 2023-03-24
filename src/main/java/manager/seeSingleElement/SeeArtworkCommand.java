package manager.seeSingleElement;

import manager.Command;
import manager.CommandInvoker;

import java.util.Collections;
import java.util.List;

class SeeArtworkCommand implements Command {
    private final int n;

    public SeeArtworkCommand(int n) {
        this.n = n;
    }

    @Override
    public List<Object> execute() {
        return Collections.singletonList(CommandInvoker.getArtworks().get(n));
    }
}