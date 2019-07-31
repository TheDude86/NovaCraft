package io.novacraft.core;

public interface ConfigMapper<T> {
    T mapConfigData(Config model);
}
