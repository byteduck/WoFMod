package com.HaitherecreeperMC.WoFMod;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Scavenger
{
  public static void mainRegistry() {
	  registerEntity();
  }
  
  public static void registerEntity()
  {
    createEntity(EntityScavenger.class, "Scavenger");
  }
  
  public static void createEntity(Class entityClass, String entityName)
  {
    int randomId = EntityRegistry.findGlobalUniqueEntityId();
    
    EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
    EntityRegistry.registerModEntity(entityClass, entityName, randomId, Base.modInstance, 64, 1, true);
    int Bg = 6697728;
    int Fg = 10203750;
    EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, Bg, Fg));
  }
}
