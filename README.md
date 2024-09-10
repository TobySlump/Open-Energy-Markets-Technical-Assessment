# Rock-Paper-Scissors (with Spock-Lizard Option)

## Table of Contents
- [Introduction](#introduction)
- [How to Play](#how-to-play)
- [Game Modes](#game-modes)
- [Installation](#installation)
- [Running the Game](#running-the-game)

## Introduction
This Java program implements the classic game of **Rock-Paper-Scissors**, along with the extended version that includes **Spock** and **Lizard**. Players can choose between the **Classic Mode** (Rock-Paper-Scissors) and the **Extended Mode** (Rock-Paper-Scissors-Spock-Lizard).

Players also have the option to select how the computer opponent makes decisions:
- The **Normal Computer** randomly selects a move.
- The **Last Choice Computer** remembers the player's last choice and makes its decision accordingly. If this is the first round played, or the previous move made by the user is currently invalid (the user picking Spock previously and then reverting to the original game mode) then a randomly selected move will be used.

## How to Play

1. **Choose Game Mode**: After launching the game, you will be prompted to select either:
   - **Classic Mode** (Rock, Paper, Scissors)
   - **Extended Mode** (Rock, Paper, Scissors, Spock, Lizard)
   
2. **Choose Computer Type**: You will then be asked to choose:
   - **Normal Computer**: Makes random moves.
   - **Last Choice Computer**: Adjusts its move based on your last selection.

3. **Make Your Move**: Depending on the game mode, choose one of the following options:
   - Classic Mode: `rock`, `paper`, `scissors`
   - Extended Mode: `rock`, `paper`, `scissors`, `spock`, `lizard`

4. **Game Result**: The computer will reveal its choice, and the result will be displayed (win, lose, or draw).

5. **Play Again**: After each round, you will have the option to play again or exit the game.

## Game Modes

### Classic Mode (Rock-Paper-Scissors)
- **Rock** beats Scissors
- **Paper** beats Rock
- **Scissors** beats Paper

### Extended Mode (Rock-Paper-Scissors-Spock-Lizard)
- **Rock** crushes Scissors
- **Scissors** cuts Paper
- **Paper** covers Rock
- **Rock** crushes Lizard
- **Lizard** poisons Spock
- **Spock** smashes Scissors
- **Scissors** decapitates Lizard
- **Lizard** eats Paper
- **Paper** disproves Spock
- **Spock** vaporizes Rock

## Installation

1. Clone this repository or download the source files:
   ```bash
   git clone https://github.com/TobySlump/Open-Energy-Markets-Technical-Assessment

2. Open the project in your preferred Java IDE (such as IntelliJ IDEA or Eclipse).

3. Compile the code and ensure all dependencies are properly installed.

## Running the Game

1. Open the poject in your IDE.
2. Locate the **Main**  runnable class.
3. Right-click and select **Run** to execute the game.


