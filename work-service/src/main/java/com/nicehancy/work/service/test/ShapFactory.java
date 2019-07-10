package com.nicehancy.work.service.test;

import com.nicehancy.work.service.api.model.test.Shap;

/**
 * <p>
 *     工厂
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/7/9 16:47
 **/
public class ShapFactory {

    public Shap getShap(String shapType){
        if(null == shapType){
            return null;
        }

        if(shapType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}