package de.nimble.pets;

import net.minecraft.server.v1_16_R3.PathfinderGoal;

public class PathfinderGoalPet extends PathfinderGoal {
    /*
    private final EntityInsentient a; // our pet
    private EntityLiving b; // the owner / player
    private final double f; // pets speed
    private final float g; // distance between owner and pet

    private double c; // x
    private double d; // y
    private double e; // z
     */

    public PathfinderGoalPet() {

    }

    @Override
    public boolean a() { // runs every single tick
        return false;
    }

}
