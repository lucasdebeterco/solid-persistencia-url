public class Pessoa {

    private int codigo;
    private String nome;
    private String email;
    private String fone;
    private	String dataNascimento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String data) {
        this.dataNascimento = data;
    }

    public String getTelefone() {
        return fone;
    }

    public void setTelefone(String telefone) {
        this.fone = telefone;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pessoa [codigo=");
        builder.append(codigo);
        builder.append(", nome=");
        builder.append(nome);
        builder.append(", email=");
        builder.append(email);
        builder.append(", dataNascimento=");
        builder.append(dataNascimento);
        builder.append("]");
        return builder.toString();
    }

}