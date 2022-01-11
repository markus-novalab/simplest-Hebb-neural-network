package org.khpi.ai.model;

import lombok.Value;

import java.util.List;

@Value
public class EntityData {
    List<Integer> data;
    Integer signal;
    Symbol symbol;
}
