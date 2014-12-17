package com.HaitherecreeperMC.WoFMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

class NewTab
  extends CreativeTabs
{
  NewTab(int tabIndex, String name)
  {
    super(tabIndex, name);
  }
  
  public Item getTabIconItem()
  {
    return Base.MudScale;
  }
}
