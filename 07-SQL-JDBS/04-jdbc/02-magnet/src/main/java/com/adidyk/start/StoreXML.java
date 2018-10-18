package com.adidyk.start;

import com.adidyk.models.Entry;
import com.adidyk.models.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.adidyk.setup.Constant.FIELD;
import static com.adidyk.setup.Constant.GET_ALL_FIELD;
import static com.adidyk.setup.Constant.URL;

/**
 * Class StoreSQL used for generate XML file from database magnet.sqlite (uses technology JAXB).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
class StoreXML {

    /**
     * @param source - link variable to object of class File.
     */
    private File source;

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StoreXML.class);

    /**
     * @param entry - link variable to object of class Entry.
     */
    private Entry entry = new Entry();

    /**
     * StoreXML - constructor.
     * @param source - is file.
     */
    StoreXML(File source) {
        this.source = source;
    }

    /**
     * getAllField - returns all fields from table entry from database magnet.sqlite
     * (used query sql -> GET_ALL_FIELD).
     */
    void getAllField() {
        Connection connect = null;
        List<Field> list = new ArrayList<>();
        try {
            connect = DriverManager.getConnection(URL);
            PreparedStatement statement = connect.prepareStatement(GET_ALL_FIELD);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Field field = new Field();
                field.setField(result.getInt(FIELD));
                list.add(field);
            }
            result.close();
            statement.close();
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
        this.entry.setList(list);
    }

    /**
     * save - saves all fields from list in XML file (uses technology JAXB).
     */
    void save() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entry.class, Field.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(this.entry, this.source);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

}