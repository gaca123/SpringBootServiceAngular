/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.common.number4.domen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.reinert.jjschema.Attributes;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gaca
 */
@JsonPropertyOrder({
    "id",
    "dateAndTime",
    "duration",
    "team1",
    "team2",
    "place",
    "referee",
    "statsOfMatch"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)// ovo znaci da se ne gleda property koji nema getere i setere!!!
public class Match {

    @Attributes(title = "Id", maximum = 100, minimum = 0, exclusiveMaximum = false, exclusiveMinimum = false, description = "Insert id", maxLength = 3, minLength = 0, readonly = false, pattern = "^[0-9]+", required = true)
    private int aid;
    @Attributes(description = "Insert date and time", title = "Date of match", format = "date", required = true)
    private String dateAndTime;
    @Attributes(description = "Insert time", title = "Duration of match", required = true, minimum = 90, maximum = 120)
    private int duration;
    @Attributes(description = "Team", title = "Team1", required = true, maxItems = 1)
    private Team team1;
    @Attributes(description = "Team", title = "Team2", required = true, maxItems = 1)
    private Team team2;
    @Attributes(description = "Place", title = "Place", required = true, maxItems = 1)
    private Place place;
    @Attributes(description = "Referee", title = "Referee", required = true, maxItems = 1)
    private Referee referee;
    @Attributes(required = true, minItems = 1, maxItems = 20, description = "Insert stats of match")
    private List<StatsOfMatch> statsOfMatch;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public List<StatsOfMatch> getStatsOfMatch() {
        return statsOfMatch;
    }

    public void setStatsOfMatch(List<StatsOfMatch> statsOfMatch) {
        this.statsOfMatch = statsOfMatch;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.aid;
        hash = 23 * hash + Objects.hashCode(this.dateAndTime);
        hash = 23 * hash + Objects.hashCode(this.duration);
        hash = 23 * hash + Objects.hashCode(this.team1);
        hash = 23 * hash + Objects.hashCode(this.team2);
        hash = 23 * hash + Objects.hashCode(this.place);
        hash = 23 * hash + Objects.hashCode(this.referee);
        hash = 23 * hash + Objects.hashCode(this.statsOfMatch);
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
        final Match other = (Match) obj;
        if (this.aid != other.aid) {
            return false;
        }
        if (!Objects.equals(this.dateAndTime, other.dateAndTime)) {
            return false;
        }
        if (!Objects.equals(this.duration, other.duration)) {
            return false;
        }
        if (!Objects.equals(this.team1, other.team1)) {
            return false;
        }
        if (!Objects.equals(this.team2, other.team2)) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        if (!Objects.equals(this.referee, other.referee)) {
            return false;
        }
        if (!Objects.equals(this.statsOfMatch, other.statsOfMatch)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "{" + "id=" + aid + ", dateAndTime=" + dateAndTime + ", duration=" + duration + ", team1=" + team1 + ", team2=" + team2 + ", place=" + place + ", referee=" + referee + ", statsOfMatch=" + statsOfMatch + '}';
    }
}
