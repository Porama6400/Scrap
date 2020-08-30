package net.otlg.scrap.proxy.rule;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DefaultProxyCompilerRule extends ProxyCompilerRule {

    public DefaultProxyCompilerRule() {
        argumentProxyRules.put(String.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(void.class.getName(), ProxyPolicy.ALLOW);

        argumentProxyRules.put(boolean.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(Boolean.class.getName(), ProxyPolicy.ALLOW);

        argumentProxyRules.put(int.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(Integer.class.getName(), ProxyPolicy.ALLOW);

        argumentProxyRules.put(long.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(Long.class.getName(), ProxyPolicy.ALLOW);

        argumentProxyRules.put(double.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(Double.class.getName(), ProxyPolicy.ALLOW);

        argumentProxyRules.put(float.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(Float.class.getName(), ProxyPolicy.ALLOW);

        argumentProxyRules.put(ItemStack.class.getName(), ProxyPolicy.ALLOW);
        argumentProxyRules.put(ItemMeta.class.getName(), ProxyPolicy.ALLOW);

        // ConfigurationSerializable
        functionProxyRules.put("serialize:java.util.Map", ProxyPolicy.ALLOW);

        // Event
        functionProxyRules.put("getEventName:java.lang.String", ProxyPolicy.ALLOW);
        functionProxyRules.put("setCancelled:void", ProxyPolicy.ALLOW);
        functionProxyRules.put("isCancelled:boolean", ProxyPolicy.ALLOW);

        // BlockEvent
        functionProxyRules.put("isDropItems:boolean", ProxyPolicy.ALLOW);
        functionProxyRules.put("canBuild:boolean", ProxyPolicy.ALLOW);
        functionProxyRules.put("setBuild:void", ProxyPolicy.ALLOW);
        functionProxyRules.put("getExpToDrop:int", ProxyPolicy.ALLOW);
        functionProxyRules.put("setExpToDrop:void", ProxyPolicy.ALLOW);
        functionProxyRules.put("getBlock:org.bukkit.block.Block", ProxyPolicy.PROXY);

        // Block
        functionProxyRules.put("getX:int", ProxyPolicy.ALLOW);
        functionProxyRules.put("getY:int", ProxyPolicy.ALLOW);
        functionProxyRules.put("getZ:int", ProxyPolicy.ALLOW);
        functionProxyRules.put("getType:org.bukkit.Material", ProxyPolicy.ALLOW);
        functionProxyRules.put("getLocation:org.bukkit.Location", ProxyPolicy.PROXY);

        // Location
        functionProxyRules.put("getX:double", ProxyPolicy.ALLOW);
        functionProxyRules.put("getY:double", ProxyPolicy.ALLOW);
        functionProxyRules.put("getZ:double", ProxyPolicy.ALLOW);

        // Player
        {
            functionProxyRules.put("sendMessage:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getUniqueId:java.util.UUID", ProxyPolicy.ALLOW);

            functionProxyRules.put("getEntityId:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setSwimming:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getHealth:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("addPotionEffects:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("isOnGround:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setLevel:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLastPlayed:long", ProxyPolicy.ALLOW);
            functionProxyRules.put("isHealthScaled:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("spawnParticle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("playEffect:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("addPassenger:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPlayerWeather:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setNoDamageTicks:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("hidePlayer:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("playSound:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("applyMending:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("openEnchanting:org.bukkit.inventory.InventoryView", ProxyPolicy.PROXY);
            functionProxyRules.put("getMaxHealth:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("getCustomName:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("setHealthScale:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("teleport:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("openInventory:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getEyeHeight:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("showTitle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("removeScoreboardTag:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getItemOnCursor:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
            functionProxyRules.put("swingOffHand:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("disconnect:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("giveExp:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getActiveItem:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
            functionProxyRules.put("setResourcePack:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getSaturation:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("getExpToLevel:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("getMomentum:org.bukkit.util.Vector", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPlayerListFooter:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("damage:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setShieldBlockingDelay:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getExhaustion:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendRawMessage:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isCustomNameVisible:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("canSee:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("eject:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendBlockChange:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("showPlayer:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("resetMaxHealth:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getNoDamageTicks:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPortalCooldown:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("getClientViewDistance:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setWhitelisted:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("stopSound:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("openSign:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setMaximumAir:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getFirstPlayed:long", ProxyPolicy.ALLOW);
            functionProxyRules.put("updateCommands:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setHealth:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("leaveVehicle:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("isFlying:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setSubtitle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasPlayedBefore:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("openBook:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setInvulnerable:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setTotalExperience:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendActionBar:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("openWorkbench:org.bukkit.inventory.InventoryView", ProxyPolicy.PROXY);
            functionProxyRules.put("isInsideVehicle:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasAI:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getShieldBlockingDelay:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPassenger:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasResourcePack:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("isGlowing:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getEffectivePermissions:java.util.Set", ProxyPolicy.ALLOW);
            functionProxyRules.put("getGameMode:org.bukkit.GameMode", ProxyPolicy.ALLOW);
            functionProxyRules.put("isOnline:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setGliding:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getType:org.bukkit.entity.EntityType", ProxyPolicy.ALLOW);
            functionProxyRules.put("launchProjectile:org.bukkit.entity.Projectile", ProxyPolicy.PROXY);
            functionProxyRules.put("setSaturation:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("playNote:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendExperienceChange:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("removePassenger:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("isJumping:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getVirtualHost:java.net.InetSocketAddress", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPlayerListHeader:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPotionEffect:org.bukkit.potion.PotionEffect", ProxyPolicy.ALLOW);
            functionProxyRules.put("getScoreboard:org.bukkit.scoreboard.Scoreboard", ProxyPolicy.ALLOW);
            functionProxyRules.put("isSprinting:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getCompassTarget:org.bukkit.Location", ProxyPolicy.ALLOW);
            functionProxyRules.put("setLeashHolder:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getName:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("removePotionEffect:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("teleportAsync:java.util.concurrent.CompletableFuture", ProxyPolicy.ALLOW);
            functionProxyRules.put("getMaximumNoDamageTicks:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("updateScaledHealth:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setViewDistance:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getFoodLevel:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("chat:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setDisplayName:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setVelocity:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setStatistic:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setTitleTimes:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setExp:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPlayerListHeaderFooter:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isSneaking:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPlayerTimeOffset:long", ProxyPolicy.ALLOW);
            functionProxyRules.put("isBanned:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getScaledHealth:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasGravity:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setBedSpawnLocation:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getAllowFlight:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("injectScaledMaxHealth:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getArrowsStuck:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setGlowing:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("resetPlayerWeather:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("performCommand:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setGameMode:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("addPotionEffect:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setArrowsStuck:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setFireTicks:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isHandRaised:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setCooldown:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("discoverRecipes:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setAffectsSpawning:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isEmpty:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setShoulderEntityRight:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getEyeLocation:org.bukkit.Location", ProxyPolicy.PROXY);
            functionProxyRules.put("closeInventory:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendSignChange:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getTotalExperience:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("getProtocolVersion:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("incrementStatistic:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getScoreboardTags:java.util.Set", ProxyPolicy.ALLOW);
            functionProxyRules.put("decrementStatistic:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendHealthUpdate:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPlayerTime:long", ProxyPolicy.ALLOW);
            functionProxyRules.put("setFlying:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setAI:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isValid:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("isGliding:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getExp:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("getVelocity:org.bukkit.util.Vector", ProxyPolicy.ALLOW);
            functionProxyRules.put("setWalkSpeed:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isCollidable:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setFirstPlayed:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLastDamageCause:org.bukkit.event.entity.EntityDamageEvent", ProxyPolicy.PROXY);
            functionProxyRules.put("setShoulderEntityLeft:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isBlocking:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getFacing:org.bukkit.block.BlockFace", ProxyPolicy.ALLOW);
            functionProxyRules.put("sendTitle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setAllowFlight:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasPermission:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPlayerWeather:org.bukkit.WeatherType", ProxyPolicy.ALLOW);
            functionProxyRules.put("setAbsorptionAmount:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasCooldown:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setGravity:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPlayerListFooter:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("isInvulnerable:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getOpenInventory:org.bukkit.inventory.InventoryView", ProxyPolicy.PROXY);
            functionProxyRules.put("getResourcePackHash:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("isPermissionSet:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getMaximumAir:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("isDead:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasLineOfSight:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("removeAttachment:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setHealthScaled:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getAddress:java.net.InetSocketAddress", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLevel:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("sleep:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("wakeup:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setItemOnCursor:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("updateTitle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("resetPlayerTime:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setMaximumNoDamageTicks:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("updateInventory:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getFlySpeed:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("setItemInHand:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPassenger:org.bukkit.entity.Entity", ProxyPolicy.PROXY);
            functionProxyRules.put("setPlayerListName:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("openMerchant:org.bukkit.inventory.InventoryView", ProxyPolicy.PROXY);
            functionProxyRules.put("getHeight:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("isPlayerTimeRelative:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("giveExpLevels:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setRotation:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getHealthScale:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("getViewDistance:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setLastDamageCause:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLastDamage:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("isSwimming:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("hasPotionEffect:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getAbsorptionAmount:double", ProxyPolicy.ALLOW);
            functionProxyRules.put("setRealHealth:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setMaxHealth:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setTexturePack:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setExhaustion:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setOp:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getAdvancementProgress:org.bukkit.advancement.AdvancementProgress", ProxyPolicy.ALLOW);
            functionProxyRules.put("isConversing:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPortalCooldown:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setSilent:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("kickPlayer:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setSneaking:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getActivePotionEffects:java.util.Collection", ProxyPolicy.ALLOW);
            functionProxyRules.put("setScoreboard:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getCooldownPeriod:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLeashHolder:org.bukkit.entity.Entity", ProxyPolicy.PROXY);
            functionProxyRules.put("saveData:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setTicksLived:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isRiptiding:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("undiscoverRecipes:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("getWalkSpeed:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("resetCooldown:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("readExtraData:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setCanPickupItems:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isWhitelisted:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setCustomNameVisible:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isOp:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setRemainingAir:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getCooldown:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("hideTitle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("addScoreboardTag:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("recalculatePermissions:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getPlayerListName:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("getFallDistance:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("getVehicle:org.bukkit.entity.Entity", ProxyPolicy.PROXY);
            functionProxyRules.put("getSpectatorTarget:org.bukkit.entity.Entity", ProxyPolicy.PROXY);
            functionProxyRules.put("setFallDistance:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getWorld:org.bukkit.World", ProxyPolicy.PROXY);
            functionProxyRules.put("setSprinting:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setFlySpeed:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLocale:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("setSleepingIgnored:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setResourcePackStatus:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setCustomName:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getTicksLived:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setCollidable:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getBedLocation:org.bukkit.Location", ProxyPolicy.PROXY);
            functionProxyRules.put("getKiller:org.bukkit.entity.Player", ProxyPolicy.PROXY);
            functionProxyRules.put("getEnderChest:org.bukkit.inventory.Inventory", ProxyPolicy.PROXY);
            functionProxyRules.put("getMaxFireTicks:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("getDisplayName:java.lang.String", ProxyPolicy.ALLOW);
            functionProxyRules.put("setMomentum:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("resetTitle:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setPlayerTime:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setFoodLevel:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("isSleeping:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setCompassTarget:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getRemainingAir:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("isSleepingIgnored:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getCanPickupItems:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getInventory:org.bukkit.inventory.Inventory", ProxyPolicy.PROXY);
            functionProxyRules.put("isLeashed:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("getResourcePackStatus:org.bukkit.event.player.PlayerResourcePackStatusEvent$Status", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLastSeen:long", ProxyPolicy.ALLOW);
            functionProxyRules.put("setKiller:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getMemory:java.lang.Object", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLastLogin:long", ProxyPolicy.ALLOW);
            functionProxyRules.put("setSpectatorTarget:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getAffectsSpawning:boolean", ProxyPolicy.ALLOW);
        }

        // Inventory
        {
            functionProxyRules.put("getHolder:org.bukkit.entity.Entity", ProxyPolicy.PROXY);
            functionProxyRules.put("getHelmet:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
            functionProxyRules.put("setItem:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getArmorContents:org.bukkit.inventory.ItemStack[]", ProxyPolicy.ALLOW);
            functionProxyRules.put("getLeggings:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
            functionProxyRules.put("setHelmetDropChance:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("contains:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setHeldItemSlot:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getChestplate:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
            functionProxyRules.put("containsAtLeast:boolean", ProxyPolicy.ALLOW);
            functionProxyRules.put("setLeggingsDropChance:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getContents:org.bukkit.inventory.ItemStack[]", ProxyPolicy.ALLOW);
            functionProxyRules.put("setHelmet:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setItemInMainHand:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("remove:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setLeggings:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getItemInHandDropChance:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("clear:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("setItemInOffHand:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getItemInOffHandDropChance:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("getStorageContents:org.bukkit.inventory.ItemStack[]", ProxyPolicy.ALLOW);
            functionProxyRules.put("getExtraContents:org.bukkit.inventory.ItemStack[]", ProxyPolicy.ALLOW);
            functionProxyRules.put("setItemInMainHandDropChance:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getHeldItemSlot:int", ProxyPolicy.ALLOW);
            functionProxyRules.put("setChestplateDropChance:void", ProxyPolicy.ALLOW);
            functionProxyRules.put("getHelmetDropChance:float", ProxyPolicy.ALLOW);
            functionProxyRules.put("getItemInHand:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
            functionProxyRules.put("getItem:org.bukkit.inventory.ItemStack", ProxyPolicy.ALLOW);
        }

    }
}