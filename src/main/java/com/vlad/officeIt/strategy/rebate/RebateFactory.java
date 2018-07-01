package com.vlad.officeIt.strategy.rebate;

import com.vlad.officeIt.strategy.rebate.implementations.SpecialDealRebate;
import com.vlad.officeIt.strategy.rebate.implementations.TimeOfYearRebate;
import com.vlad.officeIt.strategy.rebate.implementations.VolumeRebate;

public class RebateFactory {

    public Rebate getRebate(RebateType rebateType) {

        if (rebateType == null) {
            return null;
        }

        switch (rebateType) {
            case SPECIAL_DEAL:
                return new SpecialDealRebate();
            case TIME_OF_YEAR:
                return new TimeOfYearRebate();
            case VOLUME:
                return new VolumeRebate();
        }

        return null;
    }
}
