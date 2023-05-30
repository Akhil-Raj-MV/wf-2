package com.wellsfargo.counselor.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

class Portfolio{

    @Id
    @GeneratedValue()
    private long portfolioID;

    @Column(nullable = false)
    private String creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    protected Portfolio() {
    }

    public Portfolio(List<Security> securities,Cleint cleint) {
        this.securities = securities;
        this.client=cleint;
    }

    public long getPortfolioID(){
        return portfolioID;
    }

    public String getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(String creationDate){
        this.creationDate=creationDate;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities){
        this.securities=securities;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}