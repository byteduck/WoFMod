package com.HaitherecreeperMC.WoFMod;

import com.HaitherecreeperMC.WoFMod.event.Events;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.util.EnumHelper;

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
  public static Item.ToolMaterial AnimusSwordmat = EnumHelper.addToolMaterial("AnimusSwordMat", 3, -1, 25.0F, 50.0F, 0);
  public static ItemArmor.ArmorMaterial AnimusArmorMaterial = EnumHelper.addArmorMaterial("AnimusArmorMaterial", 1000000, new int[] { 6, 16, 12, 6 }, 0);
  public static Item AnimusHelm = new AnimusArmor(AnimusArmorMaterial, AnimusHelmID, 0).setUnlocalizedName("AnimusHelm").setTextureName("wofmod:AnimusHelm");
  public static Item AnimusChest = new AnimusArmor(AnimusArmorMaterial, AnimusChestID, 1).setUnlocalizedName("AnimusChest").setTextureName("wofmod:AnimusChest");
  public static Item AnimusPants = new AnimusArmor(AnimusArmorMaterial, AnimusPantsID, 2).setUnlocalizedName("AnimusPants").setTextureName("wofmod:AnimusPants");
  public static Item AnimusBoots = new AnimusArmor(AnimusArmorMaterial, AnimusBootsID, 3).setUnlocalizedName("AnimusBoots").setTextureName("wofmod:AnimusBoots");
  public static CreativeTabs woftab = new Base$1("woftab");
  
  @Mod.EventHandler
  public void preinit(FMLPreInitializationEvent event)
  {
    Scavenger.mainRegistry();
    RenderingRegistry.registerEntityRenderingHandler(EntityScavenger.class, new RenderScavenger());
    ScavengerFemale.mainRegistry();
    RenderingRegistry.registerEntityRenderingHandler(EntityScavengerF.class, new RenderScavengerF());
    Dragons.mainRegistry();
    RenderingRegistry.registerEntityRenderingHandler(EntityDragons.class, new RenderDragons());
    
    AnimusHelm.setCreativeTab(woftab);
    AnimusChest.setCreativeTab(woftab);
    AnimusPants.setCreativeTab(woftab);
    AnimusBoots.setCreativeTab(woftab);
    GameRegistry.registerItem(AnimusHelm, "AnimusHelmet");
    GameRegistry.registerItem(AnimusChest, "AnimusChest");
    GameRegistry.registerItem(AnimusPants, "AnimusPants");
    GameRegistry.registerItem(AnimusBoots, "AnimusBoots");
    
    MudScale = new Item().setUnlocalizedName("MudScale").setTextureName("wofmod:MudScale").setCreativeTab(woftab);
    GameRegistry.registerItem(MudScale, "MudScale");
    SeaScale = new Item().setUnlocalizedName("SeaScale").setTextureName("wofmod:SeaScale").setCreativeTab(woftab);
    GameRegistry.registerItem(SeaScale, "SeaScale");
    NightScale = new Item().setUnlocalizedName("NightScale").setTextureName("wofmod:NightScale").setCreativeTab(woftab);
    GameRegistry.registerItem(NightScale, "NightScale");
    SandScale = new Item().setUnlocalizedName("SandScale").setTextureName("wofmod:SandScale").setCreativeTab(woftab);
    GameRegistry.registerItem(SandScale, "SandScale");
    IceScale = new Item().setUnlocalizedName("IceScale").setTextureName("wofmod:IceScale").setCreativeTab(woftab);
    GameRegistry.registerItem(IceScale, "IceScale");
    RainScale = new Item().setUnlocalizedName("RainScale").setTextureName("wofmod:RainScale").setCreativeTab(woftab);
    GameRegistry.registerItem(RainScale, "RainScale");
    SkyScale = new Item().setUnlocalizedName("SkyScale").setTextureName("wofmod:SkyScale").setCreativeTab(woftab);
    GameRegistry.registerItem(SkyScale, "SkyScale");
    AnimusDust = new Item().setUnlocalizedName("AnimusDust").setTextureName("wofmod:AnimusDust").setCreativeTab(woftab);
    GameRegistry.registerItem(AnimusDust, "AnimusDust");
    AnimusCrystal = new ShinyItem();
    AnimusCrystal.setUnlocalizedName("AnimusCrystal").setTextureName("wofmod:AnimusCrystal").setCreativeTab(woftab);
    GameRegistry.registerItem(AnimusCrystal, "AnimusCrystal");
    AnimusSword = new SwordSpecial(3000, AnimusSwordmat);
    GameRegistry.registerItem(AnimusSword, "AnimusSword");
    AnimusSword.setUnlocalizedName("AnimusSword").setTextureName("wofmod:AnimusSword").setCreativeTab(woftab);
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
    getAnimusSword.registerStat().setSpecial();
    getAnimusHelm = new Achievement("achievement.getAnimusHelm", "getAnimusHelm", 2, 0, AnimusHelm, getAnimusDust);
    getAnimusHelm.registerStat().setSpecial();
    getAnimusChest = new Achievement("achievement.getAnimusChest", "getAnimusChest", 2, 1, AnimusChest, getAnimusDust);
    getAnimusChest.registerStat().setSpecial();
    getAnimusPants = new Achievement("achievement.getAnimusPants", "getAnimusPants", 2, 2, AnimusPants, getAnimusDust);
    getAnimusPants.registerStat().setSpecial();
    getAnimusBoots = new Achievement("achievement.getAnimusBoots", "getAnimusBoots", 2, 3, AnimusBoots, getAnimusDust);
    getAnimusBoots.registerStat().setSpecial();
    getAnimusStone = new Achievement("achievement.getAnimusStone", "getAnimusStone", 0, -2, AnimusStone, getAnimusDust);
    getAnimusStone.registerStat().setSpecial();
    AchievementPage.registerAchievementPage(new AchievementPage("Wings Of Fire", new Achievement[] { getAnimusDust, getAnimusSword, getAnimusHelm, getAnimusChest, getAnimusPants, getAnimusBoots, getAnimusStone }));
    
    GameRegistry.addSmelting(AnimusDust, new ItemStack(AnimusCrystal), 0.1F);
    GameRegistry.addShapelessRecipe(new ItemStack(AnimusDust, 1), new Object[] { MudScales, SkyScales, SeaScales, NightScales, RainScales, SandScales, IceScales });
    
    GameRegistry.addRecipe(new ItemStack(AnimusSword), new Object[] { " c ", " c ", " s ", 
      Character.valueOf('c'), AnimusCrystal, Character.valueOf('s'), Item.itemRegistry.getObject("stick") });
    GameRegistry.addRecipe(new ItemStack(AnimusHelm), new Object[] { "ccc", "c c", "   ", 
      Character.valueOf('c'), AnimusCrystal });
    GameRegistry.addRecipe(new ItemStack(AnimusChest), new Object[] { "c c", "ccc", "ccc", 
      Character.valueOf('c'), AnimusCrystal });
    GameRegistry.addRecipe(new ItemStack(AnimusPants), new Object[] { "ccc", "c c", "c c", 
      Character.valueOf('c'), AnimusCrystal });
    GameRegistry.addRecipe(new ItemStack(AnimusBoots), new Object[] { "   ", "c c", "c c", 
      Character.valueOf('c'), AnimusCrystal });
    
    FMLCommonHandler.instance().bus().register(new Events());
  }
  
  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {}
  
  @Mod.EventHandler
  public void serverLoad(FMLServerStartingEvent event) {}
}
