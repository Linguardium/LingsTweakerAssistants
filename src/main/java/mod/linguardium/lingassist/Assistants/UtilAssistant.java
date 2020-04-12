package mod.linguardium.lingassist.Assistants;

import io.github.cottonmc.libcd.api.CDSyntaxError;
import net.minecraft.client.util.math.Vector3f;

import java.util.List;

public class UtilAssistant {
    public static final UtilAssistant INSTANCE = new UtilAssistant();
    private UtilAssistant() {}

    public Vector3f colorFromInt(Integer intColor) throws CDSyntaxError {
        if (intColor > 0xFFFFFF) {
            throw(new CDSyntaxError("Color value out of range"));
        }
        int r = (intColor>>16)&0xFF;
        int g = (intColor>>8)&0xFF;
        int b = intColor&0xFF;
        return new Vector3f(r/255.0F,g/255.0F,b/255.0F);
    }
    public Vector3f colorFromInt(List<Integer> colors) throws CDSyntaxError {
        if (colors.size() != 3) {
            throw(new CDSyntaxError("Expected array of size 3, provided array of size "+String.valueOf(colors.size())));
        }
        int r = Math.max(Math.min(colors.get(0),255),0);
        int g = Math.max(Math.min(colors.get(1),255),0);
        int b = Math.max(Math.min(colors.get(2),255),0);
        if (r!=colors.get(0) || g!=colors.get(1) || b!=colors.get(2)) {
            throw(new CDSyntaxError("Color value out of range"));
        }
        return new Vector3f(r/255.0F,g/255.0F,b/255.0F);
    }
    public Vector3f colorFromFloat(float[] colors) throws CDSyntaxError {
        float r = Math.max(Math.min(colors[0],1),0);
        float g = Math.max(Math.min(colors[1],1),0);
        float b = Math.max(Math.min(colors[2],1),0);
        if (r!=colors[0] || g!=colors[1] || b!=colors[2]) {
            throw(new CDSyntaxError("Color value out of range"));
        }
        return new Vector3f(r,g,b);
    }
}
