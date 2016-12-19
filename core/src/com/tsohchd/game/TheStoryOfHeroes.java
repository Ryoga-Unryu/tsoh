package com.tsohchd.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import javafx.scene.Scene;

public class TheStoryOfHeroes extends ApplicationAdapter {
	private Stage stage;
	private TextButton button;
	private TextButton button2;
	private BitmapFont font;
	private Skin skin;
	private TextureAtlas buttonAtlas;
	private TextButtonStyle buttonStyle;
	private Table table;
	
	@Override
	public void create () {	
		this.stage = new Stage();
		final Stage theStage = this.stage;
		System.out.println("Position X: " + this.stage.getViewport().getScreenX());
		System.out.println("Position Y: " + this.stage.getViewport().getScreenY());
		System.out.println("VP Width: " + this.stage.getViewport().getScreenWidth());
		System.out.println("VP Height: " + this.stage.getViewport().getScreenHeight());
		System.out.println("Width: " + this.stage.getWidth());
		System.out.println("Height: " + this.stage.getHeight());
		
        Gdx.input.setInputProcessor(stage);
        this.font = new BitmapFont();
        this.skin = new Skin(); 
        this.buttonAtlas = new TextureAtlas(Gdx.files.internal("button.pack"));
        skin.addRegions(buttonAtlas);

        this.table = new Table(skin);
        this.table.setBounds(0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        
        this.buttonStyle = new TextButtonStyle();
        this.buttonStyle.font = font;
        this.buttonStyle.up = skin.getDrawable("buttonOff");
        this.buttonStyle.down = skin.getDrawable("buttonOn");
        this.buttonStyle.checked = skin.getDrawable("buttonOff");
        this.button = new TextButton("Button1", this.buttonStyle);
        final TextButton theButton = this.button;
        this.button.addListener(new ClickListener() {
        	@Override
        	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        		System.out.println("Pressed Button 1!");
        		return super.touchDown(event, x, y, pointer, button);
        	}
        	
        	@Override
        	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        		Rectangle buttonRec = new Rectangle(0, 0, theButton.getWidth(), theButton.getHeight());
        		Rectangle mouseRec = new Rectangle(x, y, 0, 0);
        		System.out.println("Released Button 1! Is on button: " + buttonRec.overlaps(mouseRec) + " (" + buttonRec + ") (" + mouseRec + ")");
        		
        		if(buttonRec.overlaps(mouseRec)) {
        			theButton.remove();
        		}
        		super.touchUp(event, x, y, pointer, button);
        	}
        });
        this.button2 = new TextButton("Button2", this.buttonStyle);
        final TextButton theButton2 = this.button2;
        this.button2.addListener(new ClickListener() {
        	@Override
        	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        		System.out.println("Pressed Button 2!");
        		return super.touchDown(event, x, y, pointer, button);
        	}
        	
        	@Override
        	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        		Rectangle buttonRec = new Rectangle(0, 0, theButton2.getWidth(), theButton2.getHeight());
        		Rectangle mouseRec = new Rectangle(x, y, 0, 0);
        		System.out.println("Released Button 2! Is on button: " + buttonRec.overlaps(mouseRec) + " (" + buttonRec + ") (" + mouseRec + ")");
        		
        		if(buttonRec.overlaps(mouseRec)) {
        			theButton2.remove();
        		}
        		super.touchUp(event, x, y, pointer, button);
        	}
        });

        this.button.setPosition(50, 50);
        this.stage.addActor(this.button);
        this.stage.addActor(this.button2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.stage.draw();
	}
}
