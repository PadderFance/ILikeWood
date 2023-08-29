package yamahari.ilikewood.provider.itemmodel.blockitem;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.util.Constants;
import yamahari.ilikewood.util.IWooden;
import yamahari.ilikewood.util.Util;

import javax.annotation.Nonnull;
import java.util.Objects;

public abstract class AbstractBlockItemModelProvider
    extends ItemModelProvider
{
    private final WoodenBlockType blockType;

    public AbstractBlockItemModelProvider(
        final DataGenerator generator,
        final ExistingFileHelper helper,
        final WoodenBlockType blockType
    )
    {
        super(generator.getPackOutput(), Constants.MOD_ID, helper);
        this.blockType = blockType;
    }

    @Override
    protected void registerModels()
    {
        if (this.blockType == WoodenBlockType.WHITE_BED)
        {
            ILikeWood.BLOCK_REGISTRY.getObjects(WoodenBlockType.getBeds()).forEach(this::registerModel);
        }
        else
        {
            ILikeWood.BLOCK_REGISTRY.getObjects(this.blockType).forEach(this::registerModel);
        }
    }

    protected abstract void registerModel(Block block);

    protected void blockItem(
        final Block block,
        final String path
    )
    {
        final var woodType = ((IWooden) block).getWoodType().getName();
        this
            .getBuilder(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block), "Registry name was null.").getPath())
            .parent(new ModelFile.UncheckedModelFile(modLoc(Util.toPath(BLOCK_FOLDER, path, woodType))));
    }

    @Nonnull
    @Override
    public String getName()
    {
        return String.format("%s - block item models - %s", Constants.MOD_ID, this.blockType.getName());
    }
}
