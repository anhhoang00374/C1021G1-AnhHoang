package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
@NamedQuery(name = "findByName",query = "select c from Blog as c where  c.title =: name")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String summary;

    public Blog() {
    }

    public Blog(Long id, String title, String body, String summary) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
