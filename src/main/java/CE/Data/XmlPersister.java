package CE.Data;

import CE.Clases_Principales.Song;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XmlPersister {
    private String path;
    private static XmlPersister theInstance;
    public static XmlPersister instance(){
        if (theInstance==null){
            theInstance=new XmlPersister("Canciones.xml");
        }
        return theInstance;
    }
    public XmlPersister(String p) {
        path=p;
    }


    public Song load() throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Song.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Song result = (Song) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
    public void store(Song d)throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Song.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(d, os);
        os.flush();
        os.close();
    }
}
