package net.yeoxuhang.geodeplus.forge.biome_modifiers.overworld.stone;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.yeoxuhang.geodeplus.common.config.GeodePlusCommonConfigs;
import net.yeoxuhang.geodeplus.common.registry.GeodePlusTagRegistry;


public class DiamondGeodeModifier implements BiomeModifier {
    private final Holder<PlacedFeature> features;

    public DiamondGeodeModifier(Holder<PlacedFeature> features) {
        this.features = features;
    }
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase == Phase.ADD) {
            biomeModificationAddPhase(biome, builder);
        }
    }

    private void biomeModificationAddPhase(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (biome.is(GeodePlusTagRegistry.Biomes.HAS_DIAMOND_GEODE )&& GeodePlusCommonConfigs.SHOULD_GENERATE_STONE_DIAMOND_GEODE.get()) {
            builder.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, features);
        }
    }
    @Override
    public Codec<? extends BiomeModifier> codec() {
        return DiamondGeodeModifier.makeCodec();
    }

    public static Codec<DiamondGeodeModifier> makeCodec() {
        return RecordCodecBuilder.create((config) -> {
            return config.group(PlacedFeature.CODEC.fieldOf("feature").forGetter((otherConfig) -> {
                return otherConfig.features;
            })).apply(config, DiamondGeodeModifier::new);
        });
    }
}