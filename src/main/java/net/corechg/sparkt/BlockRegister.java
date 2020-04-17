package net.corechg.sparkt;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.corechg.sparkt.block.*;

public class BlockRegister {

    public static final Block MACHINE_BLOCK = new MachineBlock();
    public static final Block MACHINE_FURNACE = new MachineFurnace();
    public static final Block DRIVER_MECHANICAL = new DriverMechanical();
    public static final Block MACHINE_GRINDER = new MachineGrinder();
    //public static final Block

    public static void register(String modid) {
        Registry.register(Registry.BLOCK, new Identifier(modid, "machine_block"), MACHINE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(modid, "machine_block"), new BlockItem(MACHINE_BLOCK, new Item.Settings()));

        Registry.register(Registry.BLOCK, new Identifier(modid, "machine_furnace"), MACHINE_FURNACE);
        Registry.register(Registry.ITEM, new Identifier(modid, "machine_furnace"), new BlockItem(MACHINE_FURNACE, new Item.Settings()));

        Registry.register(Registry.BLOCK, new Identifier(modid, "driver_mechanical"), DRIVER_MECHANICAL);
        Registry.register(Registry.ITEM, new Identifier(modid, "driver_mechanical"), new BlockItem(DRIVER_MECHANICAL, new Item.Settings()));

        Registry.register(Registry.BLOCK, new Identifier(modid, "machine_grinder"), MACHINE_GRINDER);
        Registry.register(Registry.ITEM, new Identifier(modid, "machine_grinder"), new BlockItem(MACHINE_GRINDER, new Item.Settings()));
    }
}