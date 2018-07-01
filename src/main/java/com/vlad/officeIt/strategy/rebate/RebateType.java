package com.vlad.officeIt.strategy.rebate;

public enum RebateType {
    VOLUME,
    TIME_OF_YEAR,
    SPECIAL_DEAL;

    public static RebateType getRebateByName(String rebateString) {
        for (RebateType cursor : RebateType.values()) {
            if (cursor.name().equals(rebateString)) {
                return cursor;
            }
        }
        
        return null;
    }
}
