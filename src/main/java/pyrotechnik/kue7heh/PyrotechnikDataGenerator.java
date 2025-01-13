package pyrotechnik.kue7heh;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import pyrotechnik.kue7heh.data.generator.PyrotechnikEnchantmentGenerator;

public class PyrotechnikDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(PyrotechnikEnchantmentGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}