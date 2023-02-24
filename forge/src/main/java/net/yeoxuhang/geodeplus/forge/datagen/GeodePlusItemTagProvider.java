package net.yeoxuhang.geodeplus.forge.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.yeoxuhang.geodeplus.GeodePlus;

import java.util.concurrent.CompletableFuture;

public class GeodePlusItemTagProvider extends ItemTagsProvider {
    public GeodePlusItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider provider, ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, provider, GeodePlus.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider p_256380_) {
    }
}