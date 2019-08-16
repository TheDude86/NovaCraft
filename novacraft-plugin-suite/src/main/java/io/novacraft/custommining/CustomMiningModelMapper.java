package io.novacraft.custommining;

import io.novacraft.core.Config;
import io.novacraft.core.ConfigMapper;

public class CustomMiningModelMapper implements ConfigMapper<CustomMiningModel> {
    @Override
    public void mapConfigData(CustomMiningModel productModel, Config model) {
        productModel.hardcoreEnabled = model.hardcore_enabled;
    }
}
