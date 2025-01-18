package com.example.demo;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Analyse")
public class Analyse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String libelle;
    private String type;
    private String description;
    private ObjectId idPatient;

    public Analyse() {
    }

    public Analyse(String libelle, String type, String description, ObjectId idPatient) {
        this.libelle = libelle;
        this.type = type;
        this.description = description;
        this.idPatient = idPatient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ObjectId getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(ObjectId idPatient) {
        this.idPatient = idPatient;
    }

    @Override
    public String toString() {
        return "Analyse [id=" + id + ", libelle=" + libelle + ", type=" + type + ", description=" + description
                + ", idPatient=" + idPatient + "]";
    }
}

// <http:listener-config name="HTTP_Listener_config" doc:name="HTTP Listener
// config" doc:id="1f37d128-cabd-416d-8f3e-f904e11e8f49" >
// <http:listener-connection host="0.0.0.0" port="4200" />
// </http:listener-config>
// <http:request-config name="HTTP_Request_configuration" doc:name="HTTP Request
// configuration" doc:id="08099109-e8d1-4f6f-b6c0-8269e432c5f7"
// basePath="/analyse" >
// <http:request-connection host="localhost" port="8084" />
// </http:request-config>
// <flow name="examFlow" doc:id="9a8b388c-cb44-4aca-98de-25743fb9b5e3" >
// <http:listener doc:name="Listener"
// doc:id="2c692194-1a01-419c-b961-fba06fdf9d18"
// config-ref="HTTP_Listener_config" path="/exam"/>
// <http:request method="POST" doc:name="Analyse"
// doc:id="7f6d6251-90f7-48f0-8587-d6ea73469a0d"
// config-ref="HTTP_Request_configuration" path="/"/>
// </flow>