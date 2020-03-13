import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class PersistenciaXML implements IGravacao {

    public boolean gravarLista(List<Pessoa> lp)  {
        try{
            FileOutputStream fos = new FileOutputStream(new File("agenda.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(lp);
            encoder.close();
            fos.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }
        return true;
    }

    public List<Pessoa> ler() {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        try {
            FileInputStream fis = new FileInputStream(new File("agenda.xml"));
            XMLDecoder decoder = new XMLDecoder(fis);
            lista = (List<Pessoa>) decoder.readObject();
            decoder.close();
            fis.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return lista;
    }

}
