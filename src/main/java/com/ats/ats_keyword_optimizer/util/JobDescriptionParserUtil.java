package com.ats.ats_keyword_optimizer.util;

import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class JobDescriptionParserUtil {

    // Parse JD file and extract text
    public String parseJobDescription(File file) throws IOException, TikaException, SAXException {
        FileInputStream inputStream = new FileInputStream(file);
        BodyContentHandler handler = new BodyContentHandler(-1);
        AutoDetectParser parser = new AutoDetectParser();
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, null, context);
        inputStream.close();
        return handler.toString();
    }
}
