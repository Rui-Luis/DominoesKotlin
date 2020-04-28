class Game {
    var availableTiles = mutableListOf<Tile>()
    var board = Board()

    fun generateTiles() {
        for (i in 0..6) {
            for (j in i..6) {
                availableTiles.add(Tile(i, j))
            }
        }
        availableTiles.shuffle()
    }

    fun playFirstTile() {
        var firstTile = availableTiles.removeAt(0)
        board.tiles.add(firstTile)
        println("Game starting with first tile: $firstTile")
    }

    fun printBoard() {
        // println("Board is now: " +
        print("Board is now: ")
        for(tile in board.tiles) {
            print("$tile ")
        }
        println("")
    }

    fun getHandTiles(): MutableList<Tile> {
        var tilesForHand = mutableListOf<Tile>()

        for (i in 0..6) {
            tilesForHand.add(availableTiles.removeAt(i))
        }
        return tilesForHand
    }

    fun grabNewTile(): Tile {
        return availableTiles.removeAt(0)
    }

    fun hasAvailableTiles(): Boolean {
        return !availableTiles.isEmpty()
    }

}