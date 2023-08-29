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

public final class StoolRecipeProvider extends AbstractBlockItemRecipeProvider {
    public StoolRecipeProvider(final DataGenerator generator) {
        super(generator, WoodenBlockType.STOOL);
    }

    @Override
    protected void registerRecipes(final @Nonnull Consumer<FinishedRecipe> consumer, final IWoodType woodType, final Block block) {
        final ItemLike strippedPost = ILikeWood.getBlock(woodType, WoodenBlockType.STRIPPED_POST);
        final ItemLike strippedLog = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ILikeWood.WOODEN_RESOURCE_REGISTRY.getStrippedLog(woodType).getResource()));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, block, 3)
            .define('#', Objects.requireNonNull(strippedLog))
            .define('I', strippedPost)
            .pattern("I#I")
            .pattern("I I")
            .group(String.format("%s:%s", Constants.MOD_ID, Constants.STOOL_PLURAL))
            .unlockedBy("has_stripped_post", has(strippedPost))
            .save(consumer, Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)));
    }
}