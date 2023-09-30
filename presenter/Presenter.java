package presenter;

import model.Service;
import model.Toy;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter (View view) {
        this.view = view;
        service = new Service();
    }

    public void getToyInfo() {
        String info = service.getToyInfo();
        view.printAnswer(info);
    }

    public void save(String name) {
        service.save(name);
    }

    public void read(String name) {
        service.read(name);
    }

    public Toy change(String indexStr) {
        Integer index = Integer.parseInt(indexStr);
        return service.change(index);

    }
    public void addCount(Toy toy,Integer count){
        toy.setCount(count);
    }

    public void changeProbability(Toy toy,Float probability){
        toy.setProbability(probability);
    }

    public void roulette(){
        view.printAnswer(service.roulette());
    }

    public void addToy(String name, int intCount) {
        service.addToy(name,intCount);
        view.printAnswer("Запись успешно добавлена");
    }
}
