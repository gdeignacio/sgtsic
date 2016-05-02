/*
 * Copyright 2016 gdeignacio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.caib.sgtsic.util;

import es.caib.sgtsic.io.ByteArrayDataSource;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;

/**
 *
 * @author gdeignacio
 */
public class DataHandlers {

    public static byte[] dataHandlerToByteArray(DataHandler dataHandler) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        dataHandler.writeTo(output);
        return output.toByteArray();
    }

    public static DataHandler byteArrayToDataHandler(byte[] arrayByte, String mimetype) {

        ByteArrayDataSource dataSource = new ByteArrayDataSource(arrayByte, mimetype);
        return new DataHandler(dataSource);

    }

    public static DataHandler byteArrayToDataHandler(byte[] arrayByte) {

        InputStream is = new BufferedInputStream(new ByteArrayInputStream(arrayByte));

        String mimetype = "";

        try {
            mimetype = URLConnection.guessContentTypeFromStream(is);
        } catch (IOException ex) {
            Logger.getLogger(DataHandlers.class.getName()).log(Level.SEVERE, null, ex);
        }

        ByteArrayDataSource dataSource = new ByteArrayDataSource(arrayByte, mimetype);

        return new DataHandler(dataSource);

    }

}
