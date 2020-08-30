package net.otlg.scrap;

import net.otlg.scrap.proxy.ProxyCompiler;
import net.otlg.scrap.script.ScrapManager;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.event.server.*;
import org.bukkit.event.vehicle.*;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.*;
import org.spigotmc.event.entity.EntityDismountEvent;
import org.spigotmc.event.entity.EntityMountEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public class ScrapEventListener implements Listener {

    private final Scrap scrap;
    private final ScrapManager manager;

    public ScrapEventListener(Scrap scrap, ScrapManager manager) {
        this.scrap = scrap;
        this.manager = manager;
    }

    private void handle(Event event) {
        try {
            manager.handleEvent(event.getClass().getSimpleName(), event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // @formatter:off

    @EventHandler    public void onEvent(AreaEffectCloudApplyEvent event) { handle(event); }
    @EventHandler    public void onEvent(AsyncPlayerChatEvent event) { handle(event); }
    @EventHandler    public void onEvent(AsyncPlayerPreLoginEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockBreakEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockBurnEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockCanBuildEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockDamageEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockDispenseEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockExpEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockExplodeEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockFadeEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockFormEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockFromToEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockIgniteEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockPhysicsEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockPistonExtendEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockPistonRetractEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockPlaceEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockRedstoneEvent event) { handle(event); }
    @EventHandler    public void onEvent(BlockSpreadEvent event) { handle(event); }
    @EventHandler    public void onEvent(BrewEvent event) { handle(event); }
    @EventHandler    public void onEvent(BrewingStandFuelEvent event) { handle(event); }
    @EventHandler    public void onEvent(BroadcastMessageEvent event) { handle(event); }
    @EventHandler    public void onEvent(CauldronLevelChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(ChunkLoadEvent event) { handle(event); }
    @EventHandler    public void onEvent(ChunkPopulateEvent event) { handle(event); }
    @EventHandler    public void onEvent(ChunkUnloadEvent event) { handle(event); }
    @EventHandler    public void onEvent(CraftItemEvent event) { handle(event); }
    @EventHandler    public void onEvent(CreatureSpawnEvent event) { handle(event); }
    @EventHandler    public void onEvent(CreeperPowerEvent event) { handle(event); }
    @EventHandler    public void onEvent(EnchantItemEvent event) { handle(event); }
    @EventHandler    public void onEvent(EnderDragonChangePhaseEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityAirChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityBlockFormEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityBreakDoorEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityBreedEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityChangeBlockEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityCombustByBlockEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityCombustByEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityCombustEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityCreatePortalEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityDamageByBlockEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityDamageByEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityDamageEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityDeathEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityDismountEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityExplodeEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityInteractEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityMountEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityPickupItemEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityPortalEnterEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityPortalEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityPortalExitEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityRegainHealthEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityResurrectEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityShootBowEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntitySpawnEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityTameEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityTargetEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityTargetLivingEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityTeleportEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityToggleGlideEvent event) { handle(event); }
    @EventHandler    public void onEvent(EntityUnleashEvent event) { handle(event); }
    @EventHandler    public void onEvent(ExpBottleEvent event) { handle(event); }
    @EventHandler    public void onEvent(ExplosionPrimeEvent event) { handle(event); }
    @EventHandler    public void onEvent(FireworkExplodeEvent event) { handle(event); }
    @EventHandler    public void onEvent(FoodLevelChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(FurnaceBurnEvent event) { handle(event); }
    @EventHandler    public void onEvent(FurnaceExtractEvent event) { handle(event); }
    @EventHandler    public void onEvent(FurnaceSmeltEvent event) { handle(event); }
    @EventHandler    public void onEvent(HangingBreakByEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(HangingBreakEvent event) { handle(event); }
    @EventHandler    public void onEvent(HangingPlaceEvent event) { handle(event); }
    @EventHandler    public void onEvent(HorseJumpEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryClickEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryCloseEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryCreativeEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryDragEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryInteractEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryMoveItemEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryOpenEvent event) { handle(event); }
    @EventHandler    public void onEvent(InventoryPickupItemEvent event) { handle(event); }
    @EventHandler    public void onEvent(ItemDespawnEvent event) { handle(event); }
    @EventHandler    public void onEvent(ItemMergeEvent event) { handle(event); }
    @EventHandler    public void onEvent(ItemSpawnEvent event) { handle(event); }
    @EventHandler    public void onEvent(LeavesDecayEvent event) { handle(event); }
    @EventHandler    public void onEvent(LightningStrikeEvent event) { handle(event); }
    @EventHandler    public void onEvent(LingeringPotionSplashEvent event) { handle(event); }
    @EventHandler    public void onEvent(MapInitializeEvent event) { handle(event); }
    @EventHandler    public void onEvent(NotePlayEvent event) { handle(event); }
    @EventHandler    public void onEvent(PigZapEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerAdvancementDoneEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerAnimationEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerArmorStandManipulateEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerBedEnterEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerBedLeaveEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerBucketEmptyEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerBucketFillEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerChangedMainHandEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerChangedWorldEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerChatTabCompleteEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerCommandPreprocessEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerDeathEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerDropItemEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerEditBookEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerEggThrowEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerExpChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerFishEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerGameModeChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerInteractAtEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerInteractEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerInteractEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerItemBreakEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerItemConsumeEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerItemDamageEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerItemHeldEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerItemMendEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerJoinEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerKickEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerLeashEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerLevelChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerLocaleChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerLoginEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerMoveEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerPickupArrowEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerPortalEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerQuitEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerResourcePackStatusEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerRespawnEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerShearEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerSpawnLocationEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerStatisticIncrementEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerSwapHandItemsEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerTeleportEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerToggleFlightEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerToggleSneakEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerToggleSprintEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerUnleashEntityEvent event) { handle(event); }
    @EventHandler    public void onEvent(PlayerVelocityEvent event) { handle(event); }
    @EventHandler    public void onEvent(PortalCreateEvent event) { handle(event); }
    @EventHandler    public void onEvent(PotionSplashEvent event) { handle(event); }
    @EventHandler    public void onEvent(PrepareAnvilEvent event) { handle(event); }
    @EventHandler    public void onEvent(PrepareItemCraftEvent event) { handle(event); }
    @EventHandler    public void onEvent(PrepareItemEnchantEvent event) { handle(event); }
    @EventHandler    public void onEvent(ProjectileHitEvent event) { handle(event); }
    @EventHandler    public void onEvent(ProjectileLaunchEvent event) { handle(event); }
    @EventHandler    public void onEvent(RemoteServerCommandEvent event) { handle(event); }
    @EventHandler    public void onEvent(ServerCommandEvent event) { handle(event); }
    @EventHandler    public void onEvent(ServerListPingEvent event) { handle(event); }
    @EventHandler    public void onEvent(SheepDyeWoolEvent event) { handle(event); }
    @EventHandler    public void onEvent(SheepRegrowWoolEvent event) { handle(event); }
    @EventHandler    public void onEvent(SignChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(SlimeSplitEvent event) { handle(event); }
    @EventHandler    public void onEvent(SpawnChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(SpawnerSpawnEvent event) { handle(event); }
    @EventHandler    public void onEvent(StructureGrowEvent event) { handle(event); }
    @EventHandler    public void onEvent(TabCompleteEvent event) { handle(event); }
    @EventHandler    public void onEvent(ThunderChangeEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleBlockCollisionEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleCreateEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleDamageEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleDestroyEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleEnterEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleEntityCollisionEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleExitEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleMoveEvent event) { handle(event); }
    @EventHandler    public void onEvent(VehicleUpdateEvent event) { handle(event); }
    @EventHandler    public void onEvent(VillagerAcquireTradeEvent event) { handle(event); }
    @EventHandler    public void onEvent(VillagerReplenishTradeEvent event) { handle(event); }
    @EventHandler    public void onEvent(WeatherChangeEvent event) { handle(event); }
}
