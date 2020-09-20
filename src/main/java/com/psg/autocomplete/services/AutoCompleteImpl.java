package com.psg.autocomplete.services;

import com.psg.autocomplete.entites.DataNode;
import com.psg.autocomplete.utils.Trie;
import com.psg.autocomplete.utils.TrieSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoCompleteImpl implements AutoComplete {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoCompleteImpl.class);
    Trie trie = TrieSingleton.getInstance();

    /**
     * @param data - it is a keyword to get data
     * @return - it will return the list of words
     */
    @Override
    public List<String> getList(String data) {
        LOGGER.info("Executing the service logic for getting " + data);
        return trie.get(data);
    }

    /**
     * @param data - it is a keyword to add data
     * @return - it will return the data after insertion
     */
    @Override
    public DataNode add(String data) {
        LOGGER.info("Executing the service logic for adding " + data);
        return trie.insert(data);
    }
}
