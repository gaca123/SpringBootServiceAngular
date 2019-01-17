/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.common.number4.rest;

import com.example.common.number3.rest.*;
import com.example.common.number3.domen.Player;
import com.example.common.number3.domen.Team;
import com.example.common.number3.rest.*;
import com.example.common.number4.domen.Match;
import com.example.common.number4.domen.Place;
import com.example.common.number4.domen.Referee;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.module.jsonSchema.customProperties.TitleSchemaFactoryWrapper;
import com.fasterxml.jackson.module.jsonSchema.types.ObjectSchema;
import com.fasterxml.jackson.module.jsonSchema.types.StringSchema;
import com.github.reinert.jjschema.JsonSchemaGenerator;
import com.github.reinert.jjschema.SchemaGeneratorBuilder;
import com.github.reinert.jjschema.v1.JsonSchemaFactory;
import com.github.reinert.jjschema.v1.JsonSchemaV4Factory;
import com.google.common.collect.HashBiMap;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CECA
 */
// Ako ne stavim multiselect na true onda ne mogu da pretrazujem select polje!!!!!!!!!!!!!!
@RestController
public class Example4RestController {

    private static ObjectMapper mapper = new ObjectMapper();
    public static final String JSON_$SCHEMA_DRAFT4_VALUE = "http://json-schema.org/draft-04/schema#";
    public static final String JSON_$SCHEMA_ELEMENT = "$schema";

    @RequestMapping(value = "/schemaExample4", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Object get() {

        try {
            JsonSchemaFactory schemaFactory = new JsonSchemaV4Factory();
            schemaFactory.setAutoPutDollarSchema(true);
            JsonNode productSchema = schemaFactory.createSchema(Match.class);
            System.out.println(productSchema);

            return ResponseEntity.status(HttpStatus.OK).body(mapper.writeValueAsString(productSchema));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }

    @RequestMapping(value = "/formExample4", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Object getForm() {

        try {
            ObjectMapper mapper1 = new ObjectMapper();
            ArrayNode form = mapper1.createArrayNode();
            ObjectNode formIdMatch = mapper1.createObjectNode();
            ObjectNode formDateOfMatch = mapper1.createObjectNode();
            ObjectNode formDurationOfMatch = mapper1.createObjectNode();
            ObjectNode formTeam1 = mapper1.createObjectNode();
            ObjectNode formTeam2 = mapper1.createObjectNode();
            ObjectNode formReferee = mapper1.createObjectNode();
            ObjectNode formPlace = mapper1.createObjectNode();
            ObjectNode formStatsOfMatch = mapper1.createObjectNode();
            ArrayNode dataSource1 = mapper1.createArrayNode();
            ArrayNode dataSource2 = mapper1.createArrayNode();
            ArrayNode dataSource3 = mapper1.createArrayNode();
            ArrayNode dataSource4 = mapper1.createArrayNode();

            ArrayNode items = mapper1.createArrayNode();
            
            ObjectNode itemsFiledsId = mapper1.createObjectNode();
            ObjectNode itemsFiledsDescription = mapper1.createObjectNode();
            ObjectNode itemsFiledsTime = mapper1.createObjectNode();
            
            ObjectNode tab = mapper1.createObjectNode();
            tab.put("type", "tabs");
            ArrayNode tabs = mapper1.createArrayNode();
            ArrayNode tab1Items = mapper1.createArrayNode();
            ArrayNode tab2Items = mapper1.createArrayNode();
            ObjectNode tab1 = mapper1.createObjectNode();
            ObjectNode tab2 = mapper1.createObjectNode();
            tab1.put("title","Match");
            tab2.put("title","Stats of match");
            
            formIdMatch.put("key", "aid");
            
            formDateOfMatch.put("key", "dateOfMatch");
            
            formDurationOfMatch.put("key", "durationOfMatch");
            
            List<Team> teams1 = loadListOfTeams1();
            for (Team team : teams1) {
                ObjectNode pon = mapper1.createObjectNode();
                if (team.getId() == 0) {
                    pon.putPOJO("value", null);
                    pon.putPOJO("name", null);
                } else {
                    pon.putPOJO("value", team);
                    pon.put("name", team.getName());
                }

                dataSource1.add(pon);
            }
            formTeam1.put("key", "team1");
            formTeam1.putPOJO("titleMap", dataSource1);
            formTeam1.put("type", "select");
            
            List<Team> teams2 = loadListOfTeams2();
            for (Team team : teams2) {
                ObjectNode pon = mapper1.createObjectNode();
                if (team.getId() == 0) {
                    pon.putPOJO("value", null);
                    pon.putPOJO("name", null);
                } else {
                    pon.putPOJO("value", team);
                    pon.put("name", team.getName());
                }

                dataSource2.add(pon);
            }
            formTeam2.put("key", "team2");
            formTeam2.putPOJO("titleMap", dataSource2);
            formTeam2.put("type", "select");
            
            List<Place> places = loadListOfPlaces();
            for (Place place : places) {
                ObjectNode pon = mapper1.createObjectNode();
                if (place.getId() == 0) {
                    pon.putPOJO("value", null);
                    pon.putPOJO("name", null);
                } else {
                    pon.putPOJO("value", place);
                    pon.put("name", place.getName());
                }

                dataSource3.add(pon);
            }
            formPlace.put("key", "place");
            formPlace.putPOJO("titleMap", dataSource3);
            formPlace.put("type", "select");
            
            List<Referee> referees = loadListOfReferees();
            for (Referee referee : referees) {
                ObjectNode pon = mapper1.createObjectNode();
                if (referee.getId() == 0) {
                    pon.putPOJO("value", null);
                    pon.putPOJO("name", null);
                } else {
                    pon.putPOJO("value", referee);
                    pon.put("name", referee.getName());
                }

                dataSource4.add(pon);
            }
            formReferee.put("key", "referee");
            formReferee.putPOJO("titleMap", dataSource4);
            formReferee.put("type", "select");
            
            formStatsOfMatch.put("key", "statsOfMatch");
            
            itemsFiledsId.put("key", "statsOfMatch[].id");
            
            itemsFiledsDescription.put("key", "statsOfMatch[].sdescription");
            itemsFiledsDescription.put("type", "textarea");       
            
            itemsFiledsTime.put("key", "statsOfMatch[].time");
            
            items.add(itemsFiledsId);
            items.add(itemsFiledsDescription);
            items.add(itemsFiledsTime);
            formStatsOfMatch.putPOJO("items", items);
           
            tab1Items.add(formIdMatch);
            tab1Items.add(formDateOfMatch);
            tab1Items.add(formDurationOfMatch);
            tab1Items.add(formPlace);
            tab1Items.add(formReferee);
            tab1Items.add(formTeam1);
            tab1Items.add(formTeam2);
            
            tab2Items.add(formStatsOfMatch);
            
            tab1.putPOJO("items", tab1Items);
            tab2.putPOJO("items", tab2Items);
            tabs.add(tab1);
            tabs.add(tab2);
            tab.putPOJO("tabs", tabs);
            form.add(tab);

            return ResponseEntity.status(HttpStatus.OK).body(form);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }

    @RequestMapping(value = "/modelExample4", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Object getModel() {

        try {
            ObjectMapper mapper1 = new ObjectMapper();
            ObjectNode model = mapper1.createObjectNode();
            model.put("id", 1);
            return ResponseEntity.status(HttpStatus.OK).body(model);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown user.");
        }
    }

    private List<Team> loadListOfTeams1() {
        List<Team> teams = new ArrayList<>();

        Team team2 = new Team();
        team2.setId(1);
        team2.setName("Barcelona");

        Team team3 = new Team();
        team3.setId(2);
        team3.setName("Real Madrid");

        Team team4 = new Team();
        team4.setId(3);
        team4.setName("Liverpool");

        Team team5 = new Team();
        team5.setId(4);
        team5.setName("Chelsea");

        Team team6 = new Team();
        team6.setId(5);
        team6.setName("Valencia");

        Team team7 = new Team();
        team7.setId(6);
        team7.setName("Inter");

        Team team8 = new Team();
        team8.setId(7);
        team8.setName("Lazio");

        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        teams.add(team6);
        teams.add(team7);
        teams.add(team8);

        Collections.sort(teams);
        return teams;
    }

    private List<Team> loadListOfTeams2() {
        List<Team> teams = new ArrayList<>();

        Team team2 = new Team();
        team2.setId(1);
        team2.setName("Olympiacos");

        Team team3 = new Team();
        team3.setId(2);
        team3.setName("Sevila");

        Team team4 = new Team();
        team4.setId(3);
        team4.setName("Man City");

        Team team5 = new Team();
        team5.setId(4);
        team5.setName("Fulham");

        Team team6 = new Team();
        team6.setId(5);
        team6.setName("PSG");

        Team team7 = new Team();
        team7.setId(6);
        team7.setName("Milan");

        Team team8 = new Team();
        team8.setId(7);
        team8.setName("Roma");

        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        teams.add(team6);
        teams.add(team7);
        teams.add(team8);

        Collections.sort(teams);
        return teams;
    }

    private List<Place> loadListOfPlaces() {
        List<Place> places = new ArrayList<>();
        Place place1 = new Place();
        place1.setId(1);
        place1.setName("Belgrade");
        
        Place place2 = new Place();
        place2.setId(2);
        place2.setName("Madrid");
        
        Place place3 = new Place();
        place3.setId(3);
        place3.setName("London");
        
        places.add(place1);
        places.add(place2);
        places.add(place3);
        Collections.sort(places);
        return places;
    }

    private List<Referee> loadListOfReferees() {
        List<Referee> referees = new ArrayList<>();
        Referee referee1 = new Referee();
        referee1.setId(1);
        referee1.setName("Milora Mazic");
        
        Referee referee2 = new Referee();
        referee2.setId(2);
        referee2.setName("Howard Webb");
        
        Referee referee3 = new Referee();
        referee3.setId(3);
        referee3.setName("Massimo De Santis");
        
        referees.add(referee1);
        referees.add(referee2);
        referees.add(referee3);
        Collections.sort(referees);
        return referees;
    }
}
