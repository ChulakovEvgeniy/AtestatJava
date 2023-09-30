package model;

import java.io.Serializable;

public class Toy implements Serializable{
    private Integer uid = 1;
    private String name;
    private Integer count;
    private Float probability = null;

    public Toy(String name, Integer count) {
        this.name = name;
        this.count = count;
        uid ++;
    }

    public Integer getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public Float getProbability() {
        return probability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public void setCountMinus(){
        this.count = this.count -1;
    }

    public void setCountPlus(Integer count){
        this.count = this.count +count;
    }

    public void setProbability(Float probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Toy)) {
            return false;
        }
        Toy toy = (Toy) obj;
        return toy.name.equals(name);
    }

    @Override
    public String toString() {
        return  "name=" + name + '\'' +
                ", count=" + count +
                ", probability=" + probability;
    }
}
