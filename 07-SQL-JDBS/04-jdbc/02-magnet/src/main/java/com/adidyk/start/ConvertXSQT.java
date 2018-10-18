package com.adidyk.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Class ConvertXSQT converts source file (source.file) in dest file (dest.xml) using scheme XSLT (scheme.xsl).
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 02.10.2018.
 * @version 1.0.
 */
class ConvertXSQT {

    /**
     * @param log - link variable to object of class Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ConvertXSQT.class);

    /**
     * convert - converts source file in dest file used scheme XSLT.
     * @param source - file source (source.xml).
     * @param dest - file dest (dest.xml).
     * @param scheme - file scheme XSLT (scheme.xsl).
     */
    void convert(File source, File dest, File scheme)  {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (TransformerException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}