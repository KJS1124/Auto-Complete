package com.psg.autocomplete.services;

import com.psg.autocomplete.entites.DataNode;

import java.util.List;

public interface AutoComplete {
    public List<String> getList(String data);

    public DataNode add(String data);
}
