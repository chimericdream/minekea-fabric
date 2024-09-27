//    public static DefaultSettings AMETHYST = new DefaultSettings(Blocks.AMETHYST_BLOCK)
//        .material("amethyst")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:amethyst_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BASALT = new DefaultSettings(Blocks.BASALT)
//        .material("basalt")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:basalt_side"),
//                "end", Identifier.of("minecraft:basalt_top"),
//                "ingredient", Identifier.of("minecraft:basalt")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BASALT_BRICK = new DefaultSettings(BuildingBlocks.BASALT_BRICKS_BLOCK)
//        .material("basalt_brick")
//        .ingredientName("Basalt Bricks")
//        .materials(
//            Map.of(
//                "main", BasaltBricksBlock.BLOCK_ID
//            )
//        )
//        .withSlab()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BONE = new DefaultSettings(Blocks.BONE_BLOCK)
//        .material("bone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:bone_block_side"),
//                "end", Identifier.of("minecraft:bone_block_top"),
//                "ingredient", Identifier.of("minecraft:bone_block")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall()
//        .withDyedBlocks();
//
//    public static DefaultSettings CALCITE = new DefaultSettings(Blocks.CALCITE)
//        .material("calcite")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:calcite")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall()
//        .withDyedBlocks();
//
//    public static DefaultSettings CLAY = new DefaultSettings(Blocks.CLAY)
//        .material("clay")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:clay")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings COARSE_DIRT = new DefaultSettings(Blocks.COARSE_DIRT)
//        .material("coarse_dirt")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:coarse_dirt")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings COBBLED_END_STONE = new DefaultSettings(Blocks.END_STONE)
//        .material("cobbled_end_stone")
//        .enabled(() -> ConfigManager.getConfig().enableCobbledEndStone)
//        .materials(
//            Map.of(
//                "main", CobbledEndStoneBlock.BLOCK_ID
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CRACKED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK)
//        .material("cracked_basalt_brick")
//        .ingredientName("Cracked Basalt Bricks")
//        .materials(
//            Map.of(
//                "main", CrackedBasaltBricksBlock.BLOCK_ID
//            )
//        )
//        .withSlab()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CRACKED_DEEPSLATE_BRICK = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_BRICKS)
//        .material("cracked_deepslate_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cracked_deepslate_bricks")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CRACKED_DEEPSLATE_TILE = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_TILES)
//        .material("cracked_deepslate_tile")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cracked_deepslate_tiles")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CRACKED_STONE_BRICK = new DefaultSettings(Blocks.CRACKED_STONE_BRICKS)
//        .material("cracked_stone_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cracked_stone_bricks")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CRIMSON_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK)
//        .material("crimson_basalt_brick")
//        .ingredientName("Crimson Basalt Bricks")
//        .materials(
//            Map.of(
//                "main", CrimsonBasaltBricksBlock.BLOCK_ID
//            )
//        )
//        .withSlab()
//        .withWall();
//
//    public static DefaultSettings CRYING_OBSIDIAN = new DefaultSettings(Blocks.CRYING_OBSIDIAN)
//        .material("crying_obsidian")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:crying_obsidian")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CUT_RED_SANDSTONE = new DefaultSettings(Blocks.CUT_RED_SANDSTONE)
//        .material("cut_red_sandstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cut_red_sandstone")
//            )
//        )
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CUT_SANDSTONE = new DefaultSettings(Blocks.CUT_SANDSTONE)
//        .material("cut_sandstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cut_sandstone")
//            )
//        )
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings DARK_PRISMARINE = new DefaultSettings(Blocks.DARK_PRISMARINE)
//        .material("dark_prismarine")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:dark_prismarine")
//            )
//        )
//        .withWall()
//        .withDyedBlocks();
//
//    public static DefaultSettings DEEPSLATE = new DefaultSettings(Blocks.DEEPSLATE)
//        .material("deepslate")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:deepslate")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings DEEPSLATE_BRICK = new DefaultSettings(Blocks.DEEPSLATE_BRICKS)
//        .material("deepslate_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:deepslate_bricks")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings DEEPSLATE_TILE = new DefaultSettings(Blocks.DEEPSLATE_TILES)
//        .material("deepslate_tile")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:deepslate_tiles")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings DIORITE = new DefaultSettings(Blocks.DIORITE)
//        .material("diorite")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:diorite")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings DIRT = new DefaultSettings(Blocks.DIRT)
//        .material("dirt")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:dirt")
//            )
//        )
//        .withStairs()
//        .withVerticalStairs()
//        .withSlab();
//
//    public static DefaultSettings END_STONE = new DefaultSettings(Blocks.END_STONE)
//        .material("end_stone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:end_stone")
//            )
//        )
//        .texture(
//            "end",
//            ConfigManager.getConfig().enableCobbledEndStone
//                ? Identifier.of("minekea:block/building/general/end_stone")
//                : Identifier.of("minekea:block/building/general/cobbled_end_stone")
//        )
//        .texture(
//            "main",
//            ConfigManager.getConfig().enableCobbledEndStone
//                ? Identifier.of("minekea:block/building/general/end_stone")
//                : Identifier.of("minekea:block/building/general/cobbled_end_stone")
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings END_STONE_BRICK = new DefaultSettings(Blocks.END_STONE_BRICKS)
//        .material("end_stone_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:end_stone_bricks")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings GRANITE = new DefaultSettings(Blocks.GRANITE)
//        .material("granite")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:granite")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings GRAVEL = new DefaultSettings(Blocks.GRAVEL)
//        .material("gravel")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:gravel")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings MOSSY_BASALT_BRICK = new DefaultSettings(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK)
//        .material("mossy_basalt_brick")
//        .ingredientName("Mossy Basalt Bricks")
//        .materials(
//            Map.of(
//                "main", MossyBasaltBricksBlock.BLOCK_ID
//            )
//        )
//        .withSlab()
//        .withWall();
//
//    public static DefaultSettings MOSSY_COBBLESTONE = new DefaultSettings(Blocks.MOSSY_COBBLESTONE)
//        .material("mossy_cobblestone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mossy_cobblestone")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings MOSSY_STONE_BRICK = new DefaultSettings(Blocks.MOSSY_STONE_BRICKS)
//        .material("mossy_stone_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mossy_stone_bricks")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings MUD = new DefaultSettings(Blocks.MUD)
//        .material("mud")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mud")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings MUD_BRICK = new DefaultSettings(Blocks.MUD_BRICKS)
//        .material("mud_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mud_bricks")
//            )
//        )
//        .withDyedBlocks();
//
//    public static DefaultSettings NETHERRACK = new DefaultSettings(Blocks.NETHERRACK)
//        .material("netherrack")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:netherrack")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings NETHER_BRICK = new DefaultSettings(Blocks.NETHER_BRICKS)
//        .material("nether_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:nether_bricks")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings NETHER_WART = new DefaultSettings(Blocks.NETHER_WART_BLOCK)
//        .material("nether_wart")
//        .tool(Tool.HOE)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:nether_wart_block")
//            )
//        )
//        .withCover();
//
//    public static DefaultSettings OBSIDIAN = new DefaultSettings(Blocks.OBSIDIAN)
//        .material("obsidian")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:obsidian")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PACKED_MUD = new DefaultSettings(Blocks.PACKED_MUD)
//        .material("packed_mud")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:packed_mud")
//            )
//        )
//        .withStairs()
//        .withVerticalStairs()
//        .withSlab();
//
//    public static DefaultSettings POLISHED_ANDESITE = new DefaultSettings(Blocks.POLISHED_ANDESITE)
//        .material("polished_andesite")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_andesite")
//            )
//        )
//        .withWall()
//        .withStorageBookshelf();
//
//    public static DefaultSettings POLISHED_BASALT = new DefaultSettings(Blocks.POLISHED_BASALT)
//        .material("polished_basalt")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_basalt_side"),
//                "end", Identifier.of("minecraft:polished_basalt_top"),
//                "ingredient", Identifier.of("minecraft:polished_basalt")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall()
//        .withStorageBookshelf();
//
//    public static DefaultSettings POLISHED_BLACKSTONE = new DefaultSettings(Blocks.POLISHED_BLACKSTONE)
//        .material("polished_blackstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_blackstone")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings POLISHED_BLACKSTONE_BRICK = new DefaultSettings(Blocks.POLISHED_BLACKSTONE_BRICKS)
//        .material("polished_blackstone_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_blackstone_bricks")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings POLISHED_DEEPSLATE = new DefaultSettings(Blocks.POLISHED_DEEPSLATE)
//        .material("polished_deepslate")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_deepslate")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings POLISHED_DIORITE = new DefaultSettings(Blocks.POLISHED_DIORITE)
//        .material("polished_diorite")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_diorite")
//            )
//        )
//        .withWall()
//        .withStorageBookshelf();
//
//    public static DefaultSettings POLISHED_GRANITE = new DefaultSettings(Blocks.POLISHED_GRANITE)
//        .material("polished_granite")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:polished_granite")
//            )
//        )
//        .withWall()
//        .withStorageBookshelf();
//
//    public static DefaultSettings PRISMARINE = new DefaultSettings(Blocks.PRISMARINE)
//        .material("prismarine")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:prismarine")
//            )
//        )
//        .withDyedBlocks();
//
//    public static DefaultSettings PRISMARINE_BRICK = new DefaultSettings(Blocks.PRISMARINE_BRICKS)
//        .material("prismarine_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:prismarine_bricks")
//            )
//        )
//        .withWall()
//        .withDyedBlocks();
//
//    public static DefaultSettings PURPUR = new DefaultSettings(Blocks.PURPUR_BLOCK)
//        .material("purpur")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:purpur_block")
//            )
//        )
//        .withWall()
//        .withStorageBookshelf();
//
//    public static DefaultSettings PURPUR_PILLAR = new DefaultSettings(Blocks.PURPUR_PILLAR)
//        .material("purpur_pillar")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:purpur_pillar")
//            )
//        )
//        .withSlab()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings QUARTZ = new DefaultSettings(Blocks.QUARTZ_BLOCK)
//        .material("quartz")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:quartz_block_top"),
//                "ingredient", Identifier.of("minecraft:quartz_block")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings QUARTZ_BRICK = new DefaultSettings(Blocks.QUARTZ_BRICKS)
//        .material("quartz_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:quartz_bricks")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings RED_NETHER_BRICK = new DefaultSettings(Blocks.RED_NETHER_BRICKS)
//        .material("red_nether_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_nether_bricks")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings RED_SANDSTONE = new DefaultSettings(Blocks.RED_SANDSTONE)
//        .material("red_sandstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_sandstone")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings RED_SAND = new DefaultSettings(Blocks.RED_SAND)
//        .material("red_sand")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_sand")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings ROOTED_DIRT = new DefaultSettings(Blocks.ROOTED_DIRT)
//        .material("rooted_dirt")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:rooted_dirt")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings SAND = new DefaultSettings(Blocks.SAND)
//        .material("sand")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:sand")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings SANDSTONE = new DefaultSettings(Blocks.SANDSTONE)
//        .material("sandstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:sandstone")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings SMOOTH_BASALT = new DefaultSettings(Blocks.SMOOTH_BASALT)
//        .material("smooth_basalt")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:smooth_basalt")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings SMOOTH_QUARTZ = new DefaultSettings(Blocks.SMOOTH_QUARTZ)
//        .material("smooth_quartz")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:quartz_block_bottom"),
//                "ingredient", Identifier.of("minecraft:smooth_quartz")
//            )
//        )
//        .withStorageBookshelf();
//
//    public static DefaultSettings SMOOTH_RED_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_RED_SANDSTONE)
//        .material("smooth_red_sandstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_sandstone_top"),
//                "ingredient", Identifier.of("minecraft:smooth_red_sandstone")
//            )
//        )
//        .withWall();
//
//    public static DefaultSettings SMOOTH_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_SANDSTONE)
//        .material("smooth_sandstone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:sandstone_top"),
//                "ingredient", Identifier.of("minecraft:smooth_sandstone")
//            )
//        )
//        .withWall();
//
//    public static DefaultSettings SMOOTH_STONE = new DefaultSettings(Blocks.SMOOTH_STONE)
//        .material("smooth_stone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:smooth_stone")
//            )
//        )
//        .withStairs()
//        .withVerticalStairs()
//        .withWall()
//        .withDyedBlocks();
//
//    public static DefaultSettings SOUL_SAND = new DefaultSettings(Blocks.SOUL_SAND)
//        .material("soul_sand")
//        .tool(Tool.SHOVEL)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:soul_sand")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings STONE = new DefaultSettings(Blocks.STONE)
//        .material("stone")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:stone")
//            )
//        )
//        .withWall()
//        .withDyedBlocks();
//
//    public static DefaultSettings STONE_BRICK = new DefaultSettings(Blocks.STONE_BRICKS)
//        .material("stone_brick")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:stone_bricks")
//            )
//        )
//        .withDyedBlocks();
//
//    public static DefaultSettings TUFF = new DefaultSettings(Blocks.TUFF)
//        .material("tuff")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:tuff")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withWall();
//
//    public static DefaultSettings WARPED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK)
//        .material("warped_basalt_brick")
//        .ingredientName("Warped Basalt Bricks")
//        .materials(
//            Map.of(
//                "main", WarpedBasaltBricksBlock.BLOCK_ID
//            )
//        )
//        .withSlab()
//        .withWall();
//
//    public static DefaultSettings WARPED_NETHER_BRICK = new DefaultSettings(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK)
//        .material("warped_nether_brick")
//        .ingredientName("Warped Nether Bricks")
//        .materials(
//            Map.of(
//                "main", WarpedNetherBricksBlock.BLOCK_ID
//            )
//        )
//        .withSlab()
//        .withWall()
//        .withStorageBookshelf();
//
//    public static DefaultSettings WARPED_WART = new DefaultSettings(Blocks.WARPED_WART_BLOCK)
//        .material("warped_wart")
//        .tool(Tool.HOE)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:warped_wart_block")
//            )
//        );
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings COPPER_BLOCK = new DefaultSettings(Blocks.COPPER_BLOCK)
//        .material("copper_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:copper_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings DIAMOND_BLOCK = new DefaultSettings(Blocks.DIAMOND_BLOCK)
//        .material("diamond_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:diamond_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GOLD_BLOCK = new DefaultSettings(Blocks.GOLD_BLOCK)
//        .material("gold_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:gold_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings IRON_BLOCK = new DefaultSettings(Blocks.IRON_BLOCK)
//        .material("iron_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:iron_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LAPIS_BLOCK = new DefaultSettings(Blocks.LAPIS_BLOCK)
//        .material("lapis_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:lapis_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings NETHERITE_BLOCK = new DefaultSettings(Blocks.NETHERITE_BLOCK)
//        .material("netherite_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:netherite_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings REDSTONE_BLOCK = new DefaultSettings(Blocks.REDSTONE_BLOCK)
//        .material("redstone_block")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:redstone_block")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings CUT_COPPER = new DefaultSettings(Blocks.CUT_COPPER)
//        .material("cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.EXPOSED_CUT_COPPER)
//        .material("exposed_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:exposed_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WEATHERED_CUT_COPPER)
//        .material("weathered_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:weathered_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.OXIDIZED_CUT_COPPER)
//        .material("oxidized_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:oxidized_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings WAXED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_CUT_COPPER)
//        .material("waxed_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cut_copper"),
//                "ingredient", Identifier.of("minecraft:waxed_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings WAXED_EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_EXPOSED_CUT_COPPER)
//        .material("waxed_exposed_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:exposed_cut_copper"),
//                "ingredient", Identifier.of("minecraft:waxed_exposed_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings WAXED_WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_WEATHERED_CUT_COPPER)
//        .material("waxed_weathered_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:weathered_cut_copper"),
//                "ingredient", Identifier.of("minecraft:waxed_weathered_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    public static DefaultSettings WAXED_OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_OXIDIZED_CUT_COPPER)
//        .material("waxed_oxidized_cut_copper")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:oxidized_cut_copper"),
//                "ingredient", Identifier.of("minecraft:waxed_oxidized_cut_copper")
//            )
//        )
//        .withVerticalStairs();
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings WHITE_WOOL = new DefaultSettings(Blocks.WHITE_WOOL)
//        .material("white_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:white_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:white_carpet"), 2);
//
//    public static DefaultSettings ORANGE_WOOL = new DefaultSettings(Blocks.ORANGE_WOOL)
//        .material("orange_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:orange_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:orange_carpet"), 2);
//
//    public static DefaultSettings MAGENTA_WOOL = new DefaultSettings(Blocks.MAGENTA_WOOL)
//        .material("magenta_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:magenta_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:magenta_carpet"), 2);
//
//    public static DefaultSettings LIGHT_BLUE_WOOL = new DefaultSettings(Blocks.LIGHT_BLUE_WOOL)
//        .material("light_blue_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:light_blue_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:light_blue_carpet"), 2);
//
//    public static DefaultSettings YELLOW_WOOL = new DefaultSettings(Blocks.YELLOW_WOOL)
//        .material("yellow_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:yellow_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:yellow_carpet"), 2);
//
//    public static DefaultSettings LIME_WOOL = new DefaultSettings(Blocks.LIME_WOOL)
//        .material("lime_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:lime_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:lime_carpet"), 2);
//
//    public static DefaultSettings PINK_WOOL = new DefaultSettings(Blocks.PINK_WOOL)
//        .material("pink_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:pink_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:pink_carpet"), 2);
//
//    public static DefaultSettings GRAY_WOOL = new DefaultSettings(Blocks.GRAY_WOOL)
//        .material("gray_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:gray_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:gray_carpet"), 2);
//
//    public static DefaultSettings LIGHT_GRAY_WOOL = new DefaultSettings(Blocks.LIGHT_GRAY_WOOL)
//        .material("light_gray_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:light_gray_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:light_gray_carpet"), 2);
//
//    public static DefaultSettings CYAN_WOOL = new DefaultSettings(Blocks.CYAN_WOOL)
//        .material("cyan_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:cyan_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:cyan_carpet"), 2);
//
//    public static DefaultSettings PURPLE_WOOL = new DefaultSettings(Blocks.PURPLE_WOOL)
//        .material("purple_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:purple_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:purple_carpet"), 2);
//
//    public static DefaultSettings BLUE_WOOL = new DefaultSettings(Blocks.BLUE_WOOL)
//        .material("blue_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:blue_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:blue_carpet"), 2);
//
//    public static DefaultSettings BROWN_WOOL = new DefaultSettings(Blocks.BROWN_WOOL)
//        .material("brown_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:brown_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:brown_carpet"), 2);
//
//    public static DefaultSettings GREEN_WOOL = new DefaultSettings(Blocks.GREEN_WOOL)
//        .material("green_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:green_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:green_carpet"), 2);
//
//    public static DefaultSettings RED_WOOL = new DefaultSettings(Blocks.RED_WOOL)
//        .material("red_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:red_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:red_carpet"), 2);
//
//    public static DefaultSettings BLACK_WOOL = new DefaultSettings(Blocks.BLACK_WOOL)
//        .material("black_wool")
//        .wool()
//        .tool(Tool.SHEARS)
//        .materials(Map.of("main", Identifier.of("minecraft:black_wool")))
//        .withButton()
//        .withPressurePlate(Identifier.of("minecraft:black_carpet"), 2);
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings WHITE_TERRACOTTA = new DefaultSettings(Blocks.WHITE_TERRACOTTA)
//        .material("white_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:white_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings ORANGE_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_TERRACOTTA)
//        .material("orange_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:orange_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings MAGENTA_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_TERRACOTTA)
//        .material("magenta_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:magenta_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIGHT_BLUE_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_TERRACOTTA)
//        .material("light_blue_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_blue_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings YELLOW_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_TERRACOTTA)
//        .material("yellow_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:yellow_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIME_TERRACOTTA = new DefaultSettings(Blocks.LIME_TERRACOTTA)
//        .material("lime_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:lime_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PINK_TERRACOTTA = new DefaultSettings(Blocks.PINK_TERRACOTTA)
//        .material("pink_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:pink_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GRAY_TERRACOTTA = new DefaultSettings(Blocks.GRAY_TERRACOTTA)
//        .material("gray_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:gray_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIGHT_GRAY_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_TERRACOTTA)
//        .material("light_gray_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_gray_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CYAN_TERRACOTTA = new DefaultSettings(Blocks.CYAN_TERRACOTTA)
//        .material("cyan_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cyan_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PURPLE_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_TERRACOTTA)
//        .material("purple_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:purple_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BLUE_TERRACOTTA = new DefaultSettings(Blocks.BLUE_TERRACOTTA)
//        .material("blue_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:blue_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BROWN_TERRACOTTA = new DefaultSettings(Blocks.BROWN_TERRACOTTA)
//        .material("brown_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:brown_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GREEN_TERRACOTTA = new DefaultSettings(Blocks.GREEN_TERRACOTTA)
//        .material("green_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:green_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings RED_TERRACOTTA = new DefaultSettings(Blocks.RED_TERRACOTTA)
//        .material("red_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BLACK_TERRACOTTA = new DefaultSettings(Blocks.BLACK_TERRACOTTA)
//        .material("black_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:black_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings WHITE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.WHITE_GLAZED_TERRACOTTA)
//        .material("white_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:white_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings ORANGE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_GLAZED_TERRACOTTA)
//        .material("orange_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:orange_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings MAGENTA_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_GLAZED_TERRACOTTA)
//        .material("magenta_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:magenta_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIGHT_BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
//        .material("light_blue_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_blue_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings YELLOW_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_GLAZED_TERRACOTTA)
//        .material("yellow_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:yellow_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIME_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIME_GLAZED_TERRACOTTA)
//        .material("lime_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:lime_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PINK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PINK_GLAZED_TERRACOTTA)
//        .material("pink_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:pink_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GRAY_GLAZED_TERRACOTTA)
//        .material("gray_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:gray_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIGHT_GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
//        .material("light_gray_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_gray_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CYAN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.CYAN_GLAZED_TERRACOTTA)
//        .material("cyan_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cyan_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PURPLE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_GLAZED_TERRACOTTA)
//        .material("purple_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:purple_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLUE_GLAZED_TERRACOTTA)
//        .material("blue_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:blue_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BROWN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BROWN_GLAZED_TERRACOTTA)
//        .material("brown_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:brown_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GREEN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GREEN_GLAZED_TERRACOTTA)
//        .material("green_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:green_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings RED_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.RED_GLAZED_TERRACOTTA)
//        .material("red_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BLACK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLACK_GLAZED_TERRACOTTA)
//        .material("black_glazed_terracotta")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:black_glazed_terracotta")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings WHITE_CONCRETE = new DefaultSettings(Blocks.WHITE_CONCRETE)
//        .material("white_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:white_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings ORANGE_CONCRETE = new DefaultSettings(Blocks.ORANGE_CONCRETE)
//        .material("orange_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:orange_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings MAGENTA_CONCRETE = new DefaultSettings(Blocks.MAGENTA_CONCRETE)
//        .material("magenta_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:magenta_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIGHT_BLUE_CONCRETE = new DefaultSettings(Blocks.LIGHT_BLUE_CONCRETE)
//        .material("light_blue_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_blue_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings YELLOW_CONCRETE = new DefaultSettings(Blocks.YELLOW_CONCRETE)
//        .material("yellow_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:yellow_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIME_CONCRETE = new DefaultSettings(Blocks.LIME_CONCRETE)
//        .material("lime_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:lime_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PINK_CONCRETE = new DefaultSettings(Blocks.PINK_CONCRETE)
//        .material("pink_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:pink_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GRAY_CONCRETE = new DefaultSettings(Blocks.GRAY_CONCRETE)
//        .material("gray_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:gray_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings LIGHT_GRAY_CONCRETE = new DefaultSettings(Blocks.LIGHT_GRAY_CONCRETE)
//        .material("light_gray_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_gray_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings CYAN_CONCRETE = new DefaultSettings(Blocks.CYAN_CONCRETE)
//        .material("cyan_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cyan_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings PURPLE_CONCRETE = new DefaultSettings(Blocks.PURPLE_CONCRETE)
//        .material("purple_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:purple_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BLUE_CONCRETE = new DefaultSettings(Blocks.BLUE_CONCRETE)
//        .material("blue_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:blue_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BROWN_CONCRETE = new DefaultSettings(Blocks.BROWN_CONCRETE)
//        .material("brown_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:brown_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings GREEN_CONCRETE = new DefaultSettings(Blocks.GREEN_CONCRETE)
//        .material("green_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:green_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings RED_CONCRETE = new DefaultSettings(Blocks.RED_CONCRETE)
//        .material("red_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    public static DefaultSettings BLACK_CONCRETE = new DefaultSettings(Blocks.BLACK_CONCRETE)
//        .material("black_concrete")
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:black_concrete")
//            )
//        )
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs()
//        .withWall();
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings WHITE_STAINED_GLASS = new DefaultSettings(Blocks.WHITE_STAINED_GLASS)
//        .material("white_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:white_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings ORANGE_STAINED_GLASS = new DefaultSettings(Blocks.ORANGE_STAINED_GLASS)
//        .material("orange_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:orange_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings MAGENTA_STAINED_GLASS = new DefaultSettings(Blocks.MAGENTA_STAINED_GLASS)
//        .material("magenta_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:magenta_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings LIGHT_BLUE_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_BLUE_STAINED_GLASS)
//        .material("light_blue_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_blue_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings YELLOW_STAINED_GLASS = new DefaultSettings(Blocks.YELLOW_STAINED_GLASS)
//        .material("yellow_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:yellow_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings LIME_STAINED_GLASS = new DefaultSettings(Blocks.LIME_STAINED_GLASS)
//        .material("lime_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:lime_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings PINK_STAINED_GLASS = new DefaultSettings(Blocks.PINK_STAINED_GLASS)
//        .material("pink_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:pink_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings GRAY_STAINED_GLASS = new DefaultSettings(Blocks.GRAY_STAINED_GLASS)
//        .material("gray_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:gray_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings LIGHT_GRAY_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_GRAY_STAINED_GLASS)
//        .material("light_gray_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:light_gray_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings CYAN_STAINED_GLASS = new DefaultSettings(Blocks.CYAN_STAINED_GLASS)
//        .material("cyan_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:cyan_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings PURPLE_STAINED_GLASS = new DefaultSettings(Blocks.PURPLE_STAINED_GLASS)
//        .material("purple_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:purple_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings BLUE_STAINED_GLASS = new DefaultSettings(Blocks.BLUE_STAINED_GLASS)
//        .material("blue_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:blue_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings BROWN_STAINED_GLASS = new DefaultSettings(Blocks.BROWN_STAINED_GLASS)
//        .material("brown_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:brown_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings GREEN_STAINED_GLASS = new DefaultSettings(Blocks.GREEN_STAINED_GLASS)
//        .material("green_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:green_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings RED_STAINED_GLASS = new DefaultSettings(Blocks.RED_STAINED_GLASS)
//        .material("red_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:red_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings BLACK_STAINED_GLASS = new DefaultSettings(Blocks.BLACK_STAINED_GLASS)
//        .material("black_stained_glass")
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:black_stained_glass")
//            )
//        )
//        .withCompressedBlock()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    /******************************************************************************************************************/
//
//    public static DefaultSettings ACACIA = new DefaultSettings(Blocks.ACACIA_PLANKS)
//        .material("acacia")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:acacia_planks"),
//                "log", Identifier.of("minecraft:acacia_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_acacia_log"),
//                "planks", Identifier.of("minecraft:acacia_planks"),
//                "slab", Identifier.of("minecraft:acacia_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings ACACIA_LEAVES = new DefaultSettings(Blocks.ACACIA_LEAVES)
//        .material("acacia_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:acacia_leaves")
//            )
//        );
//
//    public static DefaultSettings ACACIA_LOG = new DefaultSettings(Blocks.ACACIA_PLANKS)
//        .material("acacia_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:acacia_log"),
//                "end", Identifier.of("minecraft:acacia_log_top"),
//                "log", Identifier.of("minecraft:acacia_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_acacia_log"),
//                "planks", Identifier.of("minecraft:acacia_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings AZALEA_LEAVES = new DefaultSettings(Blocks.AZALEA_LEAVES)
//        .material("azalea_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:azalea_leaves")
//            )
//        );
//
//    public static DefaultSettings BIRCH = new DefaultSettings(Blocks.BIRCH_PLANKS)
//        .material("birch")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:birch_planks"),
//                "log", Identifier.of("minecraft:birch_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_birch_log"),
//                "planks", Identifier.of("minecraft:birch_planks"),
//                "slab", Identifier.of("minecraft:birch_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings BIRCH_LEAVES = new DefaultSettings(Blocks.BIRCH_LEAVES)
//        .material("birch_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:birch_leaves")
//            )
//        );
//
//    public static DefaultSettings BIRCH_LOG = new DefaultSettings(Blocks.BIRCH_PLANKS)
//        .material("birch_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:birch_log"),
//                "end", Identifier.of("minecraft:birch_log_top"),
//                "log", Identifier.of("minecraft:birch_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_birch_log"),
//                "planks", Identifier.of("minecraft:birch_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings CRIMSON = new DefaultSettings(Blocks.CRIMSON_PLANKS)
//        .material("crimson")
//        .wooden()
//        .tool(Tool.AXE)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:crimson_planks"),
//                "log", Identifier.of("minecraft:crimson_stem"),
//                "stripped_log", Identifier.of("minecraft:stripped_crimson_stem"),
//                "planks", Identifier.of("minecraft:crimson_planks"),
//                "slab", Identifier.of("minecraft:crimson_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings CRIMSON_STEM = new DefaultSettings(Blocks.CRIMSON_PLANKS)
//        .material("crimson_stem")
//        .wooden()
//        .tool(Tool.AXE)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:crimson_stem"),
//                "end", Identifier.of("minecraft:crimson_stem_top"),
//                "log", Identifier.of("minecraft:crimson_stem"),
//                "stripped_log", Identifier.of("minecraft:stripped_crimson_stem"),
//                "planks", Identifier.of("minecraft:crimson_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings DARK_OAK = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
//        .material("dark_oak")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:dark_oak_planks"),
//                "log", Identifier.of("minecraft:dark_oak_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_dark_oak_log"),
//                "planks", Identifier.of("minecraft:dark_oak_planks"),
//                "slab", Identifier.of("minecraft:dark_oak_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings DARK_OAK_LEAVES = new DefaultSettings(Blocks.DARK_OAK_LEAVES)
//        .material("dark_oak_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:dark_oak_leaves")
//            )
//        );
//
//    public static DefaultSettings DARK_OAK_LOG = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
//        .material("dark_oak_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:dark_oak_log"),
//                "end", Identifier.of("minecraft:dark_oak_log_top"),
//                "log", Identifier.of("minecraft:dark_oak_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_dark_oak_log"),
//                "planks", Identifier.of("minecraft:dark_oak_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings FLOWERING_AZALEA_LEAVES = new DefaultSettings(Blocks.FLOWERING_AZALEA_LEAVES)
//        .material("flowering_azalea_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:flowering_azalea_leaves")
//            )
//        );
//
//    public static DefaultSettings JUNGLE = new DefaultSettings(Blocks.JUNGLE_PLANKS)
//        .material("jungle")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:jungle_planks"),
//                "log", Identifier.of("minecraft:jungle_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_jungle_log"),
//                "planks", Identifier.of("minecraft:jungle_planks"),
//                "slab", Identifier.of("minecraft:jungle_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings JUNGLE_LEAVES = new DefaultSettings(Blocks.JUNGLE_LEAVES)
//        .material("jungle_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:jungle_leaves")
//            )
//        );
//
//    public static DefaultSettings JUNGLE_LOG = new DefaultSettings(Blocks.JUNGLE_PLANKS)
//        .material("jungle_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:jungle_log"),
//                "end", Identifier.of("minecraft:jungle_log_top"),
//                "log", Identifier.of("minecraft:jungle_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_jungle_log"),
//                "planks", Identifier.of("minecraft:jungle_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings MANGROVE = new DefaultSettings(Blocks.MANGROVE_PLANKS)
//        .material("mangrove")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mangrove_planks"),
//                "log", Identifier.of("minecraft:mangrove_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_mangrove_log"),
//                "planks", Identifier.of("minecraft:mangrove_planks"),
//                "slab", Identifier.of("minecraft:mangrove_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings MANGROVE_LEAVES = new DefaultSettings(Blocks.MANGROVE_LEAVES)
//        .material("mangrove_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mangrove_leaves")
//            )
//        );
//
//    public static DefaultSettings MANGROVE_LOG = new DefaultSettings(Blocks.MANGROVE_PLANKS)
//        .material("mangrove_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:mangrove_log"),
//                "end", Identifier.of("minecraft:mangrove_log_top"),
//                "log", Identifier.of("minecraft:mangrove_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_mangrove_log"),
//                "planks", Identifier.of("minecraft:mangrove_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings OAK = new DefaultSettings(Blocks.OAK_PLANKS)
//        .material("oak")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:oak_planks"),
//                "log", Identifier.of("minecraft:oak_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_oak_log"),
//                "planks", Identifier.of("minecraft:oak_planks"),
//                "slab", Identifier.of("minecraft:oak_slab")
//            )
//        )
//        .bookshelfId("minecraft:bookshelf")
//        .bookshelfModel("minecraft:block/bookshelf")
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings OAK_LEAVES = new DefaultSettings(Blocks.OAK_LEAVES)
//        .material("oak_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:oak_leaves")
//            )
//        );
//
//    public static DefaultSettings OAK_LOG = new DefaultSettings(Blocks.OAK_PLANKS)
//        .material("oak_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:oak_log"),
//                "end", Identifier.of("minecraft:oak_log_top"),
//                "log", Identifier.of("minecraft:oak_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_oak_log"),
//                "planks", Identifier.of("minecraft:oak_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings SPRUCE = new DefaultSettings(Blocks.SPRUCE_PLANKS)
//        .material("spruce")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:spruce_planks"),
//                "log", Identifier.of("minecraft:spruce_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_spruce_log"),
//                "planks", Identifier.of("minecraft:spruce_planks"),
//                "slab", Identifier.of("minecraft:spruce_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings SPRUCE_LEAVES = new DefaultSettings(Blocks.SPRUCE_LEAVES)
//        .material("spruce_leaves")
//        .tool(Tool.SHEARS)
//        .flammable()
//        .translucent()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:spruce_leaves")
//            )
//        );
//
//    public static DefaultSettings SPRUCE_LOG = new DefaultSettings(Blocks.SPRUCE_PLANKS)
//        .material("spruce_log")
//        .wooden()
//        .tool(Tool.AXE)
//        .flammable()
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:spruce_log"),
//                "end", Identifier.of("minecraft:spruce_log_top"),
//                "log", Identifier.of("minecraft:spruce_log"),
//                "stripped_log", Identifier.of("minecraft:stripped_spruce_log"),
//                "planks", Identifier.of("minecraft:spruce_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
//
//    public static DefaultSettings WARPED = new DefaultSettings(Blocks.WARPED_PLANKS)
//        .material("warped")
//        .wooden()
//        .tool(Tool.AXE)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:warped_planks"),
//                "log", Identifier.of("minecraft:warped_stem"),
//                "stripped_log", Identifier.of("minecraft:stripped_warped_stem"),
//                "planks", Identifier.of("minecraft:warped_planks"),
//                "slab", Identifier.of("minecraft:warped_slab")
//            )
//        )
//        .withBookshelfSlab()
//        .withBookshelfStairs()
//        .withVerticalBookshelfStairs()
//        .withDisplayCase()
//        .withStrippedDisplayCase()
//        .withBookshelfDoor()
//        .withChair()
//        .withStool()
//        .withShelf()
//        .withFloatingShelf()
//        .withShutters()
//        .withTable()
//        .withBookshelfTrapdoor();
//
//    public static DefaultSettings WARPED_STEM = new DefaultSettings(Blocks.WARPED_PLANKS)
//        .material("warped_stem")
//        .wooden()
//        .tool(Tool.AXE)
//        .materials(
//            Map.of(
//                "main", Identifier.of("minecraft:warped_stem"),
//                "end", Identifier.of("minecraft:warped_stem_top"),
//                "log", Identifier.of("minecraft:warped_stem"),
//                "stripped_log", Identifier.of("minecraft:stripped_warped_stem"),
//                "planks", Identifier.of("minecraft:warped_planks")
//            )
//        )
//        .column()
//        .withSlab()
//        .withStairs()
//        .withVerticalStairs();
