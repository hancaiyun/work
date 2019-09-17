package com.nicehancy.work.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *     数据源枚举
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/9/17 10:21
 **/
@Getter
@AllArgsConstructor
public enum DataSuorceEnum {

    /**
     * MySQL
     */
    MYSQL("MYSQL","MySQL"),

    /**
     * MongoDB
     */
    MONGODB("MONGODB","MongoDB"),
    ;

    private String code;

    private String desc;

    public static DataSuorceEnum explain(String dataSource) {

        for(DataSuorceEnum dataSuorceEnum : DataSuorceEnum.values()){
            if(dataSuorceEnum.getCode().equals(dataSource)){
                return dataSuorceEnum;
            }
        }
        return null;
    }
}
