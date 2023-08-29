package yamahari.ilikewood.provider.recipe.blockitem;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.registry.objecttype.WoodenBlockType;
import yamahari.ilikewood.registry.woodtype.IWoodType;
import yamahari.ilikewood.util.Constants;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Consumer;

public final class PostRecipeProvider extends AbstractBlockItemRecipeProvider {
    public PostRecipeProvider(final DataGenerator generator) {
        super(generator, WoodenBlockType.POST);
    }

    @Override
    protected void registerRecipes(@Nonnull final Consumer<FinishedRecipe> consumer, final IWoodType woodType, final Block block) {
        if (ILikeWood.WOODEN_RESOURCE_REGISTRY.hasLog(woodType)) {
            final ItemLike log = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ILikeWood.WOODEN_RESOURCE_REGISTRY.getLog(woodType).getResource()));

            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, block, 6)
                .define('#', Objects.requireNonNull(log))
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_log", has(log))
                .group(String.format("%s:%s", Constants.MOD_ID, Constants.POST_PLURAL))
                .save(consumer, Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)));
        }
    }
}