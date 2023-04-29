# More Explosives Mod

Adds stuff related to explosives like bombs and a way to craft gunpowder.
Focused more on old technology stuff to fit better in the game so if your looking for more modern-like stuff like missiles and modern hand grenades this is the wrong place.

If you are looking for explosives more fun than boring old tnt but nothing too crazy, this mod does just that.

# License

This mod is available under the MIT license.

# Dependencies

You must have these dependencies installed.

- [Fabric Language Kotlin](https://www.curseforge.com/minecraft/mc-mods/fabric-language-kotlin) >=1.9.3+kotlin.1.8.20 for 1.19.2
- [Nbt Crafting](https://modrinth.com/mod/nbt-crafting) >=2.2.3 for 1.19.2

# Credits
[Siphalor](https://modrinth.com/user/Siphalor) - Nbt Crafting

# Items

### Gunpowder bomb:
  A simple bomb that explodes within a certain time and with a certain power.

### Gunpowder Shrapnel Bomb:
  A bomb that does not create an explosion that damages blocks. But instead shoots out tiny pieces of shrapnel at random that damage
  entities depending on their velocity.

### Gunpowder Pack:
  Basically a big gunpowder bomb that has a much bigger explosion power.
  
### Incendiary Bomb:
  A fire bomb that flings fire projectiles everywhere that land and create fire.

### Incendiary Pack:
  Bigger incendiary bomb with a wider range and more fire projectiles.

### Beeswax Fire Starter:
  Throws fire projectiles in the direction used.
  Has a durability of 64 like flint and steel.
  

### Short Musket:
  A gun. Can shoot different types of shot.
  #### Short Musket Mechanics:
  Hold a shot item (iron shot, copper shot) in your offhand and right click.
  Then hold gunpowder in your offhand
  and right click to add (max of 4).
  Once you have loaded the gunpowder
  hold a ramrod in your offhand and right click.
  It should say Ready to Shoot, right click to shoot.
  
  It does have a durability of 256 but it does not show.
  When it reaches 0 it will remove from your inventory

### Iron shot
  Used to load musket or to craft shrapnel bomb.

### Copper shot
  Lesser version of iron shot. 
  Cannot be used to craft shrapnel bomb.
  
### Ramrod
  Used to prepare musket for shooting.

### Iron Musket Cartridge
  Used to instantly load iron shot and gunpowder into musket.

### Copper Musket Cartridge
  Lesser iron musket cartridge.

### Ash
  Used to make ash and water bucket.

### Ash and Water Bucket
  Can be cooked in furnace to get potash.
  Will leave empty bucket when crafted and
  get consumed when cooked.

### Potash
  Part of crafting gunpowder.
  Can be blasted to make powdered potassium
  
### Potassium stuff
  Useless material right now.
  - Block: will explode in the rain and snow.
  - Ingot
  - Powder

### Sulfur chunk
  Part of crafting gunpowder.
  
### Powdered Sulfur
  Obtained by blasting coal itself.
  4 of it will make a sulfur chunk.

# Recipes

List of different recipes in the mod.

## Item Recipes
use [Roughly Enough Items](https://www.curseforge.com/minecraft/mc-mods/roughly-enough-items) which lets you see items and their recipes easier. Currently you can't see fireworks table recipes using roughly enough items.

## Fireworks Table Recipes
Used to upgrade or change explosives.
Hold the item you want to change in your main hand
and hold the item that will be used to change it in your offhand
and right click.

Gunpowder Bomb: 
  - Fuse: extends length of fuse by 5 ticks.
  - Shears (Wont get consumed): removes 5 ticks from fuse.
  - Redstone: makes it so the bomb will start ticking after it has hit the ground.
  - Gunpowder: increases explosion power by 0.25, with a maximum of 4.0.

Gunpowder Pack: 
  - Fuse: extends length of fuse by 5 ticks.
  - Shears (Wont get consumed): removes 5 ticks from fuse.
  - Redstone: makes it so the bomb will start ticking after it has hit the ground.
  - Gunpowder: increases explosion power by 0.25, with a maximum of 7.0.

Gunpowder Bomb (Shrapnel): 
  - Fuse: extends length of fuse by 5 ticks.
  - Shears (Wont get consumed): removes 5 ticks from fuse.
  - Redstone: makes it so the bomb will start ticking after it has hit the ground.

Incendiary Bomb: 
  - Fuse: extends length of fuse by 5 ticks.
  - Shears (Wont get consumed): removes 5 ticks from fuse.
  - Redstone: makes it so the bomb will start ticking after it has hit the ground.

# Planned Features

  - Different types of fireworks.
  - A new tear of explosives.
  - All colors of smoke bombs.
  - A multiplier for how many times you do something in the fireworks table

# Bugs

  - On servers and lan servers some particles are not visible.
  - Method of spawning particles is horrible.
