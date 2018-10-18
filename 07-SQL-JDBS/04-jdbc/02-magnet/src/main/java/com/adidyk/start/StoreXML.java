package com.adidyk.start;

import com.adidyk.models.Entry;
import com.adidyk.models.Field;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.adidyk.setup.Constant.URL;

/**
 * Class StoreSQL for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
public class StoreXML {

    /**
     *
     */
    private File target;

    /**
     *
      */
    private Entry entry = new Entry();

    /**
     *
     * @param target - is file.
     */
    StoreXML(File target) {
        this.target = target;
    }

    /**
     *
     */
    public void getAllField() throws SQLException {
        Connection connect;
        List<Field> fields = new ArrayList<>();
        connect = DriverManager.getConnection(URL);
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM entry");
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            System.out.println(result.getInt("field"));
            Field field = new Field();
            field.setField(result.getInt("field"));
            fields.add(field);
        }
        result.close();
        statement.close();
        connect.close();
        this.entry.setList(fields);
        for (Field item : fields) {
            System.out.println(item.getField());
        }
    }

    /**
     *
     */
    void save() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class, Field.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(this.entry, System.out);
            marshaller.marshal(this.entry, this.target);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}
