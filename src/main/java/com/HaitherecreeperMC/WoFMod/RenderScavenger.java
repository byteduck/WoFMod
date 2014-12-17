package com.HaitherecreeperMC.WoFMod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderScavenger
  extends RenderBiped
{
  private static final ResourceLocation male = new ResourceLocation("wofmod:textures/mobs/male.png");
  private static final String __OBFID = "CL_00001023";
  
  public RenderScavenger()
  {
	  super(new RenderManager(null,null), new ModelBiped(), 0.5F);
  }
  
  protected void preRenderCallback(EntityScavenger par1EntityScavenger, float par2) {}
  
  public void func_82422_c()
  {
    GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
  }
  
  protected ResourceLocation getEntityTexture(EntityScavenger par1EntityScavenger)
  {
    return male;
  }
  
  protected ResourceLocation getEntityTexture(EntityLiving par1EntityLiving)
  {
    return getEntityTexture((EntityScavenger)par1EntityLiving);
  }
  
  protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
  {
    preRenderCallback((EntityScavenger)par1EntityLivingBase, par2);
  }
  
  protected ResourceLocation getEntityTexture(Entity par1Entity)
  {
    return getEntityTexture((EntityScavenger)par1Entity);
  }
}
