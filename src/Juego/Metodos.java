package Juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Estructuras.*;
import Datos.*;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Denis
 */
public class Metodos {

    public String LeerArchivo(String Filtro_Archivo) {
        String aux = "";
        String texto = "";
        String Ruta = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser JfC = new JFileChooser();
            JfC.setAcceptAllFileFilterUsed(false);
            JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *." + Filtro_Archivo, Filtro_Archivo));
            JfC.setCurrentDirectory(new File("Escritorio"));
            JfC.showOpenDialog(null);
            /**
             * abrimos el archivo seleccionado
             */
            File Archivo = JfC.getSelectedFile();
            if (Archivo != null) {
                Ruta = "" + Archivo;
                FileReader FR = new FileReader(Archivo);
                try (BufferedReader Buffer = new BufferedReader(FR)) {
                    while ((aux = Buffer.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha podido leer el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    public String ObtenerContenidoArchivo(String Ruta) {
        String aux = "";
        String texto = "";
        try {
            File Archivo = new File(Ruta);
            if (Archivo != null) {
                Ruta = "" + Archivo;
                FileReader FR = new FileReader(Archivo);
                try (BufferedReader Buffer = new BufferedReader(FR)) {
                    while ((aux = Buffer.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha podido leer el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    public String SeleccionarArchivo(String Filtro_Archivo) {
        try {
            JFileChooser JfC = new JFileChooser();
            JfC.setAcceptAllFileFilterUsed(false);
            JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *." + Filtro_Archivo, Filtro_Archivo));
            JfC.setCurrentDirectory(new File("Escritorio"));
            JfC.showOpenDialog(null);
            String ruta = JfC.getSelectedFile().getAbsolutePath();
            return ruta;
        } catch (Exception E) {
            System.err.println("Error al abrir el archivo");
            return "";
        }
    }

    public void SepararNivelesPersonaje(String ContenidoArchivo) {
        String[] Lineas = ContenidoArchivo.split("\n"); //Separa el contenido de la cadena cada vez que encuntre un salto de linea
        for (String Linea : Lineas) {
            if (!"".equalsIgnoreCase(Linea.trim())) {
                String Tipo = Linea.trim().substring(0, 5); // Obtiene Los primeros 5 Caracteres de cada linea
                if ("NIVEL".equalsIgnoreCase(Tipo)) {
                    //Si es una linea de tipo nivel
                    GuardarNivel(Linea, PosVaciaListaNiveles(ListasDatos.LstNiveles), ListasDatos.LstNiveles);
                } else {// si es una linea de tip personaje
                    GuardarPersonaje(Linea, PosVaciaListaPersonajes(ListasDatos.LstPersonajes), ListasDatos.LstPersonajes);
                }
            }
        }
    }

    public int PosVaciaListaNiveles(ObjetoNivel[] _ListaNiveles) {
        for (int i = 0; i < _ListaNiveles.length; i++) {
            if (_ListaNiveles[i] == null) {
                return i;
            }
        }
        return -1;// si retorna -1, La lista esta llena
    }

    public int PosVaciaListaPersonajes(ObjetoPersonaje[] _ListaPersonaje) {
        for (int i = 0; i < _ListaPersonaje.length; i++) {
            if (_ListaPersonaje[i] == null) {
                return i;
            }
        }
        return -1;// si retorna -1, La lista esta llena
    }

    public void GuardarNivel(String ParametrosNivel, int PosGuardar, ObjetoNivel[] _LstNiveles) {
        try {
            ObjetoNivel Nivel = new ObjetoNivel();
            String Parametros = ParametrosNivel.substring(6, ParametrosNivel.length());// obtenemos los parametros a partir del caracter 6
            String[] ListaParametros = Parametros.split(",");// Separamos la cadena cada vez que encuentr una coma
            for (String Parametro : ListaParametros) {
                String[] ArregloValores = Parametro.trim().split(":");
                if (Parametro.trim().indexOf("nivel") == 0) {
                    Nivel.setNivel(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("distancia_maxima") == 0) {
                    Nivel.setDistancia_maxima(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("distancia_pantalla") == 0) {
                    Nivel.setDistancia_pantalla(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("velocidad_corriente") == 0) {
                    Nivel.setVelocidad_corriente(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("tiempo_nivel") == 0) {
                    Nivel.setTiempo_nivel(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("tiempo_sumergir") == 0) {
                    Nivel.setTiempo_sumergir(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("puntos_seleccion") == 0) {
                    Nivel.setPuntos_seleccion(ArregloValores[1]);
                }
                if (Parametro.trim().indexOf("puntos_sel_sumergir") == 0) {
                    Nivel.setPuntos_sel_sumergir(ArregloValores[1]);
                }
            }
            _LstNiveles[PosGuardar] = Nivel;
            System.out.println("Nivel Guardado");

        } catch (Exception E) {
            System.err.println("Error al guardar el Nivel...");
        }
    }

    public void GuardarPersonaje(String ParametrosPersonaje, int PosGuardar, ObjetoPersonaje[] _LstPersonajes) {
        try {
            ObjetoPersonaje Personaje = new ObjetoPersonaje();
            String Parametros = ParametrosPersonaje.substring(11, ParametrosPersonaje.length());// obtenemos los parametros a partir del caracter 11
            String separador = Pattern.quote("**");
            String[] ValoresParametros = Parametros.split(separador);// Separamos la cadena cada vez que encuentr dos asteriscos
            //Pos 0 = Nombre Personaje, pos 1= ruta imagen
            Personaje.setNombrePersonaje(ValoresParametros[0]);
            Personaje.setRutaPersonaje(ValoresParametros[1]);
            _LstPersonajes[PosGuardar] = Personaje;
            System.out.println("Personaje Guardado");
        } catch (Exception E) {
            System.err.println("Error al guardar el personaje...");
        }
    }

    public void ImprimirListaNiveles(ObjetoNivel[] _LstNiveles) {
        for (ObjetoNivel ONivel : _LstNiveles) {
            if (ONivel != null) {
                System.out.println(ONivel);
            }
        }
    }

    public void ImprimirListaPersonajes(ObjetoPersonaje[] _LstPersonajes) {
        for (ObjetoPersonaje OPersonaje : _LstPersonajes) {
            if (OPersonaje != null) {
                System.out.println(OPersonaje);
            }
        }
    }

    public void Agregar_Datos_A_Tabla(JTable Tabla, Object[] ArregloValores) {

        try {
            DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
            modelo.addRow(ArregloValores);
            Tabla.setModel(modelo);
        } catch (Exception EX) {
            System.out.println("" + EX.getMessage());
        } finally {

        }
    }
    
    
}
