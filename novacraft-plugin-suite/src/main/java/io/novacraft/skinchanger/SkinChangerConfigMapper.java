package io.novacraft.skinchanger;

import io.novacraft.core.Config;
import io.novacraft.core.ConfigMapper;

public class SkinChangerConfigMapper implements ConfigMapper<SkinChangerModel> {
    @Override
    public SkinChangerModel mapConfigData(Config model) {
        SkinChangerModel skinModel = new SkinChangerModel();

        return skinModel;
    }
}
