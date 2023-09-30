package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DeviceForToys implements Serializable, Iterable<Toy>{
    private List<Toy> devForToys;

    public DeviceForToys() {
        this.devForToys = new ArrayList<>();
    }

    public void addToys(Toy toys) {
        if (!devForToys.contains(toys)) {
            devForToys.add(toys);
            probality();
        }
    }
    @Override
    public IteratorToys iterator() {
        return new IteratorToys(devForToys);
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (Toy toys : devForToys) {
            sb.append(toys);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public Toy change(Integer index){
        if (index == 0){
            return (Toy) devForToys.get(0);
        }else {
            return (Toy) devForToys.get(index-1);
        }
    }

    public void probality(){
        int summ = 0;
        for (Toy toys : devForToys) {
            summ +=toys.getCount();
        }
        for (Toy toys : devForToys){
            toys.setProbability((float) (toys.getCount()*100/summ));
        }
    }

}
