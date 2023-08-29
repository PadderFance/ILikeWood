package yamahari.ilikewood.provider.itemmodel;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import yamahari.ilikewood.registry.objecttype.WoodenItemType;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.Util;

import java.util.Objects;

public final class FishingRodItemModelProvider
    extends AbstractItemModelProvider
{
    public FishingRodItemModelProvider(
        final DataGenerator generator,
        final ExistingFileHelper helper
    )
    {
        super(generator, helper, WoodenItemType.FISHING_ROD);
    }

    @Override
    protected void registerModel(final Item item)
    {
        final var woodType = ((IWooden) item).getWoodType();

        this
            .getBuilder(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath())
            .parent(new ModelFile.UncheckedModelFile(mcLoc(Util.toPath(ITEM_FOLDER, "handheld_rod"))))
            .texture("layer0", modLoc(Util.toPath(ITEM_FOLDER, WoodenItemType.FISHING_ROD.getName(), woodType.getModId(), woodType.getName())))
            .override()
            .predicate(mcLoc("cast"), 1.0F)
            .model(new ModelFile.UncheckedModelFile(
                modLoc(Util.toPath(ITEM_FOLDER, Util.toRegistryName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath(), "cast")))))
            .end();

        this
            .getBuilder(Util.toRegistryName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath(), "cast"))
            .parent(new ModelFile.UncheckedModelFile(modLoc(Util.toPath(ITEM_FOLDER, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath()))))
            .texture("layer0", modLoc(Util.toPath(ITEM_FOLDER, WoodenItemType.FISHING_ROD.getName(), woodType.getModId(), "cast", woodType.getName())));
    }
}
