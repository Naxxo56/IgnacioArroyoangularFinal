import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Carrera {

    private JFrame frmCarrea;
    private JProgressBar pbCoche1;
    private JProgressBar pbCoche2;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JProgressBar pbCoche3;
    private JLabel lblNewLabel_2;
    private JTextField tfDistancia;
    private JButton btCorrer;
    private JLabel lblDistancia;
    private JLabel lbMarcador;
    private JLabel progresoCoche1;

    private void correr() {

        int distancia =
                Integer.parseInt(tfDistancia.getText());

        final Coche Opel = new Coche((int) (Math.random()*30), distancia, lbMarcador, "Opel");
        final Coche Ford = new Coche((int) (Math.random()*30), distancia, lbMarcador, "Ford");
        final Coche Seat = new Coche((int) (Math.random()*30), distancia, lbMarcador, "Seat");

        Opel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCoche1.setValue((Integer) event.getNewValue());
                    progresoCoche1.setText(
                            event.getNewValue() + " %");
                }
                if (event.getPropertyName().equals("ganador")) {
                    Ford.cancel(true);
                    Seat.cancel(true);
                }
            }
        });
        Ford.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCoche2.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    Opel.cancel(true);
                    Seat.cancel(true);
                }
            }
        });
        Seat.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCoche3.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    Opel.cancel(true);
                    Ford.cancel(true);
                }
            }
        });

        Opel.execute();
        Ford.execute();
        Seat.execute();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Carrera window = new Carrera();
                    window.frmCarrea.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Carrera() {
        initialize();
    }


    private void initialize() {
        frmCarrea = new JFrame();
        frmCarrea.setTitle("Carrera");
        frmCarrea.setBounds(100, 100, 450, 300);
        frmCarrea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCarrea.getContentPane().setLayout(null);
        frmCarrea.getContentPane().add(getPbCoche1());
        frmCarrea.getContentPane().add(getPbCoche2());
        frmCarrea.getContentPane().add(getLblNewLabel());
        frmCarrea.getContentPane().add(getLblNewLabel_1());
        frmCarrea.getContentPane().add(getPbCoche3());
        frmCarrea.getContentPane().add(getLblNewLabel_2());
        frmCarrea.getContentPane().add(getTfDistancia());
        frmCarrea.getContentPane().add(getBtCorrer());
        frmCarrea.getContentPane().add(getLblDistancia());
        frmCarrea.getContentPane().add(getLbMarcador());
        frmCarrea.getContentPane().add(getProgresoCoche1());
    }
    public JProgressBar getPbCoche1() {
        if (pbCoche1 == null) {
            pbCoche1 = new JProgressBar();
            pbCoche1.setBounds(10, 65, 422, 19);
        }
        return pbCoche1;
    }
    public JProgressBar getPbCoche2() {
        if (pbCoche2 == null) {
            pbCoche2 = new JProgressBar();
            pbCoche2.setBounds(10, 137, 422, 19);
        }
        return pbCoche2;
    }
    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("Opel");
            lblNewLabel.setBounds(10, 43, 46, 14);
        }
        return lblNewLabel;
    }
    public JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
            lblNewLabel_1 = new JLabel("Ford");
            lblNewLabel_1.setBounds(10, 114, 46, 14);
        }
        return lblNewLabel_1;
    }
    public JProgressBar getPbCoche3() {
        if (pbCoche3 == null) {
            pbCoche3 = new JProgressBar();
            pbCoche3.setString("34");
            pbCoche3.setBounds(10, 207, 422, 19);
        }
        return pbCoche3;
    }
    public JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
            lblNewLabel_2 = new JLabel("Seat");
            lblNewLabel_2.setBounds(10, 182, 46, 14);
        }
        return lblNewLabel_2;
    }
    public JTextField getTfDistancia() {
        if (tfDistancia == null) {
            tfDistancia = new JTextField();
            tfDistancia.setBounds(247, 12, 86, 20);
            tfDistancia.setColumns(10);
        }
        return tfDistancia;
    }
    public JButton getBtCorrer() {
        if (btCorrer == null) {
            btCorrer = new JButton("Correr");
            btCorrer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    correr();
                }
            });
            btCorrer.setBounds(343, 11, 89, 23);
        }
        return btCorrer;
    }
    public JLabel getLblDistancia() {
        if (lblDistancia == null) {
            lblDistancia = new JLabel("Distancia");
            lblDistancia.setBounds(176, 15, 72, 14);
        }
        return lblDistancia;
    }
    public JLabel getLbMarcador() {
        if (lbMarcador == null) {
            lbMarcador = new JLabel("");
            lbMarcador.setBounds(147, 241, 144, 14);
        }
        return lbMarcador;
    }
    public JLabel getProgresoCoche1() {
        if (progresoCoche1 == null) {
            progresoCoche1 = new JLabel("");
            progresoCoche1.setBounds(65, 40, 46, 14);
        }
        return progresoCoche1;
    }
}