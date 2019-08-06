package io.novacraft.core;

public interface ConfigMapper<T> {
    //TODO: Add Callbacks for success and failures to map data
    void mapConfigData(T productModel, Config model);
}
