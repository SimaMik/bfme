package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.faction.Faction;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

public class GetReputationCommand {

    public GetReputationCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("reputation")
                .then(Commands.literal("get")
                        .then(Commands.argument("factionName", StringArgumentType.string())
                                .executes(this::execute))));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        String factionName = StringArgumentType.getString(context, "factionName");

        Faction faction = null;
        for (Faction f : Faction.values()) {
            if (f.getFactionName().equalsIgnoreCase(factionName)) {
                faction = f;
                break;
            }
        }

        if (faction == null) {
            context.getSource().sendFailure(Component.literal("Faction " + factionName + " does not exist"));
            return 0;
        }

        // Используем player.getCapability через систему NeoForge
        PlayerData playerData = PlayerDataProvider.PLAYER_DATA_CAPABILITY.getCapability(player, null);

        if (playerData != null) {
            int reputation = playerData.getReputation(faction);
            context.getSource().sendSuccess(() -> Component.literal("Reputation for " + factionName + ": " + reputation), false);
        } else {
            context.getSource().sendFailure(Component.literal("Could not retrieve player data"));
        }

        return 1;
    }
}
