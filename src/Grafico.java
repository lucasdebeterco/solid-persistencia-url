import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Grafico {
    public void gerarGrafico(List<Pessoa> lista) throws IOException {

        int cont = 0;
        HashSet<String> dominio2 = new HashSet<String>();
        for (Pessoa pessoa : lista){
            String email = pessoa.getEmail();
            String[] textoSeparado = email.split("@");
            String dominio = (textoSeparado[1]);
            String[] textoSeparado2 = dominio.split(".com");
            dominio2.add(textoSeparado2[0]);
            cont++;
        }

        Scanner entrada = new Scanner(System.in);
        FileWriter arq = new FileWriter("Gráfico.html");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("" +
                "<html>\r\n  " +
                "<head>\r\n    " +
                "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n    " +
                "<script type=\"text/javascript\">\r\n      " +
                "google.charts.load(\"current\", {packages:[\"corechart\"]});\r\n      " +
                "google.charts.setOnLoadCallback(drawChart);\r\n      " +
                "function drawChart() {\r\n       " +
                " var data = google.visualization.arrayToDataTable([\r\n          " +
                "['Domínio', 'Quantidade'],\r\n"
        );

        for(String dominio : dominio2) {
            int cont2 = 0;
            for(Pessoa pessoa : lista) {
                if (pessoa.getEmail().contains(dominio)){
                    cont2++;
                }
            }
            gravarArq.printf("           ['" + dominio + "'," + cont2 + "],\r\n");
        }

        gravarArq.printf("]);\r\n\r\n        " +
                "var options = {\r\n          " +
                "title: 'Grafico de dominios de email',\r\n          " +
                "is3D: true,\r\n        " +
                "};\r\n\r\n        " +
                "var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));\r\n        " +
                "chart.draw(data, options);\r\n      " +
                "}\r\n    " +
                "</script>\r\n  " +
                "</head>\r\n  " +
                "<body>\r\n    " +
                "<div id=\"piechart_3d\" style=\"width: 1800px; height: 750px;\"></div>\r\n  " +
                "</body>\r\n" +
                "</html>");
        arq.close();
        entrada.close();
    }
}
