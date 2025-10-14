package net.sima.bfme.profession;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.sima.bfme.BFME;
import net.sima.bfme.datagen.ModBlockTagProvider;
import net.sima.bfme.player.PlayerData;
import net.sima.bfme.player.PlayerDataProvider;
import net.sima.bfme.util.ModTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@EventBusSubscriber(modid = BFME.MOD_ID)
public class ProfessionEventHandler {
    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        PlayerData data = player.getCapability(PlayerDataProvider.PLAYER_DATA_CAPABILITY);
        if (data == null) return;

        Professions profession = data.getProfession();
        if (profession == null) return;

        int level = data.getProfessionLevel();

        switch (profession) {
            case MINER -> {
                if (event.getState().is(ModTags.Blocks.STONES)) {
                    data.addProfessionExperience(1);
                }
                if (event.getState().is(ModTags.Blocks.ORES)) {
                    data.addProfessionExperience(2);
                    processExtraDrops(event, player, profession, level);
                }
            }
            case LUMBERJACK -> {
                if (event.getState().is(BlockTags.LOGS)) {
                    data.addProfessionExperience(1);
                    processExtraDrops(event, player, profession, level);
                }
            }
            case FARMER -> {
                if (event.getState().is(BlockTags.MAINTAINS_FARMLAND)) {
                    data.addProfessionExperience(1);
                    processExtraDrops(event, player, profession, level);
                }
            }
        }
    }


    private static void processExtraDrops(BlockEvent.BreakEvent event, ServerPlayer player, Professions profession, int level) {
        Random random = new Random();

        double chanceOne = 0.0, chanceTwo = 0.0, chanceThree = 0.0;

        // Настройка шансов в зависимости от профессии и уровня
        if (profession == Professions.MINER) {
            if (level >= 2) chanceOne = 0.25;
            if (level >= 4) {
                chanceOne = 0.5;
                chanceTwo = 0.25;
            }
            if (level >= 5) {
                chanceOne = 0.75;
                chanceTwo = 0.5;
                chanceThree = 0.25;
            }
        } else if (profession == Professions.FARMER) {
            if (level >= 2) chanceOne = 0.15;
            if (level >= 4) {
                chanceOne = 0.3;
                chanceTwo = 0.15;
            }
            if (level >= 5) {
                chanceOne = 0.5;
                chanceTwo = 0.3;
                chanceThree = 0.15;
            }
        } else if (profession == Professions.LUMBERJACK) {
            if (level >= 2) chanceOne = 0.25;
            if (level >= 4) {
                chanceOne = 0.5;
                chanceTwo = 0.25;
            }
            if (level >= 5) {
                chanceOne = 0.75;
                chanceTwo = 0.5;
                chanceThree = 0.25;
            }
        }

        List<ItemStack> extraDrops = new ArrayList<>();

        // Генерация дополнительных дропов
        if (random.nextDouble() < chanceThree) {
            List<ItemStack> baseDrops = Block.getDrops(event.getState(), (ServerLevel) player.level(), event.getPos(), null);
            extraDrops.addAll(baseDrops);
            extraDrops.addAll(baseDrops);
            extraDrops.addAll(baseDrops);
        } else if (random.nextDouble() < chanceTwo) {
            List<ItemStack> baseDrops = Block.getDrops(event.getState(), (ServerLevel) player.level(), event.getPos(), null);
            extraDrops.addAll(baseDrops);
            extraDrops.addAll(baseDrops);
        } else if (random.nextDouble() < chanceOne) {
            extraDrops.addAll(Block.getDrops(event.getState(), (ServerLevel) player.level(), event.getPos(), null));
        }

        for (ItemStack drop : extraDrops) {
            Block.popResource((ServerLevel) player.level(), event.getPos(), drop);
        }
    }

}
