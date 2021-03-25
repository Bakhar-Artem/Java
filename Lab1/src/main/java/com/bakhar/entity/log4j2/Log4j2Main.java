package com.bakhar.entity.log4j2;

import com.bakhar.entity.array.DynArray;
import com.bakhar.entity.array.DynArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j2Main {
    static Logger logger= LogManager.getLogger();

    public static void main(String[] args) {
        DynArray array=new DynArray();
        array.add(4);
        try {
            array.getAt(4);
            logger.info("getAt() success!");
        }catch (DynArrayException e){
            logger.error("getAt() error!");
        }
    }
}
