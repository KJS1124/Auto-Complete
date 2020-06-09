package com.psg.autocomplete.entites;

import lombok.*;

import java.util.Objects;

/**
 * @author Karanjot Singh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataNode {
    String data;
    int rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataNode dataNode = (DataNode) o;
        return Objects.equals(data, dataNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
