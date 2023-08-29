package yamahari.ilikewood.provider.itemmodel.tiered;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.item.tiered.IWoodenTieredItem;
import yamahari.ilikewood.plugin.vanilla.VanillaWoodenItemTiers;
import yamahari.ilikewood.registry.objecttype.WoodenItemType;
import yamahari.ilikewood.registry.objecttype.WoodenTieredItemType;
import yamahari.ilikewood.util.Constants;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.Util;

import javax.annotation.Nonnull;
import java.util.Objects;

public abstract class AbstractTieredItemModelProvider
    extends ItemModelProvider
{
    private final WoodenTieredItemType tieredItemType;

    public AbstractTieredItemModelProvider(
        final DataGenerator generator,
        final ExistingFileHelper helper,
        final WoodenTieredItemType tieredItemType
    )
    {
        super(generator.getPackOutput(), Constants.MOD_ID, helper);
        this.tieredItemType = tieredItemType;
    }

    @Override
    protected void registerModels()
    {
        ILikeWood.TIERED_ITEM_REGISTRY.getObjects(this.tieredItemType).forEach(this::registerModel);
    }

    protected abstract void registerModel(Item item);

    protected void tieredItem(
        final Item item,
        final String path
    )
    {
        final var woodType = ((IWooden) item).getWoodType();
        final var itemTier = ((IWoodenTieredItem) item).getWoodenItemTier();
        final var tier = itemTier.getName();
        final var isWood = ((IWoodenTieredItem) item).getWoodenItemTier().isWood();
        this
            .withExistingParent(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item), "Registry name was null").getPath(),
                mcLoc(Util.toPath(ITEM_FOLDER, "handheld"))
            )
            .texture(
                "layer0", modLoc(Util.toPath(ITEM_FOLDER, WoodenItemType.STICK.getName(), woodType.getModId(),
                    path + (itemTier.equals(VanillaWoodenItemTiers.NETHERITE) ? "/netherite" : ""), woodType.getName()
                )))
            .texture("layer1", modLoc(Util.toPath(ITEM_FOLDER, path + (isWood ? "/" + woodType.getModId() + "/wooden" : ""), tier)));
    }

    @Nonnull
    @Override
    public String getName()
    {
        return String.format("%s - tiered item models - %s", Constants.MOD_ID, this.tieredItemType.getName());
    }
}
