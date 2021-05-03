package by.bakhar.task3.entity;


import by.bakhar.task3.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long, ConeParameters> coneMap;

    private Warehouse() {
        coneMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void putCone(Long id, ConeParameters coneParameters) {
        coneMap.put(id, coneParameters);
        logger.info("Cone was add " + id + " " + coneParameters);
    }

    public void removeCone(Long id) {
        coneMap.remove(id);
        logger.info("Cone was removed " + id);
    }

    public ConeParameters getConeParameters(Long id) throws ConeException {
        if (!coneMap.containsKey(id)) {
            logger.error("Cone params with such id does not exist " + id);
            throw new ConeException("Cone params with such id does not exist " + id);
        }
        return coneMap.get(id);
    }
}
