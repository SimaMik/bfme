package net.sima.bfme.screen_menus.crafting_help;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipePattern;

public final class ShapedRecipePatternCodecs {
    private static final Codec<List<String>> PATTERN_CODEC;
    public static final Codec<Character> SYMBOL_CODEC;
    private static final MapCodec<ShapedRecipePattern.Data> DATA_MAP_CODEC;
    public static final MapCodec<ShapedRecipePattern> MAP_CODEC;

    public ShapedRecipePatternCodecs() {
    }

    static {
        PATTERN_CODEC = Codec.STRING.listOf().comapFlatMap((pattern) -> {
            if (pattern.isEmpty()) {
                return DataResult.error(() -> {
                    return "Invalid pattern: empty pattern not allowed";
                });
            } else {
                int length = ((String)pattern.getFirst()).length();
                Iterator<String> lines = pattern.iterator();

                while(lines.hasNext()) {
                    String line = (String)lines.next();
                    if (length != line.length()) {
                        return DataResult.error(() -> {
                            return "Invalid pattern: each row must be the same width";
                        });
                    }
                }

                return DataResult.success(pattern);
            }
        }, Function.identity());
        SYMBOL_CODEC = Codec.STRING.comapFlatMap((symbol) -> {
            if (symbol.length() != 1) {
                return DataResult.error(() -> {
                    return "Invalid key entry: '" + symbol + "' is an invalid symbol (must be 1 character only).";
                });
            } else {
                return " ".equals(symbol) ? DataResult.error(() -> {
                    return "Invalid key entry: ' ' is a reserved symbol.";
                }) : DataResult.success(symbol.charAt(0));
            }
        }, String::valueOf);
        DATA_MAP_CODEC = RecordCodecBuilder.mapCodec((builder) -> {
            return builder.group(ExtraCodecs.strictUnboundedMap(SYMBOL_CODEC, Ingredient.CODEC_NONEMPTY).fieldOf("key").forGetter(ShapedRecipePattern.Data::key), PATTERN_CODEC.fieldOf("pattern").forGetter(ShapedRecipePattern.Data::pattern)).apply(builder, ShapedRecipePattern.Data::new);
        });
        MAP_CODEC = DATA_MAP_CODEC.flatXmap(ShapedRecipePattern::unpack, (pattern) -> {
            return (DataResult)pattern.data.map(DataResult::success).orElseGet(() -> {
                return DataResult.error(() -> {
                    return "Cannot encode unpacked recipe";
                });
            });
        });
    }
}
