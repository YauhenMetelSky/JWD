package by.metelski.quadrangle.repository;

import by.metelski.quadrangle.entity.Quadrangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Repository {
    private List<Quadrangle> quadrangles = new ArrayList<>();
    public static final Logger logger = LogManager.getLogger();

    public boolean add(Quadrangle quadrangle) {
        logger.log(Level.INFO, "new shape added: " + quadrangle);
        return quadrangles.add(quadrangle);
    }

    public boolean addAll(Collection<? extends Quadrangle> c) {
        logger.log(Level.INFO, "new collection added to repository: " + c);
        return quadrangles.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        logger.log(Level.INFO, "collection removed from repository: " + c);
        return quadrangles.removeAll(c);
    }

    public List<Quadrangle> getAll() {
        logger.log(Level.INFO, "got all repository ");
        return Collections.unmodifiableList(quadrangles);
    }

    public Optional<Quadrangle> get(int index) {
        logger.log(Level.DEBUG, "index=" + index + " quadrangles size=" + quadrangles.size());
        return Optional.of(quadrangles.get(index));
    }

    public Quadrangle set(int index, Quadrangle quadrangle) {
        logger.log(Level.INFO, "new quadrangle:" + quadrangle + " added to repository place:" + index);
        return quadrangles.set(index, quadrangle);
    }

    public List<Quadrangle> query(Specification specification) {
        List<Quadrangle> list = quadrangles.stream().filter(specification::specify).collect(Collectors.toList());
        logger.log(Level.DEBUG, "returned list " + list);
        return list;
    }

    public void sortByParameter(Comparator<Quadrangle> comparator) {
        quadrangles.sort(comparator);
    }
}
