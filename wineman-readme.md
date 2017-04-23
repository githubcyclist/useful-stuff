# Wine Manager Script - wineman
A simple Bash script to help manage Wine.

Should be compatible with all Linux distros, but it was only tested with Ubuntu.

## Installation
Installation is very easy.

1. Clone the repo to your computer.

2. Open a terminal in the folder which you cloned to, and run "chmod +x wineman".

3. Then use "./wineman" to show help. Optionally, copy it to /usr/bin.

## Usage
The usage instructions are displayed when the program is run, but here they are anyway:

wineman [ARGUMENTS]

Commands:

--run <program> - Run a program with the default prefix

--prefix <prefix name> <program> - Run a program with a custom prefix

--mprefix <prefix name> <architecture: 32/64> - Create a new prefix (defaults to 64-bit)

--rmprefix <prefix name> - Remove a prefix

--tricks <trick name> - Run winetricks command

--tricksp <prefix> <trick name> - Run winetricks command with custom prefix

--conf - Open winecfg

--confp <prefix> - Open winecfg with custom prefix

--help - Display this screen
