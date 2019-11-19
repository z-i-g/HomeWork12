package TestEJB;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;

@Local
public interface IMyEjb {

    List<String> readFileDirectory() throws IOException;

}
