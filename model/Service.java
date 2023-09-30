package model;

import model.saveAndRead.SaveAndRead;
import model.saveAndRead.Writable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {
    private DeviceForToys deviceForToys;
    private Writable writable;
    private File file;
    public Service() {

        deviceForToys = new DeviceForToys();
        this.writable = new SaveAndRead();
    }

    public String getToyInfo() {
        StringBuilder sb = new StringBuilder();
        int i =1;
        for (Toy toy : deviceForToys) {
            sb.append(i++ + ". ");
            sb.append(toy);
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean save(String file){
        return writable.save(deviceForToys, String.valueOf(file));
    }
    public Object read(String file){
        return this.deviceForToys = ((DeviceForToys) writable.read(file));
    }

    public Toy change(Integer index) {
        return deviceForToys.change(index);
    }

    public String roulette(){
        Random random = new Random();
        List temp = new ArrayList<>();

        for (Toy toy:deviceForToys) {
            for (int i = 0; i < toy.getCount(); i++) {
                temp.add(toy.getName());
            }
        }
        int rd = random.nextInt(0, temp.size());
        String rulet = (String) temp.get(rd);
        for (Toy toy:deviceForToys) {
            if (toy.getName().equalsIgnoreCase(rulet)){
                toy.setCountMinus();
                deviceForToys.probality();
            }
        }
        try(FileWriter writer = new FileWriter("data.txt", true))
        {
            writer.write(rulet);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return rulet;
    }

    public void addToy(String name, int intCount) {
        Toy toy = new Toy(name, intCount);
        deviceForToys.addToys(toy);
    }
}
