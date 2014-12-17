package com.HaitherecreeperMC.WoFMod.event;

import com.HaitherecreeperMC.WoFMod.Base;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Events
{
  @SubscribeEvent
  public void OnCraftAnimus(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusDust)) {
      e.player.addStat(Base.getAnimusDust, 1);
    }
  }
  
  @SubscribeEvent
  public void OnCraftAnimusSword(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusSword)) {
      e.player.addStat(Base.getAnimusSword, 1);
    }
  }
  
  @SubscribeEvent
  public void OnCraftAnimusHelm(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusHelm)) {
      e.player.addStat(Base.getAnimusHelm, 1);
    }
  }
  
  @SubscribeEvent
  public void OnCraftAnimusChest(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusChest)) {
      e.player.addStat(Base.getAnimusChest, 1);
    }
  }
  
  @SubscribeEvent
  public void OnCraftAnimusPants(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusPants)) {
      e.player.addStat(Base.getAnimusPants, 1);
    }
  }
  
  @SubscribeEvent
  public void OnCraftAnimusBoots(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusBoots)) {
      e.player.addStat(Base.getAnimusBoots, 1);
    }
  }
  
  @SubscribeEvent
  public void OnCraftAnimusStone(PlayerEvent.ItemCraftedEvent e)
  {
    if (e.crafting.getItem().equals(Base.AnimusStone)) {
      e.player.addStat(Base.getAnimusStone, 1);
    }
  }
}
