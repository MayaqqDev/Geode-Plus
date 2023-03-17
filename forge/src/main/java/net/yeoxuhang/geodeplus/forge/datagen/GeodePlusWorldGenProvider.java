package net.yeoxuhang.geodeplus.forge.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.yeoxuhang.geodeplus.GeodePlus;
import net.yeoxuhang.geodeplus.common.registry.GeodePlusConfiguredFeatureRegistry;
import net.yeoxuhang.geodeplus.common.registry.GeodePlusPlacedFeatureRegistry;
import net.yeoxuhang.geodeplus.common.registry.GeodePlusTrimMaterialsRegistry;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GeodePlusWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, GeodePlusConfiguredFeatureRegistry::bootstrap)
            .add(Registries.PLACED_FEATURE, GeodePlusPlacedFeatureRegistry::bootstrap);
            //.add(Registries.TRIM_MATERIAL, GeodePlusTrimMaterialsRegistry::nextUpdate);

    public GeodePlusWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(GeodePlus.MOD_ID));
    }
}
