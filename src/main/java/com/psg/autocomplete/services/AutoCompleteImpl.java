package com.psg.autocomplete.services;

import com.psg.autocomplete.entites.DataNode;
import com.psg.autocomplete.utils.Trie;
import com.psg.autocomplete.utils.TrieSingleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoCompleteImpl implements AutoComplete {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoCompleteImpl.class);
    Trie trie = TrieSingleton.getInstance();

    /**
     * @param data
     * @return
     */
    @Override
    public List<String> getList(String data) {
        LOGGER.info("Executing the service logic for getting " + data);
        return trie.get(data);
    }

    /**
     * @param data
     * @return
     */
    @Override
    public DataNode add(String data) {
        LOGGER.info("Executing the service logic for adding " + data);
        return trie.insert(data);
    }
}
