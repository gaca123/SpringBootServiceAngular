/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.common.number2.domen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.reinert.jjschema.Attributes;
import com.google.common.collect.ComparisonChain;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gaca
 */
@JsonPropertyOrder({
    "idPlayer",
    "name",
    "surname",
    "height",
    "weight",
    "dateOfBirth"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)// ovo znaci da se ne gleda property koji nema getere i setere!!!
public class Player implements Comparable<Player> {

    @Attributes(title = "Id player", maximum = 100, minimum = 0, exclusiveMaximum = false, exclusiveMinimum = false, description = "Insert id of player", maxLength = 3, minLength = 0, readonly = true, pattern = "^[0-9]+", required = true)
    private int aidPlayer;
    @Attributes(required = true, title = "Name", description = "Insert name of player", readonly = false, maxLength = 20, minLength = 2, pattern = "^[a-zA-Z]+")
    private String name;
    @Attributes(required = true, title = "Surname", description = "Insert surname of player", readonly = false, maxLength = 20, minLength = 2, pattern = "^[a-zA-Z]+")
    private String surname;
    @Attributes(description = "Insert date of birth", title = "Date of birth", format = "date", required = true)
    private String dateOfBirth;
    @Attributes(required = true, pattern = "^[0-9]+", title = "Height", description = "Insert height of player in cm", maximum = 250, minimum = 150, maxLength = 6, minLength = 6, exclusiveMaximum = false, exclusiveMinimum = false)
    private Double height;
    @Attributes(required = true, pattern = "^[0-9]+", title = "Weight", description = "Insert weight of player in kg", maximum = 200, minimum = 50, readonly = false)
    private Double weight;
    @Attributes(required = true, title = "Player status", description = "Pick player status", readonly = false)
    private PlayerStatus playerStatusRadio;
    @Attributes(required = true, title = "Player status", description = "Pick player status", readonly = false)
    private PlayerStatus playerStatusSelect;
    @Attributes(required = true, title = "Player status", description = "Pick player status", readonly = false)
    private List<PlayerStatus> playerStatusCheck;
    @Attributes(required = true, title = "Player attributes", description = "Insert player attributes", readonly = false)
    private String playerAttributes;
    @Attributes(required = true, title = "Player status", description = "Pick player status", readonly = false,enums = {"Active","Inactive","Retirement"},maxItems = 1)
    private String playerStatusTypeAhead;

    public int getAidPlayer() {
        return aidPlayer;
    }

    public void setAidPlayer(int aidPlayer) {
        this.aidPlayer = aidPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PlayerStatus getPlayerStatusRadio() {
        return playerStatusRadio;
    }

    public void setPlayerStatusRadio(PlayerStatus playerStatusRadio) {
        this.playerStatusRadio = playerStatusRadio;
    }

    public PlayerStatus getPlayerStatusSelect() {
        return playerStatusSelect;
    }

    public void setPlayerStatusSelect(PlayerStatus playerStatusSelect) {
        this.playerStatusSelect = playerStatusSelect;
    }

    public List<PlayerStatus> getPlayerStatusCheck() {
        return playerStatusCheck;
    }

    public void setPlayerStatusCheck(List<PlayerStatus> playerStatusCheck) {
        this.playerStatusCheck = playerStatusCheck;
    }

    public String getPlayerAttributes() {
        return playerAttributes;
    }

    public void setPlayerAttributes(String playerAttributes) {
        this.playerAttributes = playerAttributes;
    }

    public String getPlayerStatusTypeAhead() {
        return playerStatusTypeAhead;
    }

    public void setPlayerStatusTypeAhead(String playerStatusTypeAhead) {
        this.playerStatusTypeAhead = playerStatusTypeAhead;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.aidPlayer;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.surname);
        hash = 13 * hash + Objects.hashCode(this.dateOfBirth);
        hash = 13 * hash + Objects.hashCode(this.height);
        hash = 13 * hash + Objects.hashCode(this.weight);
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
        final Player other = (Player) obj;
        if (this.aidPlayer != other.aidPlayer) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        if (!Objects.equals(this.height, other.height)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + "idPlayer=" + aidPlayer + ", name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + ", height=" + height + ", weight=" + weight + '}';
    }

    @Override
    public int compareTo(Player client) {
        // TODO Auto-generated method stub
        return ComparisonChain.start()
                .compare(this.getSurname(), client.getSurname(), String.CASE_INSENSITIVE_ORDER)
                .compare(this.getName(), client.getName(), String.CASE_INSENSITIVE_ORDER)
                .result();
    }
}
