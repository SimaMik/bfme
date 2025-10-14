package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.faction.Faction;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;

public class GetFactionCommand {

    public GetFactionCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("faction")
                .then(Commands.literal("get")
                        .executes(context -> execute(context.getSource()))));
    }

    private int execute(CommandSourceStack source) {
        ServerPlayer player = source.getPlayer();

        if (player == null) {
            source.sendFailure(Component.literal("This command can only be used by a player."));
            return 0;
        }

        // Получаем данные игрока
        PlayerData playerData = player.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY, null);

        if (playerData != null) {
            Faction faction = playerData.getFaction();
            if (faction != null) {
                source.sendSuccess(() -> Component.literal("Current faction: " + faction.getFactionName()), false);
            } else {
                source.sendFailure(Component.literal("You do not belong to any faction."));
            }
        } else {
            source.sendFailure(Component.literal("Could not retrieve player data."));
        }

        return 1;
    }
}
