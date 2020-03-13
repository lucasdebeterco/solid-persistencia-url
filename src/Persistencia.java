import java.io.IOException;
import java.util.List;

public class Persistencia {

    private IGravacao g;

    public Persistencia(IGravacao g) {
        this.g = g;
    }

    public boolean gravar(List<Pessoa> list) throws IOException {
        return g.gravarLista(list);

    }
    public List<Pessoa> ler() throws IOException {
        return g.ler();
    }
}
