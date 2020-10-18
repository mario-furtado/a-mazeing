package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InitialMenu implements KeyboardHandler {

    private Sound initialSound = new Sound("/resources/sound/FriendsCut.wav");
    private Sound gameSound = new Sound("/resources/sound/TakeOnMeCut.wav");
    private Picture picture = new Picture(10, 10, "resources/newBigStart.png");
    //private Picture[] pictures = new Picture[2];
    private static final int PADDING = 10;
    private int w = 47 * 30; //num of cols * cell size
    private int h = 23 * 30; //num of rows * cell size
    private KeyboardEvent startMenu;
    private KeyboardEvent quitMenu;
    private KeyboardEvent restartGame;
    private Game game;
    private boolean canStart;
    //private boolean startMenu;
    private SimpleGfxGrid grid;

    public InitialMenu(SimpleGfxGrid grid) {
        //this.pictures[0] = new Picture(10, 10, "resources/newBigStart.png");
        //this.pictures[1] = new Picture(10, 10, "resources/newLittleStart.png");
        initialSound.stop();
        gameSound.stop();
        this.canStart = true;
        this.game = new Game(grid, this);
        this.grid = grid;
        initMenu();
    }

    public void initMenu() {
       /* while()
        for(int i = 0; i < pictures.length; i ++)*/

        picture.draw();
        bootstrapMenu();
        initialSound.setLoop(4);
    }

    //---------keyboard--------//
    private void bootstrapMenu() {
        Keyboard keyboard3 = new Keyboard(this);

        startMenu = new KeyboardEvent();
        startMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        startMenu.setKey(KeyboardEvent.KEY_SPACE);
        keyboard3.addEventListener(startMenu);

        quitMenu = new KeyboardEvent();
        quitMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quitMenu.setKey(KeyboardEvent.KEY_P);
        keyboard3.addEventListener(quitMenu);

        restartGame = new KeyboardEvent();
        restartGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restartGame.setKey(KeyboardEvent.KEY_R);
        keyboard3.addEventListener(restartGame);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == startMenu.getKey() && canStart) {
            picture.delete();
            initialSound.stop();
            game.start();
            gameSound.setLoop(10);
            canStart = false;
        }

        if (keyboardEvent.getKey() == quitMenu.getKey()) {
            System.exit(0);
        }

        if (keyboardEvent.getKey() == restartGame.getKey() && !canStart) {
            gameSound.close();
            initialSound.close();
            game.getVictorySound().close();
            SimpleGfxGrid grid1 = new SimpleGfxGrid(47, 23);
            InitialMenu menu1 = new InitialMenu(grid1);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public Sound getGameSound() {
        return gameSound;
    }

    public Sound getInitialSound() {
        return initialSound;
    }
}
