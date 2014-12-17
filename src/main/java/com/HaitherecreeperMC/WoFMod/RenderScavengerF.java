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
public class RenderScavengerF
  extends RenderBiped
{
  private static final ResourceLocation female = new ResourceLocation("wofmod:textures/mobs/female.png");
  private static final String __OBFID = "CL_00001023";
  
  public RenderScavengerF()
  {
    super(new RenderManager(null,null), new ModelBiped(), 0.5F);
  }
  
  protected void preRenderCallback(EntityScavengerF par1EntityScavengerF, float par2) {}
  
  public void func_82422_c()
  {
    GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
  }
  
  protected ResourceLocation getEntityTexture(EntityScavengerF par1EntityScavengerF)
  {
    return female;
  }
  
  protected ResourceLocation getEntityTexture(EntityLiving par1EntityLiving)
  {
    return getEntityTexture((EntityScavengerF)par1EntityLiving);
  }
  
  protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
  {
    preRenderCallback((EntityScavengerF)par1EntityLivingBase, par2);
  }
  
  protected ResourceLocation getEntityTexture(Entity par1Entity)
  {
    return getEntityTexture((EntityScavengerF)par1Entity);
  }
}
