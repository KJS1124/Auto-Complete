package com.psg.autocomplete.services;

import com.psg.autocomplete.entites.DataNode;
import com.psg.autocomplete.utils.Trie;
import com.psg.autocomplete.utils.TrieSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoCompleteImpl implements AutoComplete {

    Trie trie = TrieSingleton.getInstance();

    /**
     * @param data
     * @return
     */
    @Override
    public List<String> getList(String data) {
        return trie.get(data);
    }

    /**
     * @param data
     * @return
     */
    @Override
    public DataNode add(String data) {
        return trie.insert(data);
    }
}
