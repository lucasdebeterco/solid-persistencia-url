import java.util.*;

public class ListaPessoa {

    private List<Pessoa> list = new ArrayList<Pessoa>();

    public void add(Pessoa pessoa) {
        list.add(pessoa);
    }

    public boolean excluir(Pessoa pessoa) {
        if (pessoa != null) {
            list.remove(pessoa);
            return true;
        }
        return false;
    }

    public boolean alterar(Pessoa pessoa, int codigo, String nome, String email) {
        if (list.contains(pessoa)) {
            pessoa.setCodigo(codigo);
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            return true;
        }
        return false;
    }

    public List<Pessoa> getList() {
        return list;
    }

    public void setList(List<Pessoa> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListPessoa{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
