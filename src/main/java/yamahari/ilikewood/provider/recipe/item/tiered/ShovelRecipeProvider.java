package yamahari.ilikewood.provider.recipe.item.tiered;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import yamahari.ilikewood.ILikeWood;
import yamahari.ilikewood.item.tiered.IWoodenTieredItem;
import yamahari.ilikewood.registry.objecttype.WoodenItemType;
import yamahari.ilikewood.registry.objecttype.WoodenTieredItemType;
import yamahari.ilikewood.registry.woodtype.IWoodType;
import yamahari.ilikewood.util.Constants;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Consumer;

public final class ShovelRecipeProvider extends AbstractTieredItemRecipeProvider {
    public ShovelRecipeProvider(final DataGenerator generator) {
        super(generator, WoodenTieredItemType.SHOVEL);
    }

    @Override
    protected void registerRecipes(@Nonnull final Consumer<FinishedRecipe> consumer, final IWoodType woodType, final Item tieredItem) {
        final Ingredient repair = ((IWoodenTieredItem) tieredItem).getWoodenItemTier().getRepairIngredient();
        final ItemLike stick = ILikeWood.getItem(woodType, WoodenItemType.STICK);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tieredItem)
            .define('I', stick)
            .define('#', repair)
            .pattern("#")
            .pattern("I")
            .pattern("I")
            .unlockedBy("has_material", has(repair))
            .group(String.format("%s:%s", Constants.MOD_ID, Constants.SHOVEL_PLURAL))
            .save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(tieredItem)));
    }
}