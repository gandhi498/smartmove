/*
 * Copyright (c) KLM Royal Dutch Airlines. All Rights Reserved.
 * ============================================================
 */
package com.smartmove.domain.reservation;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Itinerary class
 */
@JsonInclude(Include.NON_NULL)
public class Itinerary {


    private List<Connection> connections = new ArrayList<>();

    /**
     * @return the connections
     */
    public List<Connection> getConnections() {
        return connections;
    }
    /**
     * @param connections the connections to set
     */
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }
}
