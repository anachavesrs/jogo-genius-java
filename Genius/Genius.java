import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Genius extends JFrame implements ActionListener {

    JButton btnIniciar, btnAzul,  btnAmarelo, btnVermelho, btnVerde;
    JLabel etiqueta;
    String array[] = new String [200];
    int marcador, cont, contador, contadorA;
    boolean iniciarJogo;
    String cores [] = {"azul", "amarelo", "vermelho", "verde"};
    
    public Genius(){
        iniciarTabuleiro();
    }

    public final void iniciarTabuleiro(){
        this.setTitle("Genius");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnAzul = new JButton();
        btnAzul.setBounds(100, 100, 100, 100);
        btnAzul.setBackground(Color.BLUE);
        btnAzul.addActionListener(this);
        this.add(btnAzul);

        btnAmarelo = new JButton();
        btnAmarelo.setBounds(200, 100, 100, 100);
        btnAmarelo.setBackground(Color.YELLOW);
        btnAmarelo.addActionListener(this);
        this.add(btnAmarelo);

        btnVermelho = new JButton();
        btnVermelho.setBounds(100, 200, 100, 100);
        btnVermelho.setBackground(Color.RED);
        btnVermelho.addActionListener(this);
        this.add(btnVermelho);

        btnVerde = new JButton();
        btnVerde.setBounds(200, 200, 100, 100);
        btnVerde.setBackground(Color.GREEN);
        btnVerde.addActionListener(this);
        this.add(btnVerde);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(165, 40, 70, 50);
        btnIniciar.setBackground(Color.WHITE);
        btnIniciar.addActionListener(this);
        this.add(btnIniciar);

        etiqueta = new JLabel("Marcador : 0   Record:  0");
        etiqueta.setBounds(30, 18, 300, 30);
        this.add(etiqueta);
    }


    public void revisarTurno(){
        if (contadorA == contador){
            contador = 0;
            marcador++;
            etiqueta.setText("Marcador: " + marcador+ " Record: " + cont);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                
            }
            criarCor();
        }
    }

    public void criarCor(){
        if( iniciarJogo == true){
            int i=0;
            while(i<contadorA){
                if (array [i].equals("azul")) 
                    mudar(btnAzul, new Color(66,50,156),Color.BLUE);

                 if (array [i].equals("amarelo")) 
                    mudar(btnAmarelo, new Color(255,91,0),Color.YELLOW);

                 if (array [i].equals("vermelho")) 
                    mudar(btnVermelho,Color.ORANGE,Color.RED);

                if (array [i].equals("verde")) 
                    mudar(btnVerde, new Color(255,255,100),Color.GREEN);
                    i++;
                }
                int aleatorio = (int) (Math.random()*4);
                 array[contadorA] = cores[aleatorio];

                 if (array [i].equals("azul")) 
                 mudar(btnAzul, new Color(66,50,156),Color.blue);

                 if (array [i].equals("amarelo")) 
                mudar(btnAmarelo, new Color(255,91,0),Color.YELLOW);

                if (array [i].equals("vermelho")) 
                mudar(btnVermelho, Color.ORANGE,Color.RED);

                if (array [i].equals("verde")) 
                mudar(btnVerde, new Color(255,255,100),Color.GREEN);
                contadorA++;
        }
    }

    public void mudar(JButton button, Color mudarCor, Color corOriginal){
        try {
            Thread.sleep(500);
        } catch (Exception e) {
           
        }
        button.setBackground(mudarCor);
        this.update(this.getGraphics());
        Toolkit.getDefaultToolkit().beep();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
           
        }
        button.setBackground(corOriginal);
        this.update(this.getGraphics());

    }

        @Override
       public void actionPerformed(ActionEvent e){
        // throw new UnsupportedOperationException("Mensagem");
        if(iniciarJogo == true && e.getSource() !=btnIniciar){
            if(contadorA > contador){
                String c="";

                if(e.getSource()==btnAzul)
                    c="azul";
                if(e.getSource()==btnAmarelo)
                    c="amarelo";
                if(e.getSource()==btnVermelho)
                    c="vermelho";
                if(e.getSource()==btnVerde)
                    c="verde";
                    
                this.update(this.getGraphics());
                if(c.equals(array[contador])){
                    contador++;
                    Toolkit.getDefaultToolkit().beep();
                    revisarTurno();
                }else{
                    JOptionPane.showMessageDialog(this, "Voce perdeu!: Marcador  " + marcador);
                    if(marcador > cont){
                        cont = marcador;
                    }
                  etiqueta.setText("Marcador: " + marcador + " Record: " + cont);  
                  iniciarJogo = false;
                  contador = 0;
                  contadorA = 0;
                  marcador = 0;

                }
            }
        }else{
            if(e.getSource()== btnIniciar){
                iniciarJogo = true;
                contador = 0;
                contadorA = 0;
                marcador = 0;
                    etiqueta.setText("Marcador: " + marcador + " Record: " + cont);
                    criarCor();
            }
        }
    }

        public static void main(String[] args) {
            new Genius().setVisible(true);
        }
        
    }

   

