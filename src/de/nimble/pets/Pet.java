package de.nimble.pets;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

public class Pet extends EntityCow {

    public Pet(Location loc, Player player) {
        super(EntityTypes.COW, ((CraftWorld) loc.getWorld()).getHandle());
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.setBaby(true);
        this.setInvulnerable(true);
    }

    @Override
    protected void initPathfinder() {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(2, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0f));

    }
}
