package com.HaitherecreeperMC.WoFMod;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SwordSpecial
  extends ItemSword
{
  public SwordSpecial(int par1, Item.ToolMaterial p_i45356_1_)
  {
    super(p_i45356_1_);
  }
  
  @SideOnly(Side.CLIENT)
  public boolean hasEffect(ItemStack par1ItemStack)
  {
    return true;
  }
  
  public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
  {
    target.setVelocity(0.0D, 3.0D, 0.0D);
    return true;
  }
  
  public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
  {
    list.add("Right click a mob to send it flying!");
  }
}
