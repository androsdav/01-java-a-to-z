package com.adidyk.start;

import com.adidyk.setup.Constant;
import com.adidyk.setup.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import static com.adidyk.setup.Constant.*;

/**
 * Class StartUi for create jar file and start program.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 18.10.2018.
 * @version 1.0.
 */
public class StartUi {

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StoreXML.class);

    /**
     * start - starts program.
     */
    private void start() {
        this.loadSetting();
        this.configDataBase();
        this.generateXmlFromDataBase();
        this.convertXml();
        this.purserSax();
    }

    /**
     * loadSetting - loads params from file app.properties to class Constant.
     */
    private void loadSetting() {
        Settings setting = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            setting.load(is);
            new Constant(setting);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * configDataBase - checks if there is table entry and generates number of fields in table entry.
     */
    private void configDataBase() {
        StoreSQL storeSQL = new StoreSQL();
        if (!storeSQL.searchTable()) {
            storeSQL.createTable();
        }
        storeSQL.generate(QUANTITY);
    }

    /**
     * generateXmlFromDataBase - generates xml file from database.
     */
    private void generateXmlFromDataBase() {
        StoreXML storeXML = new StoreXML(new File(SOURCE));
        storeXML.getAllField();
        storeXML.save();
    }

    /**
     * convertXml - converts source file (source.xml) in dest file (dest.xml) used scheme XSLT (scheme.xsl).
     */
    private void convertXml() {
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(new File(SOURCE), new File(DEST), new File(SCHEME));
    }

    /**
     * purserSAX - reads all information from xml-file (dest.xml) using SAX-purser.
     */
    private void purserSax() {
        PurserSAX purserSAX = new PurserSAX(new File(DEST));
        purserSAX.purserSAX();
        System.out.println(purserSAX.getSum());
    }

    /**
     * main - creates jar file and runs program.
     * @param arg - is nothing.
     */
    public static void main(String[] arg) {
        new StartUi().start();
    }

}