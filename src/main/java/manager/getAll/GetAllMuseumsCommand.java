package manager.getAll;

import manager.Command;
import manager.CommandInvoker;

import java.util.Collections;
import java.util.List;

public class GetAllMuseumsCommand implements Command {
    @Override
    public List<Object> execute() {
        return Collections.singletonList(CommandInvoker.getMuseums());
    }
}
