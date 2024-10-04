### 1.21.x - 6.1.0

#### New Features

* Mob in a jar
  * Glass jars can now be used to capture and display some mobs. Right-clicking a mob with an empty jar will capture it, and shift-right-clicking a jar will release the mob.
  * Mobs that can be captured include:
    * Allays
    * Bats
    * Endermites
    * Silverfish
    * Small slimes
    * Vexes
* Framed planks
  * These planks have a similar appearance to crates, but are purely decorative.


### 1.21.x - 6.0.0

#### BREAKING CHANGES

This release fixes a crash on 1.21.1 related to Minekea's variant barrels. _Before upgrading_,
make sure to break any existing variant barrels that have been placed in your world. Any items
left in a Minekea barrel will be lost upon upgrade!

#### New Features

* Bamboo furniture
  * Added bamboo variants for all furniture and other wood type items
* Double crates
  * Crates can now merge along a horizontal axis to form double crates, similar to the behavior for chests
* Trapped crates and double crates
  * Added trapped variants of crates and double crates
* Added new ancient lantern variant

#### Changes

* Beams now support wrenches from other mods. Specifically, anything in the `c:tools/wrenches` item tag will work


### 1.21.x - 5.2.0

#### New Features

* Votive candles
    * Fancy candles that behave identically to vanilla ones
* Wax
  * Wax comes in both item and block form. It can be acquired by smelting candles or honeycomb.
  * Wax is a slippery block, causing entities to slide slightly less than on ice.
  * Similar to glazed terracotta blocks, honey and slime do not stick to wax.

#### Changes

* Armor-oires no longer need to be placed on a solid block.


### 1.21.x - 5.1.0

#### New features

* Armor-oires! These beautiful furniture items can store up to 4 complete sets of armor!

#### Bug fixes

* Crash when placing shutters on a top or bottom surface ([theaceofthespade](https://github.com/theaceofthespade))


### 1.19.1-2 - 4.0.2

#### Bug Fixes
* Fix server/client desync when using hammers on a dedicated server

### 1.19.1-2 - 4.0.1

#### Bug Fixes
* Fix client crash when trying to put a sandwich from the [Sandwichable](https://www.curseforge.com/minecraft/mc-mods/sandwichable) mod into a display case


### 1.19.1-2 - 4.0.0

First release for 1.19.1-2!


### 1.19 - 3.4.0

#### Bug Fixes
* Wooden blocks from BYG and BetterEnd/Nether now break with an axe instead of pickaxe
* Block painter now works correctly on servers instead of crashing your game
* Item models for some furniture blocks now render correctly in item frames
* When cobbled end stone is disabled, Minekea will no longer spam a bunch of invalid JSON warnings and other junk in the logs

#### New Features
* Variant barrels now function as a workstation for Fisherman villagers ([#64](https://github.com/chimericdream/minekea-fabric/issues/64))


### 1.19 - 3.3.3

#### Bug Fixes
* Fix recipes for bookshelf stairs and vertical stairs for BetterEnd / BetterNether ([#62](https://github.com/chimericdream/minekea-fabric/issues/62))
* Fix conflicting recipe for wool pressure plates ([#62](https://github.com/chimericdream/minekea-fabric/issues/62))


### 1.19 - 3.3.2

#### Bug Fixes
* Fix recipes for bookshelf stairs and vertical stairs
* Fix recipes for dyed bone block storage bookshelves


### 1.19 - 3.3.1

#### Bug Fixes
* Chair placement: fix issue with placement not behaving as expected when you weren't looking perfectly straight ([#60](https://github.com/chimericdream/minekea-fabric/issues/60))


### 1.19 - 3.3.0

#### Bug Fixes
* BYG: re-add white mangrove to BYG blocks
* End stone: fix end stone texture when cobbled end stone is enabled
* Wrench: make wrenches non-stackable

#### New Features
* Waterloggable blocks: most blocks can now be waterlogged
* Hammers: hammers are a new type of tool which can place blocks randomly selected from your hotbar 
* Shutters: new block type which functions much like a trapdoor, but opens 180 degrees
* Dyed blocks: added dyed variants for many vanilla block types
* Compatibility: added support for Better End, Better Nether, and Mythic Metals!
