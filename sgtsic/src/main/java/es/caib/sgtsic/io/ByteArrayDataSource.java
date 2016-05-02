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
package es.caib.sgtsic.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author gdeignacio
 * @author Brian.Ewins@btinternet.com
 */
public class ByteArrayDataSource implements javax.activation.DataSource {

    private byte[] bytes;

    public ByteArrayDataSource() {
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }
    private String contentType;

    public ByteArrayDataSource(byte[] bytes, String contentType) {
        this.bytes = bytes;
        this.contentType = contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(bytes);
    }

    /**
     * for completeness, here's how to implement the outputstream. this is
     * unnecessary for what you're doing, you can just throw an
     * UnsupportedOperationException.
     */
    public OutputStream getOutputStream() {
        final ByteArrayDataSource bads = this;
        final ByteArrayOutputStream baos
                = new ByteArrayOutputStream();
        // return an outputstream that sets my byte array
        // when it is closed.
        return new FilterOutputStream(baos) {
            public void close() throws IOException {
                baos.close();
                bads.setBytes(baos.toByteArray());
            }
        };
    }

    @Override
    public String getName() {
        return "ByteArrayDataSource";
    }
}
