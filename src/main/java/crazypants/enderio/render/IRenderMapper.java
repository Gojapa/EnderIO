package crazypants.enderio.render;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * A render mapper maps the state of a placed block or an item stack into a list of blockstates that will be rendered together.
 * <p>
 * These blockstates can belong to any block.
 *
 */
public interface IRenderMapper {

  /**
   * Get a list of blockstates to render for the given block.
   * <p>
   * Will be called in a render thread.
   */
  List<IBlockState> mapBlockRender(IBlockState state, IBlockAccess world, BlockPos pos);

  /**
   * Get a list of blockstates to render for the given item stack.
   * <p>
   * The given block is the block of the item in the stack. It is given to save the method the effort to get it out of the stack when the caller already had to
   * do it.
   */
  List<IBlockState> mapBlockRender(Block block, ItemStack stack);

}