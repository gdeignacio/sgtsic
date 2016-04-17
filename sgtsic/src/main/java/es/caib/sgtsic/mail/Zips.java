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
package es.caib.sgtsic.mail;

import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.activation.DataHandler;

/**
 *
 * @author gdeignacio
 */
public class Zips {
    
    public DataHandler generateZip(List<DataHandler> documents) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(baos);

        for (DataHandler document : documents) {

            InputStream is = new ByteArrayInputStream(DataHandlers.dataHandlerToByteArray(document));
            ZipEntry zipEntry = new ZipEntry(document.getName());
            zip.putNextEntry(zipEntry);
            ByteStreams.copy(is, zip);
            zip.closeEntry();
            is.close();
        }

        zip.close();
        baos.close();

        return DataHandlers.byteArrayToDataHandler(baos.toByteArray(), "application/zip");

    }
    
    
}
