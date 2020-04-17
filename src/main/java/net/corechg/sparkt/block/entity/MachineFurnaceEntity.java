package net.corechg.sparkt.block.entity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Tickable;

import java.util.ArrayList;

import net.corechg.transit.network.packet.IStaticPacket;
import net.corechg.transit.network.system.INode;
import net.corechg.transit.network.system.ISystem;
import net.corechg.transit.network.system.swap.IAcceptorNode;

public class MachineFurnaceEntity extends BlockEntity implements IAcceptorNode, Tickable {

    private static final String[] GROUPS = { "ENERGY" };
    private int energyCap = 20000;
    private int energyStored = 0;
    private ArrayList<INode> connected = new ArrayList<INode>(0);

    public MachineFurnaceEntity(BlockEntityType<?> type) {
        super(type);
    }

    @Override
    public String[] groupsProvided() {
        return GROUPS;
    }

    @Override
    public ISystem getSystem() {
        return null;
    }

    @Override
    public Object getData(String groupID) {
        if (groupID == "ENERGY") {
            return energyStored;
        }
        return null;
    }

    @Override
    public void setData(Object dat, String groupID) {
        if (groupID == "ENERGY") {
            int tmp = (int) dat;
            
            energyStored = tmp > energyCap ? energyCap : tmp;
        }

    }

    @Override
    public INode[] getConnections() {
        return (INode[]) connected.toArray();
    }

    @Override
    public void tick() {
        
    }

    @Override
    public boolean linkProvider(INode requester, String group) {
        if (group == "ENERGY") {
            connected.add(requester);
        }
        return false;
    }

    @Override
    public boolean unlinkProvider(INode toUnlink) {
        for(int i = 0; i < connected.size(); i++) {
            if(toUnlink.equals(connected.get(i))) {
                connected.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public INode[] getProviders() {
        return getConnections();
    }

    @Override
    public <T> boolean accept(IStaticPacket<T> packet, String group) {
        if (group == "ENERGY") {
            int add = (int) packet.getType().toBase(packet, group);
            if(add + energyStored > energyCap) {
                return false;
            }
            else {
                energyStored += add;
                return true;
            }
        }
        return false;
    }

}