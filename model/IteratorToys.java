package model;

import java.util.List;
import java.util.Iterator;

public class IteratorToys implements Iterator {
    private int index;
    private List<Toy>  devForToys;


    public IteratorToys(List<Toy> devForToys) {
        this.devForToys = devForToys;
    }

    @Override
    public boolean hasNext() {
        return devForToys.size() > index;
    }

    public Toy next() {
        return devForToys.get(index++);
    }
}
