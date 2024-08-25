package com.example.tvproject;

public class SimpleProgram{
    private String id;
    private String description;
    private String metadata;

    public SimpleProgram(String id, String description, String metadata) {
        this.id = id;
        this.description = description;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
