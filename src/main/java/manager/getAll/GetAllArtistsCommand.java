package manager.getAll;

import dao.Artist;
import manager.Command;
import manager.CommandInvoker;

import java.util.Collections;
import java.util.List;

public class GetAllArtistsCommand implements Command {
    @Override
    public List<Object> execute() {
        return Collections.singletonList(CommandInvoker.getArtists());
    }
}
