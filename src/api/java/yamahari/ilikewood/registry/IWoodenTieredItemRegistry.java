package yamahari.ilikewood.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import yamahari.ilikewood.registry.objecttype.WoodenTieredItemType;
import yamahari.ilikewood.registry.woodenitemtier.IWoodenItemTier;
import yamahari.ilikewood.registry.woodtype.IWoodType;

import java.util.stream.Stream;

public interface IWoodenTieredItemRegistry {
    /**
     * @param woodenItemTier
     * @param woodType
     * @param tieredItemType
     * @return
     * @throws IllegalArgumentException
     */
    RegistryObject<Item> getRegistryObject(IWoodenItemTier woodenItemTier, IWoodType woodType,
                                           WoodenTieredItemType tieredItemType) throws IllegalArgumentException;

    /**
     * @param woodType
     * @param tieredItemType
     * @return
     * @throws IllegalArgumentException
     */
    Stream<RegistryObject<Item>> getRegistryObjects(IWoodType woodType, WoodenTieredItemType tieredItemType)
        throws IllegalArgumentException;

    /**
     * @param tieredItemType
     * @return
     */
    Stream<RegistryObject<Item>> getRegistryObjects(WoodenTieredItemType tieredItemType);

    /**
     * @param woodenItemTier
     * @param woodType
     * @param tieredItemType
     * @return
     * @throws IllegalArgumentException
     */
    Item getObject(IWoodenItemTier woodenItemTier, IWoodType woodType, WoodenTieredItemType tieredItemType)
        throws IllegalArgumentException;

    /**
     * @param woodType
     * @param tieredItemType
     * @return
     * @throws IllegalArgumentException
     */
    Stream<Item> getObjects(IWoodType woodType, WoodenTieredItemType tieredItemType) throws IllegalArgumentException;

    /**
     * @param tieredItemType
     * @return
     */
    Stream<Item> getObjects(WoodenTieredItemType tieredItemType);
}
