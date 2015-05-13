import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.io.*;

public class Sokarbeidsgivervindu extends JFrame implements Serializable
{
 private JButton sokArbeidsgiver;
 private JTextField fornavntxt, etternavntxt, idtxt, bytxt, bransjetxt, firmatxt;
 private JTextArea utskrift;

 public Sokarbeidsgivervindu()
 {
  super("Arbeidsgivervindu");
  Knappelytter lytter = new Knappelytter();
  utskrift = new JTextArea(10,30);
  utskrift.setEditable(false);

  sokArbeidsgiver = new JButton("Sok arbeidsgiver");

  fornavntxt = new JTextField(5);
  etternavntxt = new JTextField(5);
  idtxt = new JTextField(5);
  bytxt = new JTextField(5);
  bransjetxt = new JTextField(5);
  firmatxt = new JTextField(5);

  sokArbeidsgiver.addActionListener(lytter);

  Container c = getContentPane();
  c.setLayout(new FlowLayout());

  c.add(new JLabel("Fornavn: "));
  c.add(fornavntxt);
  c.add(new JLabel("Etternavn: "));
  c.add(etternavntxt);
  c.add(new JLabel("Id: "));
  c.add(idtxt);
  c.add(new JLabel("By: "));
  c.add(bytxt);
  c.add(new JLabel("Bransje: "));
  c.add(bransjetxt);
  c.add(new JLabel("Firma: "));
  c.add(firmatxt);


  c.add(sokArbeidsgiver);
  c.add(utskrift);


  setSize(500,500);
  setVisible(true);
}


  public void sokArbeidsgiver()
  {
	  String fornavn = fornavntxt.getText();
	  String etternavn = etternavntxt.getText();

	  if (!fornavn.equals("") && !etternavn.equals(""))
	  {
		  Arbeidsregister sok = new Arbeidsregister();
		  List<Arbeidsgiver> navn = sok.sokpaArbeidsgiver(fornavn, etternavn);
		  utskrift.setText("Resultat: \n" + navn.toString());
	  }
		//Arbeidsregister arbeid = new Arbeidsregister();
		//Arbeidsgiver a = arbeid.sokpaBransje(bransjetxt.getText());
		//utskrift.setText("Resultat: \n" + a.toString());

  }

  private class Knappelytter implements ActionListener
  {
    public void actionPerformed ( ActionEvent e)
    {
      if (e.getSource() == sokArbeidsgiver)
      {
   		sokArbeidsgiver();
 	 }
	}
   }
}