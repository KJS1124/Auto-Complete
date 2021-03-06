package com.psg.autocomplete.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * @author Karanjot Singh
 */
@Getter
@Setter
@AllArgsConstructor
public class TrieNode {
    private final int MAX_SIZE = 5;
    private Map<Character, TrieNode> children;
    private int rank;
    private boolean isEnd;
    private Queue<DataNode> queue;

    public TrieNode() {
        this.rank = 0;
        this.isEnd = false;
        children = new HashMap<>();
        queue = new PriorityQueue<>(Comparator.comparingInt(DataNode::getRank));
    }

    /**
     * @param dataNode - will insert the data in tire
     */
    public void insertDataNode(DataNode dataNode) {
        if (queue.contains(dataNode))
            queue.remove(dataNode);
        queue.add(dataNode);
        if (queue.size() > MAX_SIZE)
            queue.poll();
    }
}
