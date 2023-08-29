package yamahari.ilikewood.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import yamahari.ilikewood.registry.woodtype.IWoodType;
import yamahari.ilikewood.util.IWooden;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class WoodenBedBlock extends BedBlock implements IWooden {
    private final IWoodType type;
    private final DyeColor color;

    public WoodenBedBlock(final IWoodType type, final DyeColor color) {
        super(color, getProperties(color));
        this.type = type;
        this.color = color;
    }

    private static Block.Properties getProperties(final DyeColor color) {
        switch (color) {
            default -> {
                return Properties.copy(Blocks.WHITE_BED);
            }
            case ORANGE -> {
                return Properties.copy(Blocks.ORANGE_BED);
            }
            case MAGENTA -> {
                return Properties.copy(Blocks.MAGENTA_BED);
            }
            case LIGHT_BLUE -> {
                return Properties.copy(Blocks.LIGHT_BLUE_BED);
            }
            case YELLOW -> {
                return Properties.copy(Blocks.YELLOW_BED);
            }
            case LIME -> {
                return Properties.copy(Blocks.LIME_BED);
            }
            case PINK -> {
                return Properties.copy(Blocks.PINK_BED);
            }
            case GRAY -> {
                return Properties.copy(Blocks.GRAY_BED);
            }
            case LIGHT_GRAY -> {
                return Properties.copy(Blocks.LIGHT_GRAY_BED);
            }
            case CYAN -> {
                return Properties.copy(Blocks.CYAN_BED);
            }
            case PURPLE -> {
                return Properties.copy(Blocks.PURPLE_BED);
            }
            case BLUE -> {
                return Properties.copy(Blocks.BLUE_BED);
            }
            case BROWN -> {
                return Properties.copy(Blocks.BROWN_BED);
            }
            case GREEN -> {
                return Properties.copy(Blocks.GREEN_BED);
            }
            case RED -> {
                return Properties.copy(Blocks.RED_BED);
            }
            case BLACK -> {
                return Properties.copy(Blocks.BLACK_BED);
            }
        }
    }

    @Override
    public IWoodType getWoodType() {
        return this.type;
    }

    public DyeColor getDyeColor() {
        return this.color;
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull final BlockPos blockPos, @Nonnull final BlockState blockState) {
        return null;
    }

    @Nonnull
    @Override
    public RenderShape getRenderShape(@Nonnull final BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public boolean isBed(final BlockState state, final BlockGetter world, final BlockPos pos,
                         @Nullable final Entity player) {
        return true;
    }
}
