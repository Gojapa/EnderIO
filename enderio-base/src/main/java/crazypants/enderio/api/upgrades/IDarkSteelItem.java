package crazypants.enderio.api.upgrades;

import javax.annotation.Nonnull;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * This interface for {@link Item}s marks them as being eligible for {@link IDarkSteelUpgrade}s. Ender IO will also handle repairing them if
 * {@link #isItemForRepair(ItemStack)} returns true.
 * 
 * @author Henry Loenwind
 *
 */
public interface IDarkSteelItem {

  /**
   * @return The number of {@link #isItemForRepair(ItemStack)} items it takes to repair this item fully. Usually as many as are used in the crafting recipe.
   */
  default int getIngotsRequiredForFullRepair() {
    return 9;
  }

  /**
   * Checks if the given item (anvil slot "right") can be used to repair this.
   * <p>
   * If this never returns true, Ender IO will leave the item alone.
   * 
   * @param right
   *          The item to test.
   * @return True if this is a repair item (e.g. dark steel ingots).
   */
  default boolean isItemForRepair(@Nonnull ItemStack right) {
    return false;
  }

  /**
   * Checks if this item is for the given equipment slot.
   * <p>
   * Used by upgrades to determine if they can be applied to an item.
   */
  default boolean isForSlot(@Nonnull EntityEquipmentSlot slot) {
    return false;
  }

  /**
   * Checks if this item is a pickaxe.
   * <p>
   * Used by upgrades to determine if they can be applied to an item.
   */
  default boolean isPickaxe() {
    return false;
  }

  /**
   * Checks if this item is an axe.
   * <p>
   * Used by upgrades to determine if they can be applied to an item.
   */
  default boolean isAxe() {
    return false;
  }

  /**
   * Checks if this item has the needed code support for the given upgrade.
   * <p>
   * Used by some upgrades to determine if they can be applied to an item. Only upgrades that need the item to have supporting code will call this, e.g. the
   * Spoon upgrade needs the item to have a specialized canHarvestBlock() and getToolClasses().
   * <p>
   * Note that the energy upgrade is implicit.
   */
  default boolean hasUpgradeCallbacks(@Nonnull IDarkSteelUpgrade upgrade) {
    return false;
  }

}
