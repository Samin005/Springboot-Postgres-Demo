package io.samin005.springbootpostgresdemo.pokemons;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "moves", schema = "public", catalog = "postgres")
public class MovesEntity {
    private String dexNo;
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    @Id
    @Column(name = "dex_no")
    public String getDexNo() {
        return dexNo;
    }

    public void setDexNo(String dexNo) {
        this.dexNo = dexNo;
    }

    @Basic
    @Column(name = "move1")
    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    @Basic
    @Column(name = "move2")
    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    @Basic
    @Column(name = "move3")
    public String getMove3() {
        return move3;
    }

    public void setMove3(String move3) {
        this.move3 = move3;
    }

    @Basic
    @Column(name = "move4")
    public String getMove4() {
        return move4;
    }

    public void setMove4(String move4) {
        this.move4 = move4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovesEntity that = (MovesEntity) o;
        return Objects.equals(dexNo, that.dexNo) &&
                Objects.equals(move1, that.move1) &&
                Objects.equals(move2, that.move2) &&
                Objects.equals(move3, that.move3) &&
                Objects.equals(move4, that.move4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexNo, move1, move2, move3, move4);
    }
}
