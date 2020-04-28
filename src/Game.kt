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
        board.tiles.add(availableTiles.removeAt(0))
        println("Game starting with first tile: " + board.tiles)
    }

    fun printBoard() {
        println("Board is now: " + board.tiles)
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