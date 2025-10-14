package net.sima.bfme.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;
import net.sima.bfme.profession.Professions;

public class GetProfessionCommand {

    public GetProfessionCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("profession")
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
            Professions profession = playerData.getProfession();
            if (profession != null) {
                source.sendSuccess(() -> Component.literal("Current profession: " + profession.getName()), false);
            } else {
                source.sendFailure(Component.literal("You do not have a profession."));
            }
        } else {
            source.sendFailure(Component.literal("Could not retrieve player data."));
        }

        return 1;
    }
}
