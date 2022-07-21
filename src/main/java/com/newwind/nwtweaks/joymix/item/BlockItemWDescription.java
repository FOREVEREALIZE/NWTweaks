package com.newwind.nwtweaks.joymix.item;

import java.util.List;

import com.newwind.nwtweaks.joymix.JoyMixNWTweaks;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BlockItemWDescription extends BlockItem {

	public BlockItemWDescription(Block p_i48527_1_, Properties p_i48527_2_) {
		super(p_i48527_1_, p_i48527_2_);
	}

	@Override
	public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip,
			ITooltipFlag flag) {
		super.appendHoverText(stack, world, tooltip, flag);
		tooltip.add(new TranslationTextComponent("description." + JoyMixNWTweaks.modid + "." + this.getRegistryName().getPath()));
	}

}
