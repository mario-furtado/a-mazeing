package org.academiadecodigo.bitjs.amazeing;

import org.academiadecodigo.bitjs.amazeing.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InicialMenu implements KeyboardHandler {

    private Rectangle menu;// mudar por imagem
    private Sound initialSound = new Sound("/resources/sound/Victory.wav");
    private Sound gameSound = new Sound("/resources/sound/Victory.wav");
    private Picture picture = new Picture(10,10,"resources/GRANDEEE.jpg");
    private static final int PADDING = 10;
    private int w = 47 * 30; //num de colunas * tamanho da cell
    private int h = 23 * 30; //num de linhas * tamanho da cell
    private KeyboardEvent startMenu;
    private KeyboardEvent quitMenu;
    private Game game;
    private boolean canStart = true;

    public InicialMenu(SimpleGfxGrid grid){
       this.game = new Game(grid, this);
       initMenu();
   }

   public void initMenu(){
       picture.draw();
       bootstrapMenu();
       initialSound.play(true);
   }

   //---------keyboard--------//
   private void bootstrapMenu(){
       Keyboard keyboard3 = new Keyboard(this);

       startMenu = new KeyboardEvent();
       startMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
       startMenu.setKey(KeyboardEvent.KEY_SPACE);
       keyboard3.addEventListener(startMenu);

       quitMenu = new KeyboardEvent();
       quitMenu.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
       quitMenu.setKey(KeyboardEvent.KEY_P);
       keyboard3.addEventListener(quitMenu);

   }

   @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
       if(keyboardEvent.getKey() == startMenu.getKey() && canStart){
           picture.delete();
           initialSound.stop();
           game.start();
           gameSound.setLoop(10);
           canStart = false;
           System.out.println("space");
       }

       if(keyboardEvent.getKey() == quitMenu.getKey()){
           System.exit(0);
           System.out.println("quit");
       }
   }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){}

    public Sound getGameSound() {
        return gameSound;
    }
}
