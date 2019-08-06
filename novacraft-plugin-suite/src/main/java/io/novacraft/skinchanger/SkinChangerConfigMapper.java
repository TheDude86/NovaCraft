package io.novacraft.skinchanger;

import io.novacraft.core.Config;
import io.novacraft.core.ConfigMapper;

public class SkinChangerConfigMapper implements ConfigMapper<SkinChangerModel> {
    @Override
    public void mapConfigData(SkinChangerModel productModel, Config model) {
        productModel.test = true;
    }
}
