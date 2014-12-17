package com.HaitherecreeperMC.WoFMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class AnimusArmor
  extends ItemArmor
{
  public AnimusArmor(ItemArmor.ArmorMaterial material, int id, int placement)
  {
    super(material, id, placement);
  }
  
  @SideOnly(Side.CLIENT)
  public boolean hasEffect(ItemStack par1ItemStack)
  {
    return true;
  }
  
  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
  {
    if ((stack.getItem() == Base.AnimusHelm) || (stack.getItem() == Base.AnimusChest) || (stack.getItem() == Base.AnimusBoots)) {
      return "wofmod:textures/models/armor/animus_layer_1.png";
    }
    if (stack.getItem() == Base.AnimusPants) {
      return "wofmod:textures/models/armor/animus_layer_2.png";
    }
    return null;
  }
}
