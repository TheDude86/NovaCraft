package io.novacraft.custommining;

import io.novacraft.core.NovacraftBaseProduct;
import net.minecraft.server.v1_14_R1.Block;
import net.minecraft.server.v1_14_R1.Blocks;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class CustomMiningProduct extends NovacraftBaseProduct<CustomMiningModel> {

    private final float SOIL_HARDNESS = 2f;
    private final float ROCK_HARDNESS = 10f;
    private final float HARD_ROCK_HARDNESS = 12f;

    public CustomMiningProduct(JavaPlugin plugin) {
        super(plugin);

        try {
            Field field = Block.class.getDeclaredField("strength");

            field.setAccessible(true);
            field.setFloat(Blocks.DIRT, SOIL_HARDNESS);
            field.setFloat(Blocks.GRASS_PATH, SOIL_HARDNESS);
            field.setFloat(Blocks.COARSE_DIRT, SOIL_HARDNESS);
            field.setFloat(Blocks.GRASS_BLOCK, SOIL_HARDNESS);
            field.setFloat(Blocks.PODZOL, SOIL_HARDNESS);
            field.setFloat(Blocks.MYCELIUM, SOIL_HARDNESS);
            field.setFloat(Blocks.GRAVEL, SOIL_HARDNESS);
            field.setFloat(Blocks.SAND, SOIL_HARDNESS);
            field.setFloat(Blocks.RED_SAND, SOIL_HARDNESS);
            field.setFloat(Blocks.CYAN_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.BLACK_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.BLUE_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.BROWN_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.GRAY_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.GREEN_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.LIGHT_BLUE_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.LIGHT_GRAY_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.LIME_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.MAGENTA_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.ORANGE_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.PINK_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.PURPLE_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.RED_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.WHITE_CONCRETE_POWDER, SOIL_HARDNESS);
            field.setFloat(Blocks.YELLOW_CONCRETE_POWDER, SOIL_HARDNESS);

            field.setFloat(Blocks.STONE, ROCK_HARDNESS);
            field.setFloat(Blocks.COBBLESTONE, ROCK_HARDNESS);
            field.setFloat(Blocks.ANDESITE, ROCK_HARDNESS);
            field.setFloat(Blocks.DIORITE, ROCK_HARDNESS);
            field.setFloat(Blocks.GRANITE, ROCK_HARDNESS);
            field.setFloat(Blocks.MOSSY_COBBLESTONE, ROCK_HARDNESS);

            field.setFloat(Blocks.STONE_BRICKS, HARD_ROCK_HARDNESS);
            field.setFloat(Blocks.SMOOTH_STONE, HARD_ROCK_HARDNESS);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public CustomMiningModel getInitialModel() {
        return new CustomMiningModel();
    }
}
