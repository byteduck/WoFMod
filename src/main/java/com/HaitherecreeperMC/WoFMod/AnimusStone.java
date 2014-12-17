package com.HaitherecreeperMC.WoFMod;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class AnimusStone
  extends Item
{
  private EntityLiving _target;
  private boolean _flag;
  
  public AnimusStone()
  {
    setUnlocalizedName("AnimusStone");
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("modid:AnimusStone", "inventory"));
  }
  
  public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
  {
    list.add("Right click an entity to levitate it!");
  }
  
  public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
  {
    if (!player.worldObj.isRemote)
    {
      this._flag = (this._target != null);
      if (this._flag)
      {
        this._target = null;
      }
      else if (target != null)
      {
        this._target = ((EntityLiving)target);
        

        this._flag = true;
      }
    }
    return super.itemInteractionForEntity(itemStack, player, target);
  }
  
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag)
  {
    if (!world.isRemote)
    {
      EntityPlayer player = (EntityPlayer)entity;
      if ((this._target != null) && (player.getHeldItem() != null) && (player.getHeldItem().getItem() == this))
      {
        Vec3 vec3d = player.getLookVec();
        double d = player.posX + vec3d.xCoord * 3.0D - this._target.posX;
        double d1 = player.posY + vec3d.yCoord * 3.0D - this._target.posY;
        double d2 = player.posZ + vec3d.zCoord * 3.0D - this._target.posZ;
        double d3 = Math.sqrt(d * d + d1 * d1 + d2 * d2);
        this._target.motionX = (d / d3 * 0.25D);
        this._target.motionY = (d1 / d3 * 0.25D);
        this._target.motionZ = (d2 / d3 * 0.25D);
        this._target.fallDistance = 0.0F;
      }
      if ((this._target != null) && (player.getHeldItem() != null) && (player.getHeldItem().getItem() != this)){
    	  this._flag = false;
    	  this._target = null;
      }else if((this._target != null) && (player.getHeldItem() == null)){
    	  this._flag = false;
    	  this._target = null;
      }
    }
  }
}
