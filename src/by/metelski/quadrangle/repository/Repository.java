package by.metelski.quadrangle.repository;

import by.metelski.quadrangle.entity.Quadrangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private List<Quadrangle> quadrangles = new ArrayList<>();
    public boolean add(Quadrangle quadrangle){
        return quadrangles.add(quadrangle);
    }
    public boolean addAll(Collection<? extends Quadrangle> c){
        return quadrangles.addAll(c);
    }
    public boolean removeAll(Collection<?> c){
        return quadrangles.removeAll(c);
    }
    public Quadrangle get(int index){
        return quadrangles.get(index);
    }
    public Quadrangle set(int index,Quadrangle quadrangle){
        return quadrangles.set(index,quadrangle);
    }
    public List<Quadrangle> query(Specification specification){
        List<Quadrangle> list = quadrangles.stream().filter(o->specification.specify(o)).collect(Collectors.toList());
        return list;
    }
}
