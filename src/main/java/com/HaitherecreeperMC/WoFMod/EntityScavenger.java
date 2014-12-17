package com.HaitherecreeperMC.WoFMod;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityScavenger
  extends EntityAnimal
  implements IRangedAttackMob
{
  private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
  private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
  private static final String __OBFID = "CL_00001697";
  
  public EntityScavenger(World par1World)
  {
    super(par1World);
    setSize(0.6F, 1.8F);
    setCanPickUpLoot(true);
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(2, new EntityAIMoveIndoors(this));
    this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
    this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
    this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
    this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
    this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    this.tasks.addTask(12, new EntityAIAttackOnCollide(this, 1.0D, false));
    this.tasks.addTask(19, new EntityAIFollowParent(this, this.newPosX));
    this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
    if ((par1World != null) && (!par1World.isRemote)) {
      setCombatTask();
    }
  }
  
  protected void applyEntityAttributes()
  {
    super.applyEntityAttributes();
    getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
  }
  
  protected void entityInit()
  {
    super.entityInit();
    this.dataWatcher.addObject(13, new Byte((byte)0));
  }
  
  public boolean isAIEnabled()
  {
    return true;
  }
  
  public boolean attackEntityAsMob(Entity par1Entity)
  {
    return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0F);
  }
  
  public EnumCreatureAttribute getCreatureAttribute()
  {
    return EnumCreatureAttribute.UNDEFINED;
  }
  
  public void updateRidden()
  {
    super.updateRidden();
    if ((this.ridingEntity instanceof EntityCreature))
    {
      EntityCreature entitycreature = (EntityCreature)this.ridingEntity;
      this.renderYawOffset = entitycreature.renderYawOffset;
    }
  }
  
  protected void addRandomArmor()
  {
    super.addRandomArmor();
    if (this.rand.nextFloat() < (this.worldObj.getDifficulty() == EnumDifficulty.HARD ? 0.05F : 0.01F))
    {
      int i = this.rand.nextInt(3);
      if (i == 0) {
        setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
      } else {
        setCurrentItemOrArmor(0, new ItemStack(Items.iron_shovel));
      }
    }
  }
  
  public void setCombatTask()
  {
    this.tasks.removeTask(this.aiAttackOnCollide);
    this.tasks.removeTask(this.aiArrowAttack);
    ItemStack itemstack = getHeldItem();
    if ((itemstack != null) && (itemstack.getItem() == Items.bow)) {
      this.tasks.addTask(4, this.aiArrowAttack);
    } else {
      this.tasks.addTask(4, this.aiAttackOnCollide);
    }
  }
  
  public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
  {
    EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, 14 - this.worldObj.getDifficulty().getDifficultyId() * 4);
    int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, getHeldItem());
    int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, getHeldItem());
    entityarrow.setDamage(par2 * 2.0F + this.rand.nextGaussian() * 0.25D + this.worldObj.getDifficulty().getDifficultyId() * 0.11F);
    if (i > 0) {
      entityarrow.setDamage(entityarrow.getDamage() + i * 0.5D + 0.5D);
    }
    if (j > 0) {
      entityarrow.setKnockbackStrength(j);
    }
    if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, getHeldItem()) > 0) {
      entityarrow.setFire(100);
    }
    playSound("random.bow", 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
    this.worldObj.spawnEntityInWorld(entityarrow);
  }
  
  public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readEntityFromNBT(par1NBTTagCompound);
    
    setCombatTask();
  }
  
  public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.writeEntityToNBT(par1NBTTagCompound);
  }
  
  public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
  {
    super.setCurrentItemOrArmor(par1, par2ItemStack);
    if ((!this.worldObj.isRemote) && (par1 == 0)) {
      setCombatTask();
    }
  }
  
  public double getYOffset()
  {
    return super.getYOffset() - 0.5D;
  }
  
  public EntityAgeable createChild(EntityAgeable var1)
  {
    Random r = new Random();
    int Gender = r.nextInt(2) + 1;
    switch (Gender)
    {
    case 1: 
      return new EntityScavenger(this.worldObj);
    case 2: 
      return new EntityScavengerF(this.worldObj);
    }
    return new EntityScavenger(this.worldObj);
  }
}
