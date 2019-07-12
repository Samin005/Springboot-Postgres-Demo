package io.samin005.springbootpostgresdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokemons", schema = "public", catalog = "postgres")
public class PokemonsEntity {
    private int dexNo;
    private String name;
    private String description;

    @Id
    @Column(name = "dex_no")
    public int getDexNo() {
        return dexNo;
    }

    public void setDexNo(int dexNo) {
        this.dexNo = dexNo;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsEntity that = (PokemonsEntity) o;

        if (dexNo != that.dexNo) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dexNo;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
