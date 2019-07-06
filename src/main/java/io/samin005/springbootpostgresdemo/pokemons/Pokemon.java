package io.samin005.springbootpostgresdemo.pokemons;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    public String dex_no;
    public String name;
    public String description;

    public Pokemon() {

    }

    public Pokemon(String dex_no, String name, String description) {
        this.dex_no = dex_no;
        this.name = name;
        this.description = description;
    }

    public String getDex_no() {
        return dex_no;
    }

    public void setDex_no(String dex_no) {
        this.dex_no = dex_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
