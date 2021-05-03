package by.bakhar.task3.observer.impl;

import by.bakhar.task3.entity.Cone;
import by.bakhar.task3.entity.ConeParameters;
import by.bakhar.task3.entity.Warehouse;
import by.bakhar.task3.exception.ConeException;
import by.bakhar.task3.observer.ConeEvent;
import by.bakhar.task3.observer.ConeObserver;
import by.bakhar.task3.service.CountSquareVolume;
import by.bakhar.task3.service.impl.CountSquareVolumeImpl;
import by.bakhar.task3.validation.ConeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConeObserverImpl implements ConeObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateSquare(ConeEvent coneEvent) throws ConeException {
        Cone cone = coneEvent.getSource();
        if (!ConeValidator.isValid(cone)) {
            logger.error("Cone became invalid! " + cone);
            throw new ConeException("Cone became invalid! " + cone);
        }
        Warehouse warehouse = Warehouse.getInstance();
        Long coneId = cone.getId();
        ConeParameters coneParameters = warehouse.getConeParameters(coneId);
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double square = countSquareVolume.countSquare(cone);
        coneParameters.setSquare(square);
        logger.info("Square was updated to "+square);
    }

    @Override
    public void updateVolume(ConeEvent coneEvent) throws ConeException {
        Cone cone = coneEvent.getSource();
        if (!ConeValidator.isValid(cone)) {
            logger.error("Cone became invalid! " + cone);
            throw new ConeException("Cone became invalid! " + cone);
        }
        Warehouse warehouse = Warehouse.getInstance();
        Long coneId = cone.getId();
        ConeParameters coneParameters = warehouse.getConeParameters(coneId);
        CountSquareVolume countSquareVolume = new CountSquareVolumeImpl();
        double volume = countSquareVolume.countVolume(cone);
        coneParameters.setVolume(volume);
        logger.info("Volume was updated to "+volume);
    }
}
