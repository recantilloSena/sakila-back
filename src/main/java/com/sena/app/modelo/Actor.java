package com.sena.app.modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RICARDO
 */
public class Actor {

    
    
 private Integer actorId;  
 private String firstName;
 private String lastName; 
 private Date lastUpdate;

    public Actor() {
    }
  
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
 
    public static Actor load(ResultSet rst) throws SQLException {
         Actor actor = new Actor();
         
         actor.setActorId(rst.getInt("actor_id"));
         actor.setFirstName(rst.getString("first_name"));
         actor.setLastName(rst.getString("last_name"));
         actor.setLastUpdate(rst.getDate("last_update"));
    
         return actor;
    }
    
    
    
    
    
}
