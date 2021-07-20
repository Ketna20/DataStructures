package oopconcepts.onlineReaderSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

import java.util.HashMap;
import java.util.Map;

public class ReaderManager {
    private Map<String, Reader> readers = new HashMap<>();

    protected void addReader(Reader reader) {
        readers.putIfAbsent(reader.getEmail(), reader);
    }

    protected boolean removeReader(Reader reader) {
        return readers.remove(reader.getEmail(), reader);
    }

    protected Reader findReader(String email) {
        return readers.get(email);
    }
}
