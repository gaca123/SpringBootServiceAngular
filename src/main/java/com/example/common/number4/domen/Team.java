/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.common.number4.domen;

import com.example.common.number3.domen.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.reinert.jjschema.Attributes;
import java.util.Objects;

/**
 *
 * @author Gaca
 */
@JsonPropertyOrder({
    "id",
    "name"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)// ovo znaci da se ne gleda property koji nema getere i setere!!!
public class Team implements Comparable<Team>{

    @Attributes(title = "Id", maximum = 100, minimum = 0, exclusiveMaximum = false, exclusiveMinimum = false, description = "Insert id of team", maxLength = 3, minLength = 0, readonly = false, pattern = "^[0-9]+", required = true)
    private int id;
    @Attributes(required = true, title = "Name", description = "Insert name of team", readonly = false, maxLength = 20, minLength = 2, pattern = "^[a-zA-Z]+")
    private String name;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int compareTo(Team team) {
        return this.getName().compareTo(team.getName());
    }
}
