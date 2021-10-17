/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author CARLOS ANDRES
 */

@Entity
@Table(name="message")
public class Message implements Serializable {
    
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Integer idMessage;
    
    @Column(nullable = false)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="idCar")
    @JsonIgnoreProperties({"messages","reservations"})
    private Car car;

    public Message(Integer idMessage, String messageText, Client client, Car car) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.client = client;
        this.car = car;
    }

    public Message() {
        super();
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Message{" + "idMessage=" + idMessage + ", messageText=" + messageText + ", client=" + client + ", car=" + car + '}';
    }
   
}