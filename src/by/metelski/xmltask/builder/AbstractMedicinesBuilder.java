package by.metelski.xmltask.builder;

import by.metelski.xmltask.entity.Medicine;
import by.metelski.xmltask.exception.CustomXMLParseException;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMedicinesBuilder {
    protected Set<Medicine> medicines;
    public AbstractMedicinesBuilder(){
        medicines=new HashSet<>();
    }
    public AbstractMedicinesBuilder(Set<Medicine> medicines){
        this.medicines=medicines;
    }
    public Set<Medicine> getMedicines(){
        return medicines;
    }
    public abstract void buildSetMedicines(String filename) throws CustomXMLParseException;
}
