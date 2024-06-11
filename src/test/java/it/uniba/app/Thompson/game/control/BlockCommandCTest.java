package it.uniba.app.Thompson.game.control;;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlockCommandCTest {

    @BeforeEach
    void setUp() {
        MainControl.removeMatch();
        System.out.println("Setup completed for BlockCommandCTest");
        MainControl.setBoard(new BoardE(true));
    }

    @Test
    @DisplayName("BlockCommandCTest: block a tile with the block command")
    void blockCommandCTestBlock() throws InvalidArguments {
        BlockCommandC blockCommandC = BlockCommandC.getInstance();

        Assertions.assertEquals(blockCommandC.executeCommand("d1"), CommandStatus.SUCCESSFUL, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: block a blocked tile with the block command")
    void blockCommandCTestBlockTwoTimes() throws InvalidArguments {
        BlockCommandC blockCommandC = BlockCommandC.getInstance();
        blockCommandC.executeCommand("d2");

        Assertions.assertEquals(blockCommandC.executeCommand("d2"), CommandStatus.FAILED, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: block an impossible tile with the block command")
    void blockCommandCTestBlockImpossibleTile() throws InvalidArguments {
        BlockCommandC blockCommandC = BlockCommandC.getInstance();

        Assertions.assertEquals(blockCommandC.executeCommand("d9"), CommandStatus.FAILED, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: block a tile occupied by a pawn with the block command")
    void blockCommandCTestBlockOccupiedTile() throws InvalidArguments {
        BlockCommandC blockCommandC = BlockCommandC.getInstance();

        Assertions.assertEquals(blockCommandC.executeCommand("a1"), CommandStatus.FAILED, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: block too many tiles with the block command that are adjacent to the pawn")
    void blockCommandCTestBlockTooManyTiles() throws InvalidArguments {
        BlockCommandC blockCommandC = BlockCommandC.getInstance();
        blockCommandC.executeCommand("a2");
        blockCommandC.executeCommand("a3");
        blockCommandC.executeCommand("b1");
        blockCommandC.executeCommand("b2");
        blockCommandC.executeCommand("b3");
        blockCommandC.executeCommand("c1");
        blockCommandC.executeCommand("c2");

        Assertions.assertEquals(blockCommandC.executeCommand("c3"), CommandStatus.FAILED, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: block too many tiles with the block command")
    void blockCommandCTestBlockTooManyTiles2() throws InvalidArguments {
        BlockCommandC blockCommandC = BlockCommandC.getInstance();
        blockCommandC.executeCommand("a2");
        blockCommandC.executeCommand("a3");
        blockCommandC.executeCommand("a4");
        blockCommandC.executeCommand("d1");
        blockCommandC.executeCommand("d2");
        blockCommandC.executeCommand("d3");
        blockCommandC.executeCommand("d4");
        blockCommandC.executeCommand("d5");
        blockCommandC.executeCommand("d6");

        Assertions.assertEquals(blockCommandC.executeCommand("d7"), CommandStatus.FAILED, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: The match is Ongoing")
    void blockCommandCTestMatchOngoing() throws InvalidArguments {
        MainControl.initMatch();
        BlockCommandC blockCommandC = BlockCommandC.getInstance();

        Assertions.assertEquals(blockCommandC.executeCommand("a1"), CommandStatus.FAILED, "BlockCommandCTest");
    }

    @Test
    @DisplayName("BlockCommandCTest: invalid number of arguments")
    void playCommandCInvalidArgumentsTest() {
        CommandC blockCommandC = BlockCommandC.getInstance();
        String[] dummyArgs = {"dummy1", "dummy2", "dummy3"};

        Assertions.assertThrows(InvalidArguments.class, () -> blockCommandC.executeCommand(dummyArgs),
        "Invalid number of arguments");
    }
}
