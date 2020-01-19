package com.sam.helpfulboxes.common;

import com.sam.helpfulboxes.common.lib.Dictionary;
import net.minecraftforge.fml.common.Mod;

@Mod(Dictionary.MOD_ID)
public class HelpfulBoxes {

    public static HelpfulBoxes instance;

    public HelpfulBoxes()   {
        instance = this;
    }

}
