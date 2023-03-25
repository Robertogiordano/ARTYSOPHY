package bbdd;

import dao.ArtElement;
import dao.Artist;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

interface DAOInterface {
    public void create(ArtElement o);
    public List<ArtElement> read(String condition) throws SQLException;
    public void update(ArtElement o, String condition);
    public void delete(ArtElement o);
}
