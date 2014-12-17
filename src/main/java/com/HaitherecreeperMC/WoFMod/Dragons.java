package com.HaitherecreeperMC.WoFMod;

import cpw.mods.fml.common.registry.EntityRegistry;
import java.util.HashMap;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;

public class Dragons
{
  public static void mainRegistry() {
	  registerEntity();
  }
  
  public static void registerEntity()
  {
    createEntity(EntityDragons.class, "Dragons");
  }
  
  public static void createEntity(Class entityClass, String entityName)
  {
    int randomId = EntityRegistry.findGlobalUniqueEntityId();
    
    EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
    EntityRegistry.registerModEntity(entityClass, entityName, randomId, Base.modInstance, 64, 1, true);
    int Bg = 0;
    int Fg = 100;
    EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, Bg, Fg));
  }
}
