import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ListaPessoa lp = new ListaPessoa();
        Scanner entrada = new Scanner(System.in);

        PersistenciaCSV csv = new PersistenciaCSV();
        PersistenciaJSON json = new PersistenciaJSON();
        PersistenciaXML xml = new PersistenciaXML();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println(Menu());
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    Persistencia pers = new Persistencia(xml);
                    pers.gravar(lp.getList());
                    break;
                case 2:
                    pers = new Persistencia(xml);
                    lp.setList(pers.ler());
                    break;
                case 3:
                    pers = new Persistencia(csv);
                    pers.gravar(lp.getList());
                    break;
                case 4:
                    pers = new Persistencia(csv);
                    lp.setList(pers.ler());
                    break;
                case 5:
                    pers = new Persistencia(json);
                    pers.gravar(lp.getList());
                    break;
                case 6:
                    pers = new Persistencia(json);
                    System.out.println(pers.ler());
                    lp.setList(pers.ler());
                    break;
                case 7:
                    pers = new Persistencia(json);
                    System.out.println("Digite a URL: ");
                    String link = entrada.next();
                    Url url = new Url();
                    List<Pessoa> listaPessoas = url.lerJsonUrl(link);
                    json.gravarLista(listaPessoas);
                    System.out.println(listaPessoas);
                    break;
                case 8:
                    System.out.println("Gráfico gerado ");
                    Grafico g = new Grafico();
                    g.gerarGrafico(lp.getList());
                    break;
            }

        }
    }

    public static String Menu(){
        return "------- MENU -------" +
                "\n 0 - Sair" +
                "\n 1 - Gravar arquivo XML" +
                "\n 2 - Ler arquivo XML" +
                "\n 3 - Gravar arquivo CSV" +
                "\n 4 - Ler arquivo CSV" +
                "\n 5 - Gravar arquivo JSON" +
                "\n 6 - Ler arquivo JSON" +
                "\n --------------- " +
                "\n 7 - Gravar JSON com URL (curvello.com)" +
                "\n 8 - Gerar gráfico";
    }

}