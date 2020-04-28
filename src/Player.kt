class Player(val name: String, val game: Game) {

    var hand = game.getHandTiles()

    // The playing logic.
    public fun play() {
        if (!hand.isEmpty()) {
            var tileWasPlayed = false
            for (tile in hand) {
                if (game.board.tiles.first().x == tile.x) {
                    tileWasPlayed = true
                    var playedTile = Tile(tile.y, tile.x)
                    game.board.tiles.add(0, playedTile)

                    println("$name played $playedTile")
                    hand.remove(tile)
                    println("$name's hand: $hand")

                    break
                }
                else if (game.board.tiles.first().x == tile.y) {
                    tileWasPlayed = true
                    var playedTile = tile
                    game.board.tiles.add(0, playedTile)

                    println("$name played $playedTile")
                    hand.remove(tile)
                    println("$name's hand: $hand")

                    break
                }
                else if (game.board.tiles.last().y == tile.x) {
                    tileWasPlayed = true
                    var playedTile = tile
                    game.board.tiles.add(playedTile)

                    println("$name played $playedTile")
                    hand.remove(tile)
                    println("$name's hand: $hand")

                    break
                }
                else if (game.board.tiles.last().y == tile.y) {
                    tileWasPlayed = true
                    var playedTile = Tile(tile.y, tile.x)
                    game.board.tiles.add(playedTile)

                    println("$name played $playedTile")
                    hand.remove(tile)
                    println("$name's hand: $hand")

                    break
                }
            }
            if (!tileWasPlayed && game.hasAvailableTiles()) {
                hand.add(game.grabNewTile())
            }
        }
    }

    override fun toString(): String {
        return name
    }

}