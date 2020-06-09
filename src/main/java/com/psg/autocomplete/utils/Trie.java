package com.psg.autocomplete.utils;

import com.psg.autocomplete.entites.DataNode;
import com.psg.autocomplete.entites.TrieNode;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Karanjot Singh
 */
public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    /**
     * @param data
     * @return
     */
    public DataNode insert(String data) {
        TrieNode current = root;
        Stack<TrieNode> stack = new Stack<>();
        for (char ch : data.toLowerCase().toCharArray()) {
            stack.push(current);
            if (current.getChildren().get(ch) == null) {
                current.getChildren().put(ch, new TrieNode());
            }
            current = current.getChildren().get(ch);
        }
        stack.push(current);
        current.setEnd(true);
        current.setRank(current.getRank() + 1);
        DataNode dataNode = new DataNode(data, current.getRank());
        fillRanksUpdateCache(stack, dataNode);
        return dataNode;
    }

    /**
     * @param stack
     * @param dataNode
     */
    private void fillRanksUpdateCache(Stack<TrieNode> stack, DataNode dataNode) {
        while (!stack.empty())
            stack.pop().insertDataNode(dataNode);
    }

    /**
     * @param data
     * @return
     */
    public List<String> get(String data) {
        TrieNode current = root;
        List<String> result = new ArrayList<>();
        for (char ch : data.toLowerCase().toCharArray()) {
            if (current.getChildren().get(ch) == null) {
                current.getQueue().forEach(p -> result.add(p.getData()));
                break;
            }
            current = current.getChildren().get(ch);
        }
        current.getQueue().forEach(p -> result.add(p.getData()));
        return result;
    }
}
