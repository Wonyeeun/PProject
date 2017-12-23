package dynamic;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private char c;
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon foodButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/mealEntered.png"));
	private ImageIcon foodButtonBasicImage = new ImageIcon(Main.class.getResource("../images/mealBasic.png"));
	private ImageIcon dessertButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/dessertEntered.png"));
	private ImageIcon dessertButtonBasicImage = new ImageIcon(Main.class.getResource("../images/dessertBasic.png"));
	private ImageIcon BackButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon BackButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon meatButtonBasicImage = new ImageIcon(Main.class.getResource("../images/meatlogo3.png"));
	private ImageIcon meatButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/meatlogo3.png"));
	private ImageIcon japanButtonBasicImage = new ImageIcon(Main.class.getResource("../images/japanlogo3.png"));
	private ImageIcon japanButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/japanlogo3.png"));
	private ImageIcon snackButtonBasicImage = new ImageIcon(Main.class.getResource("../images/snacklogo3.png"));
	private ImageIcon snackButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/snacklogo3.png"));
	
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpeg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton mleftButton = new JButton(leftButtonBasicImage);
	private JButton mrightButton = new JButton(rightButtonBasicImage);
	private JButton jleftButton = new JButton(leftButtonBasicImage);
	private JButton jrightButton = new JButton(rightButtonBasicImage);
	private JButton sleftButton = new JButton(leftButtonBasicImage);
	private JButton srightButton = new JButton(rightButtonBasicImage);
	private JButton foodButton = new JButton(foodButtonBasicImage);
	private JButton dessertButton = new JButton(dessertButtonBasicImage);
	private JButton backButton = new JButton(BackButtonBasicImage);
	private JButton backButton2 = new JButton(BackButtonBasicImage);
	private JButton meatButton = new JButton(meatButtonBasicImage);
	private JButton japanButton = new JButton(japanButtonBasicImage);
	private JButton snackButton = new JButton(snackButtonBasicImage);

	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	ArrayList<Track> cafeList = new ArrayList<Track>();
	ArrayList<Track> meatList = new ArrayList<Track>();
	ArrayList<Track> japanList = new ArrayList<Track>();
	ArrayList<Track> snackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		Music introMusic = new Music("°£½Ä¼Û.mp3", true);
		introMusic.start();

		cafeList.add(new Track("Æ®·ÎÇÇÅ© (1).png"));
		cafeList.add(new Track("³î½£ (1).png"));
		cafeList.add(new Track("´©ºâ.png"));
		//»çÁø ¾ÆÁ÷ ¾È ¹Ù²Þ ¹Ù²ã¾ßÇÔ ÀÌ ¸ðµç ¸®½ºÆ²ÀÇ »çÁø ¹Ù²ã¾ßÇÔ.
		meatList.add(new Track("99.png"));
		meatList.add(new Track("ÀÏ¹Ì.png"));
		meatList.add(new Track("À°Àå.png"));
		
		japanList.add(new Track("µ·µ·Á¤ (1).png"));
		japanList.add(new Track("¿¡ºñ¼ö (1).png"));
		japanList.add(new Track("Åä³¢Á¤ (1).png"));
		
		snackList.add(new Track("»¡ºÀ (1).png"));
		snackList.add(new Track("¼­°¡¿ø.png"));
		snackList.add(new Track("¸ó½ºÅÍ.png"));
		
		
		exitButton.setBounds(930, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				lookmain();
			}
		});
		add(startButton);
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(70, 310, 100, 100);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(850, 310, 100, 100);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);
		
		mleftButton.setVisible(false);
		mleftButton.setBounds(70, 310, 100, 100);
		mleftButton.setBorderPainted(false);
		mleftButton.setContentAreaFilled(false);
		mleftButton.setFocusPainted(false);
		mleftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mleftButton.setIcon(leftButtonEnteredImage);
				mleftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mleftButton.setIcon(leftButtonBasicImage);
				mleftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				mselectLeft();
			}
		});
		add(mleftButton);

		mrightButton.setVisible(false);
		mrightButton.setBounds(850, 310, 100, 100);
		mrightButton.setBorderPainted(false);
		mrightButton.setContentAreaFilled(false);
		mrightButton.setFocusPainted(false);
		mrightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mrightButton.setIcon(rightButtonEnteredImage);
				mrightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mrightButton.setIcon(rightButtonBasicImage);
				mrightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				mselectRight();
			}
		});
		add(mrightButton);
		
		jleftButton.setVisible(false);
		jleftButton.setBounds(70, 310, 100, 100);
		jleftButton.setBorderPainted(false);
		jleftButton.setContentAreaFilled(false);
		jleftButton.setFocusPainted(false);
		jleftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jleftButton.setIcon(leftButtonEnteredImage);
				jleftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jleftButton.setIcon(leftButtonBasicImage);
				jleftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				jselectLeft();
			}
		});
		add(jleftButton);

		jrightButton.setVisible(false);
		jrightButton.setBounds(850, 310, 100, 100);
		jrightButton.setBorderPainted(false);
		jrightButton.setContentAreaFilled(false);
		jrightButton.setFocusPainted(false);
		jrightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jrightButton.setIcon(rightButtonEnteredImage);
				jrightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jrightButton.setIcon(rightButtonBasicImage);
				jrightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				jselectRight();
			}
		});
		add(jrightButton);
		
		sleftButton.setVisible(false);
		sleftButton.setBounds(70, 310, 100, 100);
		sleftButton.setBorderPainted(false);
		sleftButton.setContentAreaFilled(false);
		sleftButton.setFocusPainted(false);
		sleftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sleftButton.setIcon(leftButtonEnteredImage);
				sleftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sleftButton.setIcon(leftButtonBasicImage);
				sleftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				sselectLeft();
			}
		});
		add(sleftButton);

		srightButton.setVisible(false);
		srightButton.setBounds(850, 310, 100, 100);
		srightButton.setBorderPainted(false);
		srightButton.setContentAreaFilled(false);
		srightButton.setFocusPainted(false);
		srightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				srightButton.setIcon(rightButtonEnteredImage);
				srightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				srightButton.setIcon(rightButtonBasicImage);
				srightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				sselectRight();
			}
		});
		add(srightButton);
		
		backButton.setVisible(false);
		backButton.setBounds(10, 10, 100, 100);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(BackButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(BackButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				goback();
			}
		});
		add(backButton);
		
		backButton2.setVisible(false);
		backButton2.setBounds(10, 10, 100, 100);
		backButton2.setBorderPainted(false);
		backButton2.setContentAreaFilled(false);
		backButton2.setFocusPainted(false);
		backButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton2.setIcon(BackButtonEnteredImage);
				backButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton2.setIcon(BackButtonBasicImage);
				backButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				mjsgoback();
			}
		});
		add(backButton2);
		
		
		foodButton.setVisible(false);
		foodButton.setBounds(200, 250, 250, 97);
		foodButton.setBorderPainted(false);
		foodButton.setContentAreaFilled(false);
		foodButton.setFocusPainted(false);
		foodButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				foodButton.setIcon(foodButtonEnteredImage);
				foodButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				foodButton.setIcon(foodButtonBasicImage);
				foodButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				dfgoin(true);
			}
		});
		add(foodButton);
		
		dessertButton.setVisible(false);
		dessertButton.setBounds(550, 250, 250, 97);
		dessertButton.setBorderPainted(false);
		dessertButton.setContentAreaFilled(false);
		dessertButton.setFocusPainted(false);
		dessertButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dessertButton.setIcon(dessertButtonEnteredImage);
				dessertButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dessertButton.setIcon(dessertButtonBasicImage);
				dessertButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				dfgoin(false);
			}
		});
		add(dessertButton);
		

		meatButton.setVisible(false);
		meatButton.setBounds(70, 150, 280, 280);
		meatButton.setBorderPainted(false);
		meatButton.setContentAreaFilled(false);
		meatButton.setFocusPainted(false);
		meatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				meatButton.setIcon(meatButtonEnteredImage);
				meatButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				meatButton.setIcon(meatButtonBasicImage);
				meatButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				c='m';
				mjsgoin(c);
				
			}
		});
		add(meatButton);
		

		japanButton.setVisible(false);
		japanButton.setBounds(340, 150, 300, 300);
		japanButton.setBorderPainted(false);
		japanButton.setContentAreaFilled(false);
		japanButton.setFocusPainted(false);
		japanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				japanButton.setIcon(japanButtonEnteredImage);
				japanButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				japanButton.setIcon(japanButtonBasicImage);
				japanButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				c='j';
				mjsgoin(c);
			}
		});
		add(japanButton);
		

		snackButton.setVisible(false);
		snackButton.setBounds(670, 150, 300, 300);
		snackButton.setBorderPainted(false);
		snackButton.setContentAreaFilled(false);
		snackButton.setFocusPainted(false);
		snackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				snackButton.setIcon(snackButtonEnteredImage);
				snackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				snackButton.setIcon(snackButtonBasicImage);
				snackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				c='s';
				mjsgoin(c);
				
			}
		});
		add(snackButton);
		
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 150, 100, null);
		}
		paintComponents(g);
		this.repaint();
	}
	
	public void selectcafe(int nowSelected) {
		titleImage = new ImageIcon(Main.class.getResource("../images/" +cafeList.get(nowSelected).getTitleImage())).getImage();
		//selectedImage = new ImageIcon(Main.class.getResource("../images/" + cafeList.get(nowSelected).getStartImage())).getImage();
		//selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		//selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = cafeList.size() - 1;
		else
			nowSelected--;
		selectcafe(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == cafeList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectcafe(nowSelected);
	}
	
	public void selectmeat(int nowSelected) {
		titleImage = new ImageIcon(Main.class.getResource("../images/" +meatList.get(nowSelected).getTitleImage())).getImage();
		//selectedImage = new ImageIcon(Main.class.getResource("../images/" + meatList.get(nowSelected).getStartImage())).getImage();
		//selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		//selectedMusic.start();
	}
	
	public void mselectLeft() {
		if(nowSelected == 0)
			nowSelected = meatList.size() - 1;
		else
			nowSelected--;
		selectmeat(nowSelected);
	}
	
	public void mselectRight() {
		if(nowSelected == meatList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectmeat(nowSelected);
	}
	
	public void selectjapan(int nowSelected) {
		titleImage = new ImageIcon(Main.class.getResource("../images/" +japanList.get(nowSelected).getTitleImage())).getImage();
		//selectedImage = new ImageIcon(Main.class.getResource("../images/" + japanList.get(nowSelected).getStartImage())).getImage();
		//selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		//selectedMusic.start();
	}
	
	public void jselectLeft() {
		if(nowSelected == 0)
			nowSelected = japanList.size() - 1;
		else
			nowSelected--;
		selectjapan(nowSelected);
	}
	
	public void jselectRight() {
		if(nowSelected == japanList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectjapan(nowSelected);
	}
	
	public void selectsnack(int nowSelected) {
		titleImage = new ImageIcon(Main.class.getResource("../images/" +snackList.get(nowSelected).getTitleImage())).getImage();
		//selectedImage = new ImageIcon(Main.class.getResource("../images/" + snackList.get(nowSelected).getStartImage())).getImage();
		//selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		//selectedMusic.start();
	}
	
	public void sselectLeft() {
		if(nowSelected == 0)
			nowSelected = snackList.size() - 1;
		else
			nowSelected--;
		selectsnack(nowSelected);
	}
	
	public void sselectRight() {
		if(nowSelected == snackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectsnack(nowSelected);
	}
	
	public void dfgoin(boolean f) {
		//½Ä»ç¿¡ µé¾î°¡¸é
		if(f) {
			isMainScreen=false;
			leftButton.setVisible(false);
			rightButton.setVisible(false);
			meatButton.setVisible(true);
			snackButton.setVisible(true);
			japanButton.setVisible(true);
		}
		//µðÀúÆ®¿¡ µé¾î°¡¸é
		else {
			isMainScreen = true;
			leftButton.setVisible(true);
			selectcafe(0);
			rightButton.setVisible(true);}
		
		foodButton.setVisible(false);
		dessertButton.setVisible(false);
		backButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/secondBackground.jpeg")).getImage();
		
	}
	
	
	public void mjsgoin(char c)
	
	{
		isMainScreen = true ;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		foodButton.setVisible(false);
		dessertButton.setVisible(false);
		japanButton.setVisible(false);
		snackButton.setVisible(false);
		meatButton.setVisible(false);
		backButton.setVisible(false);
		backButton2.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/secondBackground.jpeg")).getImage();
		if(c=='m') {
			selectmeat(0);
			mleftButton.setVisible(true);
			mrightButton.setVisible(true);
			sleftButton.setVisible(false);
			srightButton.setVisible(false);
			jleftButton.setVisible(false);
			jrightButton.setVisible(false);
			
		}
		if(c=='j') {
			selectjapan(0);
			mleftButton.setVisible(false);
			mrightButton.setVisible(false);
			sleftButton.setVisible(false);
			srightButton.setVisible(false);
			jleftButton.setVisible(true);
			jrightButton.setVisible(true);
			
		
		}
		if(c=='s') {
			selectsnack(0);
			mleftButton.setVisible(false);
			mrightButton.setVisible(false);
			sleftButton.setVisible(true);
			srightButton.setVisible(true);
			jleftButton.setVisible(false);
			jrightButton.setVisible(false);
			
		}
	}
	
	public void goback() {
		isMainScreen = false;
		leftButton.setVisible(false); 
		rightButton.setVisible(false);
		foodButton.setVisible(true);
		backButton.setVisible(false);
		dessertButton.setVisible(true);
		meatButton.setVisible(false);
		japanButton.setVisible(false);
		snackButton.setVisible(false);
		mleftButton.setVisible(false);
		mrightButton.setVisible(false);
		sleftButton.setVisible(false);
		srightButton.setVisible(false);
		jleftButton.setVisible(false);
		jrightButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/secondBackground.jpeg")).getImage();
	}
	
	public void mjsgoback() {
		isMainScreen = false;
		leftButton.setVisible(false); 
		rightButton.setVisible(false);
		foodButton.setVisible(false);
		backButton.setVisible(true);
		backButton2.setVisible(false);
		dessertButton.setVisible(false);
		meatButton.setVisible(true);
		japanButton.setVisible(true);
		snackButton.setVisible(true);
		mleftButton.setVisible(false);
		mrightButton.setVisible(false);
		sleftButton.setVisible(false);
		srightButton.setVisible(false);
		jleftButton.setVisible(false);
		jrightButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/secondBackground.jpeg")).getImage();
		
	}
	
	public void lookmain() {
		startButton.setVisible(false);
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		foodButton.setVisible(true);
		dessertButton.setVisible(true);
		backButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/secondBackground.jpeg"))
				.getImage();
		isMainScreen = true;
	}

}
