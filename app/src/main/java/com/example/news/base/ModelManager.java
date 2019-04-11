package com.example.news.base;

import java.lang.reflect.Constructor;

public class ModelManager {
    private static final ModelManager ourInstance = new ModelManager();

    public static ModelManager getInstance() {
        return ourInstance;
    }

    private ModelManager() {
    }

    public <M> M getmodel(Class<M> modelclass){
        try {
            Constructor<M> constructor = modelclass.getConstructor();
            M instance  = constructor.newInstance();

            return instance ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
