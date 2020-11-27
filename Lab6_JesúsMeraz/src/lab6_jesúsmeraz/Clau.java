package lab6_jesúsmeraz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Clau {

    private String nombre;
    private File archivo = null;
    private ArrayList<ClaudiList> List = new ArrayList();

    public Clau() {
    }

    public Clau(String path) {
        archivo = new File(path);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<ClaudiList> getList() {
        return List;
    }

    public void setList(ArrayList<ClaudiList> List) {
        this.List = List;
    }

    @Override
    public String toString() {
        return "Universo{" + "nombre=" + nombre + ", archivo=" + archivo + ", Lista=" + List + '}';
    }

    public void EscribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (ClaudiList t : List) {
                bw.write(t.getNombre() + "|");
                bw.write(t.getTipo() + "|");
                bw.write(t.getGenero() + "|");
                bw.write(t.getPuntuacion() + "|");
                bw.write(t.getAños() + "|");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void CargarArchivo(JTextArea TextArea) {
        try {
            FileReader fr = null;
            BufferedReader br = null;
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                TextArea.append(linea);
                TextArea.append("\n");
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CargarArchivo2() {
        Scanner entrada = null;
        List = new ArrayList();
        if (archivo.exists()) {
            try {
                entrada = new Scanner(archivo);
                entrada.useDelimiter("|");
                while (entrada.hasNext()) {
                    List.add(new ClaudiList(entrada.next(), entrada.next(), entrada.next(), entrada.nextInt(), entrada.nextInt()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            entrada.close();
        }
    }
}
