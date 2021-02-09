package by.metelski.xmltask.factory;

import by.metelski.xmltask.builder.AbstractMedicinesBuilder;
import by.metelski.xmltask.builder.MedicinesDomBuilder;
import by.metelski.xmltask.builder.MedicinesSaxBuilder;
import by.metelski.xmltask.builder.MedicinesStaxBuilder;

public class MedicineBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    public static AbstractMedicinesBuilder createMedicineBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        AbstractMedicinesBuilder builder;
        switch (type) {
            case DOM:
                builder = new MedicinesDomBuilder();
                break;
            case SAX:
                builder = new MedicinesSaxBuilder();
                break;
            case STAX:
                builder = new MedicinesStaxBuilder();
                break;
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
        return builder;
    }
}
