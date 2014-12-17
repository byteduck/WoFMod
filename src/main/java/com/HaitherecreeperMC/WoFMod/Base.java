package com.HaitherecreeperMC.WoFMod;

import com.HaitherecreeperMC.WoFMod.event.Events;












import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="wofmod", version="")
public class Base
{
  @Mod.Instance("wofmod")
  public static Base modInstance;
  public static final String MODID = "wofmod";
  public static final String VERSION = "";
  public static Item MudScale;
  public static Item SeaScale;
  public static Item NightScale;
  public static Item SandScale;
  public static Item RainScale;
  public static Item IceScale;
  public static Item SkyScale;
  public static Item AnimusDust;
  public static Item AnimusCrystal;
  public static Item AnimusSword;
  public static Item AnimusStone;
  public static Block BlockAnimus;
  public static Achievement getAnimusDust;
  public static Achievement getAnimusSword;
  public static Achievement getAnimusHelm;
  public static Achievement getAnimusChest;
  public static Achievement getAnimusPants;
  public static Achievement getAnimusBoots;
  public static Achievement getAnimusStone;
  public static int AnimusChestID;
  public static int AnimusHelmID;
  public static int AnimusBootsID;
  public static int AnimusPantsID;
  //public static Item.ToolMaterial AnimusSwordmat = EnumHelper.addToolMaterial("AnimusSwordMat", 3, -1, 25.0F, 50.0F, 0);
  //public static ItemArmor.ArmorMaterial AnimusArmorMaterial = EnumHelper.addArmorMaterial("AnimusArmorMaterial", 1000000, new int[] { 6, 16, 12, 6 }, 0);
  //public static Item AnimusHelm = new AnimusArmor(AnimusArmorMaterial, AnimusHelmID, 0).setUnlocalizedName("AnimusHelm").setTextureName("wofmod:AnimusHelm");
  //public static Item AnimusChest = new AnimusArmor(AnimusArmorMaterial, AnimusChestID, 1).setUnlocalizedName("AnimusChest").setTextureName("wofmod:AnimusChest");
  //public static Item AnimusPants = new AnimusArmor(AnimusArmorMaterial, AnimusPantsID, 2).setUnlocalizedName("AnimusPants").setTextureName("wofmod:AnimusPants");
  //public static Item AnimusBoots = new AnimusArmor(AnimusArmorMaterial, AnimusBootsID, 3).setUnlocalizedName("AnimusBoots").setTextureName("wofmod:AnimusBoots");
  public static CreativeTabs woftab = new NewTab(1, "woftab");
  
  @Mod.EventHandler
  public void preinit(FMLPreInitializationEvent event)
  {
    Scavenger.mainRegistry();
    RenderingRegistry.registerEntityRenderingHandler(EntityScavenger.class, new RenderScavenger());
    ScavengerFemale.mainRegistry();
    RenderingRegistry.registerEntityRenderingHandler(EntityScavengerF.class, new RenderScavengerF());
    Dragons.mainRegistry();
    RenderingRegistry.registerEntityRenderingHandler(EntityDragons.class, new RenderDragons());
    
    //AnimusHelm.setCreativeTab(woftab);
    //AnimusChest.setCreativeTab(woftab);
    //AnimusPants.setCreativeTab(woftab);
    //AnimusBoots.setCreativeTab(woftab);
    //GameRegistry.registerItem(AnimusHelm, "AnimusHelmet");
    //GameRegistry.registerItem(AnimusChest, "AnimusChest");
    //GameRegistry.registerItem(AnimusPants, "AnimusPants");
    //GameRegistry.registerItem(AnimusBoots, "AnimusBoots");
    
    MudScale = new Item().setUnlocalizedName("MudScale").setCreativeTab(woftab);
    GameRegistry.registerItem(MudScale, "MudScale");
    SeaScale = new Item().setUnlocalizedName("SeaScale").setCreativeTab(woftab);
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SeaScale, 0, new ModelResourceLocation("wofmod:SeaScale", "inventory"));
    GameRegistry.registerItem(SeaScale, "SeaScale");
    NightScale = new Item().setUnlocalizedName("NightScale").setCreativeTab(woftab);
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(NightScale, 0, new ModelResourceLocation("wofmod:NightScale", "inventory"));
    GameRegistry.registerItem(NightScale, "NightScale");
    SandScale = new Item().setUnlocalizedName("SandScale").setCreativeTab(woftab);
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SandScale, 0, new ModelResourceLocation("wofmod:SandScale", "inventory"));
    GameRegistry.registerItem(SandScale, "SandScale");
    IceScale = new Item().setUnlocalizedName("IceScale").setCreativeTab(woftab);
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(IceScale, 0, new ModelResourceLocation("wofmod:IceScale", "inventory"));
    GameRegistry.registerItem(IceScale, "IceScale");
    RainScale = new Item().setUnlocalizedName("RainScale").setCreativeTab(woftab);
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(RainScale, 0, new ModelResourceLocation("wofmod:RainScale", "inventory"));
    GameRegistry.registerItem(RainScale, "RainScale");
    SkyScale = new Item().setUnlocalizedName("SkyScale").setCreativeTab(woftab);
   // Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SkyScale, 0, new ModelResourceLocation("wofmod:SkyScale", "inventory"));
    GameRegistry.registerItem(SkyScale, "SkyScale");
    AnimusDust = new Item().setUnlocalizedName("AnimusDust").setCreativeTab(woftab);
   // Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AnimusDust, 0, new ModelResourceLocation("wofmod:AnimusDust", "inventory"));
    GameRegistry.registerItem(AnimusDust, "AnimusDust");
    AnimusCrystal = new ShinyItem();
    AnimusCrystal.setUnlocalizedName("AnimusCrystal").setCreativeTab(woftab);
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AnimusCrystal, 0, new ModelResourceLocation("wofmod:AnimusCrystal", "inventory"));
    GameRegistry.registerItem(AnimusCrystal, "AnimusCrystal");
    //AnimusSword = new SwordSpecial(3000, AnimusSwordmat);
    //GameRegistry.registerItem(AnimusSword, "AnimusSword");
    //AnimusSword.setUnlocalizedName("AnimusSword");
    //Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AnimusSword, 0, new ModelResourceLocation("wofmod:AnimusSword", "inventory"));
    AnimusStone = new AnimusStone();
    GameRegistry.registerItem(AnimusStone, "AnimusStone");
    
    ItemStack MudScales = new ItemStack(MudScale);
    ItemStack SkyScales = new ItemStack(SkyScale);
    ItemStack SeaScales = new ItemStack(SeaScale);
    ItemStack NightScales = new ItemStack(NightScale);
    ItemStack RainScales = new ItemStack(RainScale);
    ItemStack SandScales = new ItemStack(SandScale);
    ItemStack IceScales = new ItemStack(IceScale);
    
    getAnimusDust = new Achievement("achievement.getAnimusDust", "getAnimusDust", 0, 0, AnimusDust, null);
    getAnimusDust.registerStat();
    getAnimusSword = new Achievement("achievement.getAnimusSword", "getAnimusSword", -2, 0, AnimusSword, getAnimusDust);
    getAnimusSword.registerStat();
    getAnimusSword.setSpecial();
    //getAnimusHelm = new Achievement("achievement.getAnimusHelm", "getAnimusHelm", 2, 0, AnimusHelm, getAnimusDust);
    //getAnimusHelm.registerStat();
    //getAnimusHelm.setSpecial();
    //getAnimusChest = new Achievement("achievement.getAnimusChest", "getAnimusChest", 2, 1, AnimusChest, getAnimusDust);
   // getAnimusChest.registerStat();
    //getAnimusChest.setSpecial();
   // getAnimusPants = new Achievement("achievement.getAnimusPants", "getAnimusPants", 2, 2, AnimusPants, getAnimusDust);
    //getAnimusPants.registerStat();
    //getAnimusPants.setSpecial();
   // getAnimusBoots = new Achievement("achievement.getAnimusBoots", "getAnimusBoots", 2, 3, AnimusBoots, getAnimusDust);
    //getAnimusBoots.registerStat();
   // getAnimusBoots.setSpecial();
   // getAnimusStone = new Achievement("achievement.getAnimusStone", "getAnimusStone", 0, -2, AnimusStone, getAnimusDust);
   // getAnimusStone.registerStat();
    //getAnimusStone.setSpecial();
    //AchievementPage.registerAchievementPage(new AchievementPage("Wings Of Fire", new Achievement[] { getAnimusDust, getAnimusSword, getAnimusHelm, getAnimusChest, getAnimusPants, getAnimusBoots, getAnimusStone }));
    
    GameRegistry.addSmelting(AnimusDust, new ItemStack(AnimusCrystal), 0.1F);
    GameRegistry.addShapelessRecipe(new ItemStack(AnimusDust, 1), new Object[] { MudScales, SkyScales, SeaScales, NightScales, RainScales, SandScales, IceScales });
    
    GameRegistry.addRecipe(new ItemStack(AnimusSword), new Object[] { " c ", " c ", " s ", 
      Character.valueOf('c'), AnimusCrystal, Character.valueOf('s'), Item.itemRegistry.getObject("stick") });
    //GameRegistry.addRecipe(new ItemStack(AnimusHelm), new Object[] { "ccc", "c c", "   ", 
      //Character.valueOf('c'), AnimusCrystal });
    //GameRegistry.addRecipe(new ItemStack(AnimusChest), new Object[] { "c c", "ccc", "ccc", 
      //Character.valueOf('c'), AnimusCrystal });
    //GameRegistry.addRecipe(new ItemStack(AnimusPants), new Object[] { "ccc", "c c", "c c", 
      //Character.valueOf('c'), AnimusCrystal });
    //GameRegistry.addRecipe(new ItemStack(AnimusBoots), new Object[] { "   ", "c c", "c c", 
      //Character.valueOf('c'), AnimusCrystal });
    
    FMLCommonHandler.instance().bus().register(new Events());
  }
  
  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(MudScale, 0, new ModelResourceLocation("wofmod:MudScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SeaScale, 0, new ModelResourceLocation("wofmod:SeaScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SandScale, 0, new ModelResourceLocation("wofmod:SandScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(NightScale, 0, new ModelResourceLocation("wofmod:NightScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(IceScale, 0, new ModelResourceLocation("wofmod:IceScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(RainScale, 0, new ModelResourceLocation("wofmod:RainScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SkyScale, 0, new ModelResourceLocation("wofmod:SkyScale", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AnimusDust, 0, new ModelResourceLocation("wofmod:AnimusDust", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AnimusCrystal, 0, new ModelResourceLocation("wofmod:AnimusCrystal", "inventory"));
	  Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(AnimusStone, 0, new ModelResourceLocation("wofmod:AnimusStone", "inventory"));
	  }
  
  @Mod.EventHandler
  public void serverLoad(FMLServerStartingEvent event) {}
}
