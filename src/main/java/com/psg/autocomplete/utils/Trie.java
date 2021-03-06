package com.psg.autocomplete.utils;

import com.psg.autocomplete.entites.DataNode;
import com.psg.autocomplete.entites.TrieNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Karanjot Singh
 * This is a data structure to handle our words.
 * Where we are also providing the ranks to the words are getting watched or used very often
 * Also maintaing the cahce on each node of 5 words to provide quick reponse
 *
 */
public class Trie {
    private static final Logger LOGGER = LoggerFactory.getLogger(Trie.class);
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    /**
     * @param data - this is the word we will insert
     * @return It will return the node which is inserted
     * This method will help to insert the new data into our data structure
     */
    public DataNode insert(String data) {
        LOGGER.info("Inserting new word or upgrade ranking for "+data);
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
        LOGGER.info("Inserted the value in memory "+ dataNode.toString());
        return dataNode;
    }

    /**
     * @param stack - it is the stack calls to insert of each level
     * @param dataNode - node which we will insert
     * this method will help us to maintain the data for caching with lastest data
     */

    private void fillRanksUpdateCache(Stack<TrieNode> stack, DataNode dataNode) {
        while (!stack.empty())
            stack.pop().insertDataNode(dataNode);
    }

    /**
     * @param data - word for which we are getting data
     * @return - return the list of data of auto suggest keywords
     * This will provide us the relevant list of words.
     */
    public List<String> get(String data) {
        LOGGER.info("Getting data for prefix "+ data);
        TrieNode current = root;
        List<String> result = new ArrayList<>();
        for (char ch : data.toLowerCase().toCharArray()) {
            if (current.getChildren().get(ch) == null) {
                //current.getQueue().forEach(p -> result.add(p.getData()));
                break;
            }
            current = current.getChildren().get(ch);
        }
        current.getQueue().forEach(p -> result.add(p.getData()));
        LOGGER.info("Got list of data ");
        return result;
    }
}
